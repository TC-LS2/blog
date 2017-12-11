package com.drpicox.blog.com.drpicox.blog.users;


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
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Josh Long
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UsersTests {

    private MediaType contentType;

    private MockMvc mockMvc;

    @Autowired
    private RestHelper rest;

    @Autowired
    private UsersHelper users;

    @Before
    public void setup() throws Exception {
        mockMvc = rest.createMockMvc();
        contentType = rest.getContentType();

        cleanup();
    }

    @After
    public void cleanup() throws Exception {
        users.cleanup();
    }

    @Test
    public void createUser() throws Exception {
        String userJson = json(new User(null,
                "bea", "bea@example.com"));

        this.mockMvc.perform(post("/users")
                .contentType(contentType)
                .content(userJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("bea")))
                .andExpect(jsonPath("$.email", is("bea@example.com")))
                .andExpect(jsonPath("$.id", isA(Number.class)));
    }

    @Test
    public void getUsers() throws Exception {
        User user1 = users.make("n1", "n1");
        User user2 = users.make("n2", "n2");

        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", containsInAnyOrder(object(user1), object(user2))));
    }


    private String json(Object o) throws IOException {
        return rest.toJson(o);
    }

    private Object object(Object o) throws IOException {
        return rest.eraseType(o);
    }
}