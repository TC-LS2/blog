package com.drpicox.blog;

import com.drpicox.blog.comments.CommentRepository;
import com.drpicox.blog.comments.CommentRestController;
import com.drpicox.blog.populate.PopulateRestController;
import com.drpicox.blog.populate.PopulateResult;
import com.drpicox.blog.posts.PostRepository;
import com.drpicox.blog.posts.PostRestController;
import com.drpicox.blog.todos.TodoRepository;
import com.drpicox.blog.todos.TodoRestController;
import com.drpicox.blog.users.UserRepository;
import com.drpicox.blog.users.UserRestController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    private MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
        MediaType.APPLICATION_JSON.getSubtype(),
        Charset.forName("utf8"));

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private UserRestController users;

    @Autowired
    private PostRestController posts;

    @Autowired
    private CommentRestController comments;

    @Autowired
    private TodoRestController todos;

    @Autowired
    PopulateRestController populate;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);

        assertNotNull("the JSON message converter must not be null",
            this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext)
            .alwaysDo(MockMvcResultHandlers.print())
            .build();

        this.populate.populate();
    }

	@Test
	public void contextLoads() throws Exception { //tecnically in here we're testing all backend functions (users, posts, comments and todos)

        PopulateResult populateResult =  new PopulateResult(
            comments.getComments(),
            posts.getPosts(),
            users.getUsers(),
            todos.getTodos()
        );

        this.mockMvc.perform(get("/populate")
            .contentType(contentType)
            .content(json(populateResult)))
            .andExpect(status().isOk());
	}

	//method used to parse an Object to JSON
    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
            o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

}
