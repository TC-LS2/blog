package com.drpicox.blog.com.drpicox.blog.comments;


import com.drpicox.blog.RestHelper;
import com.drpicox.blog.com.drpicox.blog.posts.PostsHelper;
import com.drpicox.blog.com.drpicox.blog.users.UsersHelper;
import com.drpicox.blog.comments.Comment;
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
public class CommentsTests {


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
    }


    @Test
    public void createComment() throws Exception {
        User bea = users.make("bea");
        User cally = users.make("cally");
        Post post = posts.make(cally, "post");
        String commentJson = json(new Comment(null, bea, post, "this is my comment"));

        this.mockMvc.perform(post("/comments")
                .contentType(contentType)
                .content(commentJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.body", is("this is my comment")))
                .andExpect(jsonPath("$.id", isA(Number.class)))
                .andExpect(jsonPath("$.commenterId", is(bea.getId().intValue())))
                .andExpect(jsonPath("$.postId", is(post.getId().intValue())));
    }

    @Test
    public void getComment() throws Exception {
        Comment expectedComment = comments.stub("body");

        this.mockMvc.perform(get("/comments/" + expectedComment.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(object(expectedComment))));
    }

    @Test
    public void getComments() throws Exception {
        Comment comment1 = comments.stub("b1");
        Comment comment2 = comments.stub("b2");

        this.mockMvc.perform(get("/comments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", contains(object(comment2), object(comment1))));
    }

    @Test
    public void deleteComment() throws Exception {
        Long commentId = comments.stub("some body").getId();

        this.mockMvc.perform(delete("/comments/" + commentId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(commentId.intValue())));

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