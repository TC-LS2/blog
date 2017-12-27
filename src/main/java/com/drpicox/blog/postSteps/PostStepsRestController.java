package com.drpicox.blog.postSteps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Albert on 12/12/2017.
 */
@RestController
@RequestMapping("/postSteps")
public class PostStepsRestController {

    @Autowired
    private PostStepsRepository postStepsRepository;

    @Autowired
    public PostStepsRestController() {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostSteps createPostSteps(@RequestBody PostSteps postSteps) {
        postStepsRepository.save(postSteps);
        return postSteps;
    }

    @GetMapping()
    public Collection<PostSteps> getPostSteps() {
        return postStepsRepository.findAllByOrderByIdDesc();
    }

    @GetMapping("/{postStepsId}")
    public PostSteps getPostStep(@PathVariable Long commentId) {
        PostSteps postSteps = postStepsRepository.findOne(commentId);
        return postSteps;
    }

}
