package com.drpicox.blog.com.drpicox.blog.interactions;


import com.drpicox.blog.RestHelper;
import com.drpicox.blog.com.drpicox.blog.posts.PostsHelper;
import com.drpicox.blog.com.drpicox.blog.users.UsersHelper;
import com.drpicox.blog.interactions.Interaction;
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
public class InteractionsTests {


    private MediaType contentType;

    private MockMvc mockMvc;

    @Autowired
    private RestHelper rest;

    @Autowired
    private InteractionHelper likes;

    @Autowired
    private PostsHelper posts;

    @Autowired
    private UsersHelper users;


    @Before
    public void setup() throws Exception {
        this.mockMvc = rest.createMockMvc();
        this.contentType = rest.getContentType();
        likes.cleanup();
    }


    @Test
    public void createLike() throws Exception {
        User bea = users.make("bea");
        User cally = users.make("cally");
        Post post = posts.make(cally, "post");
        String likeJson = json(new Interaction(null,bea,post,true));

        this.mockMvc.perform(post("/interactions")
                .contentType(contentType)
                .content(likeJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.like", is("true")))
                .andExpect(jsonPath("$.id", isA(Number.class)))
                .andExpect(jsonPath("$.likerId", is(bea.getId().intValue())))
                .andExpect(jsonPath("$.postId", is(post.getId().intValue())));
    }

    @Test
    public void getLike() throws Exception {
        Interaction expectedInteraction = likes.stub(true);

        this.mockMvc.perform(get("/interactions/" + expectedInteraction.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(object(expectedInteraction))));
    }

    @Test
    public void getLikes() throws Exception {
        Interaction interaction1 = likes.stub(true);
        Interaction interaction2 = likes.stub(true);

        this.mockMvc.perform(get("/interactions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", contains(object(interaction1), object(interaction2))));
    }

    @Test
    public void undoLike() throws Exception {
        Long likeId = likes.stub(true).getId();

        this.mockMvc.perform(delete("/interactions/" + likeId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(likeId.intValue())));

        this.mockMvc.perform(get("/comments"))
                .andExpect(jsonPath("$.length()", is(0)));
    }

    private String json(Object o) throws IOException {
        return rest.toJson(o);
    }

    private Object object(Object o) throws IOException {
        return rest.eraseType(o);
    }
}

