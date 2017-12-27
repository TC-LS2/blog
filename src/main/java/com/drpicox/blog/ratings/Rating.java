package com.drpicox.blog.ratings;


import com.drpicox.blog.posts.Post;
import com.drpicox.blog.users.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Rating {

    @Id
    @GeneratedValue
    private Long id;

    Integer rating;

    @OneToOne
    Post post;

    @OneToOne
    User user;

    public Rating() {
    }

    public Rating(Integer rating, Post post, User user) {
        this.rating = rating;
        this.post = post;
        this.user = user;
    }

    public Rating(Long id, Integer rating, Post post, User user) {
        this.id = id;
        this.rating = rating;
        this.post = post;
        this.user = user;
    }

    @JsonCreator
    public Rating(
        @JsonProperty("id") Long id,
        @JsonProperty("rating") Integer rating,
        @JsonProperty("postId") Long postId,
        @JsonProperty("authorId") Long authorId) {
        this(id, rating, Post.withId(postId), User.withId(authorId));
    }

    @JsonValue
    public Map getJsonObject() {
        Map result = new LinkedHashMap();
        result.put("id", id);
        result.put("rating", rating);
        result.put("postId", post != null ? post.getId() : null);
        result.put("authorId", user != null ? user.getId() : null);
        return result;
    }

    @Override
    public String toString() {
        return "Rating{" +
            "id=" + id +
            ", rating=" + rating +
            ", post=" + post +
            ", user=" + user +
            '}';
    }
}
