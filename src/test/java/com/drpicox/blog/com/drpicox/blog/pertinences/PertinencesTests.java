package com.drpicox.blog.com.drpicox.blog.pertinences;


import com.drpicox.blog.Pertinensa.Pertinensa;
import com.drpicox.blog.Pertinensa.PertinensaRepository;
import com.drpicox.blog.RestHelper;
import com.drpicox.blog.com.drpicox.blog.users.UsersHelper;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Josh Long
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PertinencesTests {


    private MediaType contentType;

    private MockMvc mockMvc;

    @Autowired
    private RestHelper rest;

    @Autowired
    private PertinensaRepository pertinensaRepository;

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

        users.cleanup();
    }

    @Test
    public void getPertinences() throws Exception {
        User bea = users.make("bea");
        Pertinensa pertinensa1 = new Pertinensa(null,bea,"new pertinence for bea");
        Pertinensa pertinensa2 = new Pertinensa(null, bea,"second pertinence for bea");
        this.pertinensaRepository.save(pertinensa1);
        this.pertinensaRepository.save(pertinensa2);
        this.mockMvc.perform(get("/pertinences"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", contains(object(pertinensa1), object(pertinensa2))));
    }

    @Test
    public void getPertinencesById() throws Exception {
        User bea = users.make("bea");
        User alice = users.make("alice");
        Pertinensa pertinensa1 = new Pertinensa(null,alice,"new pertinence for alice");
        Pertinensa pertinensa2 = new Pertinensa(null, bea,"new pertinence for bea");
        this.pertinensaRepository.save(pertinensa1);
        this.pertinensaRepository.save(pertinensa2);
        this.mockMvc.perform(get("/pertinences/"+alice.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", contains(object(pertinensa1))));
    }

    private String json(Object o) throws IOException {
        return rest.toJson(o);
    }

    private Object object(Object o) throws IOException {
        return rest.eraseType(o);
    }
}
