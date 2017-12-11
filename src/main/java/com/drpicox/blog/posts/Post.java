package com.drpicox.blog.posts;

import com.drpicox.blog.users.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String body;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User author;

    public Post(Long id, User author, String title, String body) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.body = body;
    }

    public static Post withId(Long postId) {
        if (postId == null) return null;

        return new Post(postId, (User) null, null, null);
    }

    @JsonCreator
    public Post(
            @JsonProperty("id") Long id,
            @JsonProperty("authorId") Long authorId,
            @JsonProperty("title") String title,
            @JsonProperty("body") String body) {
        this(id, User.withId(authorId), title, body);
    }

    @JsonValue
    public Map getJsonObject() {
        Map result = new LinkedHashMap();
        result.put("id", id);
        result.put("title", title);
        result.put("body", body);
        result.put("authorId", author != null ? author.getId() : null);
        return result;
    }

    public Long getId() {
        return id;
    }


    Post() {}
}
