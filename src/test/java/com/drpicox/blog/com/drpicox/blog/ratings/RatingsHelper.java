package com.drpicox.blog.com.drpicox.blog.ratings;

import com.drpicox.blog.posts.Post;
import com.drpicox.blog.ratings.Rating;
import com.drpicox.blog.ratings.RatingRepository;
import com.drpicox.blog.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RatingsHelper {

    @Autowired
    private RatingRepository ratingRepository;

    public void cleanup() throws Exception {
        ratingRepository.deleteAllInBatch();
    }

    public Rating stub(Integer rate) {
        return stub(rate, null, null);
    }

    public Rating stub(Post post, Integer rate) {
        return stub(rate, post, null);
    }

    public Rating stub(User user, Integer rate) {
        return stub(rate, null, user);
    }

    public Rating stub(Integer rate, Post post, User user) {
        Rating rating = new Rating(null, rate, post, user);
        ratingRepository.save(rating);
        return rating;
    }
}
