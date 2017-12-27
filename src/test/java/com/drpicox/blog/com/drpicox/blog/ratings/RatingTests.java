package com.drpicox.blog.com.drpicox.blog.ratings;


import com.drpicox.blog.RestHelper;
import com.drpicox.blog.com.drpicox.blog.posts.PostsHelper;
import com.drpicox.blog.com.drpicox.blog.users.UsersHelper;
import com.drpicox.blog.posts.Post;
import com.drpicox.blog.ratings.Rating;
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

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Josh Long
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RatingTests {


    private MediaType contentType;

    private MockMvc mockMvc;

    @Autowired
    private RestHelper rest;

    @Autowired
    private RatingsHelper ratings;

    @Autowired
    private PostsHelper posts;

    @Autowired
    private UsersHelper users;


    @Before
    public void setup() throws Exception {
        this.mockMvc = rest.createMockMvc();
        this.contentType = rest.getContentType();

        ratings.cleanup();
    }


    @Test
    public void createRating() throws Exception {
        User bea = users.make("bea");
        User cally = users.make("cally");
        Post post = posts.make(cally, "post");
        String commentJson = json(new Rating(5, post, bea));

        this.mockMvc.perform(post("/ratings")
                .contentType(contentType)
                .content(commentJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.rating", is(5)))
                .andExpect(jsonPath("$.id", isA(Number.class)))
                .andExpect(jsonPath("$.authorId", is(bea.getId().intValue())))
                .andExpect(jsonPath("$.postId", is(post.getId().intValue())));
    }


    @Test
    public void getRatings() throws Exception {
        User bea = users.make("bea");
        Rating rating1 = ratings.stub(bea, 5);
        Rating rating2 = ratings.stub(bea, 1);

        this.mockMvc.perform(get("/ratings/" + bea.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", contains(object(rating1), object(rating2))));
    }

    private String json(Object o) throws IOException {
        return rest.toJson(o);
    }

    private Object object(Object o) throws IOException {
        return rest.eraseType(o);
    }
}
