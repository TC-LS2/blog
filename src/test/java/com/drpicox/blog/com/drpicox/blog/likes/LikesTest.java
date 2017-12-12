package com.drpicox.blog.com.drpicox.blog.likes;


import com.drpicox.blog.RestHelper;
import com.drpicox.blog.com.drpicox.blog.users.UsersHelper;
import com.drpicox.blog.likes.Like;
import com.drpicox.blog.likes.LikeRepository;
import com.drpicox.blog.likes.LikeRestController;
import com.drpicox.blog.posts.Post;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Josh Long
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class LikesTest {


    private MediaType contentType;

    private MockMvc mockMvc;

    @Autowired
    private RestHelper rest;

    @Autowired
    private UsersHelper users;

    @Autowired
    private LikeRepository likes;


    @Before
    public void setup() throws Exception {
        this.mockMvc = rest.createMockMvc();
        this.contentType = rest.getContentType();

        cleanup();
    }

    @After
    public void cleanup() throws Exception {
        likes.deleteAllInBatch();
        users.cleanup();
    }


    @Test
    public void createLike() throws Exception {
        User giver = users.make("Pepito");
        User receiver = users.make("Mark");

        String userJson = json(new Like(giver, receiver, false));

        this.mockMvc.perform(post("/likes")
            .contentType(contentType)
            .content(userJson))
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.giverId", is(new Integer(giver.getId().toString()))))
            .andExpect(jsonPath("$.receiverId", is(new Integer(receiver.getId().toString()))))
            .andExpect(jsonPath("$.value", is(false)));
    }

    @Test
    public void getLikes() throws Exception{
        User user1 = users.make("n1", "n1");
        User user2 = users.make("n2", "n2");
        Like like1 = likes.save(new Like(user1, user2, false));
        Like like2 = likes.save(new Like(user2, user1, true));

        this.mockMvc.perform(get("/likes"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", containsInAnyOrder(object(like1), object(like2))));
    }

    private String json(Object o) throws IOException {
        return rest.toJson(o);
    }

    private Object object(Object o) throws IOException {
        return rest.eraseType(o);
    }
}
