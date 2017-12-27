package com.drpicox.blog.com.drpicox.blog.populate;


import com.drpicox.blog.RestHelper;
import com.drpicox.blog.com.drpicox.blog.comments.CommentsHelper;
import com.drpicox.blog.com.drpicox.blog.posts.PostsHelper;
import com.drpicox.blog.com.drpicox.blog.users.UsersHelper;
import com.drpicox.blog.populate.PopulateResult;
import com.drpicox.blog.posts.Post;
import com.drpicox.blog.users.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Josh Long
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PopulateTests {


    private MediaType contentType;

    private MockMvc mockMvc;

    @Autowired
    private RestHelper rest;

    @Autowired
    private CommentsHelper comments;

    @Autowired
    private PostsHelper posts;

    @Autowired
    private UsersHelper users;


    @Before
    public void setup() throws Exception {
        this.mockMvc = rest.createMockMvc();
        this.contentType = rest.getContentType();

        comments.cleanup();
        posts.cleanup();
        users.cleanup();
    }

    @Test
    public void populateShouldAddElements() throws Exception {
        this.mockMvc.perform(get("/populate"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.comments.length()", is(greaterThan(0))))
                .andExpect(jsonPath("$.posts.length()", is(greaterThan(0))))
                .andExpect(jsonPath("$.users.length()", is(greaterThan(0))))
                .andExpect(jsonPath("$.pertinences.length()", is(greaterThan(0))));
    }

    @Test
    public void populateShouldNoAddElementsIfThereWasSomePost() throws Exception {
        posts.make("some post");

        this.mockMvc.perform(get("/populate"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.comments.length()", is(0)))
                .andExpect(jsonPath("$.posts.length()", is(1)))
                .andExpect(jsonPath("$.users.length()", is(0)));
    }


    @Test
    public void populateShouldReturnTheSameThatOtherGetters() throws Exception {
        String jsonResult = this.mockMvc.perform(get("/populate"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Map result = rest.fromJson(jsonResult);

        // Note that verifies the correct output against well tested services
        this.mockMvc.perform(get("/comments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(result.get("comments"))));

        this.mockMvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(result.get("posts"))));

        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(result.get("users"))));
    }

}
