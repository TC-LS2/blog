package com.drpicox.blog.comments;

import com.drpicox.blog.posts.Post;
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
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String body;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User commenter;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    public Comment(Long id, User commenter, Post post, String body) {
        this.id = id;
        this.commenter = commenter;
        this.post = post;
        this.body = body;
    }

    public static Comment withId(Long commentId) {
        if (commentId == null) return null;

        return new Comment(commentId, (User) null, null, null);
    }

    @JsonCreator
    public Comment(
            @JsonProperty("id") Long id,
            @JsonProperty("commenterId") Long commenterId,
            @JsonProperty("postId") Long postId,
            @JsonProperty("body") String body) {
        this(id, User.withId(commenterId), Post.withId(postId), body);
    }

    @JsonValue
    public Map getJsonObject() {
        Map result = new LinkedHashMap();
        result.put("id", id);
        result.put("commenterId", commenter != null ? commenter.getId() : null);
        result.put("postId", post != null ? post.getId() : null);
        result.put("body", body);
        return result;
    }

    public Long getId() {
        return id;
    }


    Comment() {}

}
