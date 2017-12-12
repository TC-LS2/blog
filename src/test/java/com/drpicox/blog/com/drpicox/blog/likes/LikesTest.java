package com.drpicox.blog.com.drpicox.blog.likes;

import com.drpicox.blog.RestHelper;
import com.drpicox.blog.com.drpicox.blog.users.UsersHelper;
import com.drpicox.blog.comments.Comment;
import com.drpicox.blog.comments.CommentRestController;
import com.drpicox.blog.likes.Likes;
import com.drpicox.blog.likes.LikesRestController;
import com.drpicox.blog.posts.Post;
import com.drpicox.blog.posts.PostRestController;
import com.drpicox.blog.users.User;
import com.drpicox.blog.users.UserRestController;
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

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class LikesTest {

    private MediaType contentType;

    private MockMvc mockMvc;

    @Autowired
    private RestHelper rest;

    @Autowired
    private LikesHelper likesHelper;

    @Autowired private UserRestController users;
    @Autowired private PostRestController posts;
    @Autowired private CommentRestController comments;
    @Autowired private LikesRestController likes;

    @Before
    public void setup() throws Exception {
        mockMvc = rest.createMockMvc();
        contentType = rest.getContentType();

        cleanup();
    }

    @After
    public void cleanup() throws Exception {
        likesHelper.cleanup();
    }

    @Test
    public void createUser() throws Exception {

        User cally = users.createUser(new User(null, "cally", "cally@caprica.ss"));
        Post post1 = posts.createPost(new Post(null, cally, "Alice is Here!", "fnewniofew fneiownfiew fneiow"));
        Comment comment1 = comments.createComment(new Comment(null, cally, post1, "youre welcome alice!"));

        String likeJson = json(new Likes(null, true, comment1, cally));

        this.mockMvc.perform(post("/likes")
            .contentType(contentType)
            .content(likeJson))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.commentId", isA(Number.class)))
            .andExpect(jsonPath("$.userId", isA(Number.class)))
            .andExpect(jsonPath("$.like", is(true)));
    }

    private String json(Object o) throws IOException {
        return rest.toJson(o);
    }

}
