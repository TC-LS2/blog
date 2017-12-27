package com.drpicox.blog.ratings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/ratings")
public class RatingRestController {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    public RatingRestController(){

    }

    @GetMapping("/{userId}")
    public Collection<Rating> getComments() {
        System.out.println("getMapping");
        System.out.println(ratingRepository.findAll());
        return ratingRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rating createRating(@RequestBody Rating rating){
        ratingRepository.save(rating);
        return rating;
    }


}
