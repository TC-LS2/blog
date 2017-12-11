package com.drpicox.blog.com.drpicox.blog.posts;


import com.drpicox.blog.com.drpicox.blog.users.UsersHelper;
import com.drpicox.blog.posts.Post;
import com.drpicox.blog.RestHelper;
import com.drpicox.blog.users.User;
import org.junit.After;
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

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Josh Long
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PostsTests {


    private MediaType contentType;

    private MockMvc mockMvc;

    @Autowired
    private RestHelper rest;

    @Autowired
    private PostsHelper posts;

    @Autowired
    private UsersHelper users;


    @Before
    public void setup() throws Exception {
        this.mockMvc = rest.createMockMvc();
        this.contentType = rest.getContentType();

        cleanup();
    }

    @After
    public void cleanup() throws Exception {
        posts.cleanup();
        users.cleanup();
    }


    @Test
    public void createPost() throws Exception {
        User bea = users.make("bea");
        String postJson = json(new Post(null, bea,
                "hello", "this is my first post"));

        this.mockMvc.perform(post("/posts")
                .contentType(contentType)
                .content(postJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", is("hello")))
                .andExpect(jsonPath("$.body", is("this is my first post")))
                .andExpect(jsonPath("$.id", isA(Number.class)))
                .andExpect(jsonPath("$.authorId", is(bea.getId().intValue())));
    }

    @Test
    public void getPosts() throws Exception {
        Post post1 = posts.make("t1", "b1");
        Post post2 = posts.make("t2", "b2");

        this.mockMvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", contains(object(post2), object(post1))));
    }

    private String json(Object o) throws IOException {
        return rest.toJson(o);
    }

    private Object object(Object o) throws IOException {
        return rest.eraseType(o);
    }
}