package com.drpicox.blog.todos;

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
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    private String body;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User author;

    public Todo(Long id, User author, String body) {
        this.id = id;
        this.author = author;
        this.body = body;
    }

    public static Todo withId(Long postId) {
        if (postId == null) return null;

        return new Todo(postId, (User) null, null);
    }

    @JsonCreator
    public Todo(
        @JsonProperty("id") Long id,
        @JsonProperty("authorId") Long authorId,
        @JsonProperty("body") String body) {
        this(id, User.withId(authorId), body);
    }

    @JsonValue
    public Map getJsonObject() {
        Map result = new LinkedHashMap();
        result.put("id", id);
        result.put("body", body);
        result.put("authorId", author != null ? author.getId() : null);
        return result;
    }

    public Long getId() {
        return id;
    }

}
