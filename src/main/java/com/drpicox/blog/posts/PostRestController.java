package com.drpicox.blog.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/posts")
public class PostRestController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    public PostRestController() {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }

    @GetMapping()
    public Collection<Post> getPosts() {
        return postRepository.findAllByOrderByIdDesc();
    }
}
