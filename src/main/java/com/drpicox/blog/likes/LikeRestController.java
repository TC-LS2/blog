package com.drpicox.blog.likes;

import com.drpicox.blog.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/likes")
public class LikeRestController {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    public LikeRestController() {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Like createLike(@RequestBody Like like) {
        likeRepository.save(like);
        return like;
    }

    @GetMapping
    public Collection<Like> getLikes() {
        return likeRepository.findAll();
    }

}
