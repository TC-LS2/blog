package com.drpicox.blog.com.drpicox.blog.reports;


import com.drpicox.blog.RestHelper;
import com.drpicox.blog.com.drpicox.blog.posts.PostsHelper;
import com.drpicox.blog.com.drpicox.blog.users.UsersHelper;
import com.drpicox.blog.reports.Report;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Josh Long
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ReportsTests {


    private MediaType contentType;

    private MockMvc mockMvc;

    @Autowired
    private RestHelper rest;

    @Autowired
    private ReportsHelper reports;

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
        reports.cleanup();
        posts.cleanup();
        users.cleanup();
    }


    @Test
    public void createReport() throws Exception {
        Post post = posts.make("A post title");
        User bea = users.make("bea");
        String postJson = json(new Report(null, "a reason", post, bea));

        this.mockMvc.perform(post("/reports")
                .contentType(contentType)
                .content(postJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.reason", is("a reason")))
                .andExpect(jsonPath("$.id", isA(Number.class)))
                .andExpect(jsonPath("$.user", is(bea.getId().intValue())))
                .andExpect(jsonPath("$.post", is(post.getId().intValue())));
    }

    @Test
    public void getReports() throws Exception {
        User user = users.make("name");
        Post post = posts.make("title", "post body");
        Report report1 = reports.make("one report", post, user);
        Report report2 = reports.make("other report", post, user);

        this.mockMvc.perform(get("/reports"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", containsInAnyOrder(object(report1), object(report2))));
    }

    private String json(Object o) throws IOException {
        return rest.toJson(o);
    }

    private Object object(Object o) throws IOException {
        return rest.eraseType(o);
    }
}
