package com.drpicox.blog.reports;

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
public class Report {

    @Id
    @GeneratedValue
    private Long id;

    private String reason;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Report() {} // JPA only

    public Report(Long id, String reason, Post post, User user) {
        this.id = id;
        this.reason = reason;
        this.post = post;
        this.user = user;
    }

    @JsonCreator
    public Report(
        @JsonProperty("id") Long id,
        @JsonProperty ("reason") String reason,
        @JsonProperty("post") Long postId,
        @JsonProperty("user") Long userId) {
        this(id, reason, Post.withId(postId), User.withId(userId));
    }

    @JsonValue
    public Map getJsonObject() {
        Map result = new LinkedHashMap();
        result.put("id", id);
        result.put("reason", reason);
        result.put("post", post != null ? post.getId() : null);
        result.put("user", user != null ? user.getId() : null);
        return result;
    }

    public Long getId() { return  id; }

}
