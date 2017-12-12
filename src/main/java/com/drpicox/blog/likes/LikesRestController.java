package com.drpicox.blog.likes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/likes")
public class LikesRestController {

    @Autowired
    private LikesRepository likesRepository;

    @GetMapping()
    public Collection<Likes> getLikes () {
        return this.likesRepository.findAllByOrderByIdDesc();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Likes createLike(@RequestBody Likes likes) {
        likesRepository.save(likes);
        return likes;
    }

}
