package com.drpicox.blog.likes;

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
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Likes {

    @Id
    @GeneratedValue
    private Long id;

    private boolean like;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Comment comment;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Likes(Long id, boolean like, Comment comment, User commenter) {
        this.id = id;
        this.like = like;
        this.comment = comment;
        this.user = commenter;
    }

    @JsonCreator
    public Likes(
        @JsonProperty("id") Long id,
        @JsonProperty("like") boolean like,
        @JsonProperty("commentId") Long commentId,
        @JsonProperty("userId") Long userId) {
        this(id, like, Comment.withId(commentId), User.withId(userId));
    }

    @JsonValue
    public Map getJsonObject() {
        Map result = new LinkedHashMap();
        result.put("id", id);
        result.put("commentId", comment != null ? comment.getId() : null);
        result.put("userId", user != null ? user.getId() : null);
        result.put("like", like);
        return result;
    }

    public Long getId() {
        return id;
    }

    public boolean isLike() {
        return like;
    }

    public Comment getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    Likes() {

    }

}
