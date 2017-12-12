package com.drpicox.blog.populate;

import com.drpicox.blog.comments.Comment;
import com.drpicox.blog.users.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Alvaro Costa Sanchez on 12/12/2017.
 */
@Entity
public class Populate {

    @Id
    @GeneratedValue
    private Long id;

    @Min(0)
    @Max(5)
    private int rating;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Comment comment;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Populate(Long id, int rating, Comment comment, User user) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.user = user;
    }

    @JsonCreator
    public Populate(
        @JsonProperty("id") Long id,
        @JsonProperty("rating") int rating,
        @JsonProperty("commentId") Long commentId,
        @JsonProperty("userId") Long userId) {
        this(id, rating, Comment.withId(commentId), User.withId(userId));
    }

    @JsonValue
    public Map getJsonObject() {
        Map result = new LinkedHashMap();
        result.put("id", id);
        result.put("rating", rating);
        result.put("commentId", comment != null ? comment.getId() : null);
        result.put("userId", user != null ? user.getId() : null);
        return result;
    }

    public Long getId() {
        return id;
    }

    Populate() {}
}
