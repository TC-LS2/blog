package com.drpicox.blog.postSteps;

import com.drpicox.blog.posts.Post;
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

/**
 * Created by Albert on 12/12/2017.
 */

@Entity
public class PostSteps {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    public PostSteps(Long id, Post post, String text) {
        this.id = id;
        this.post = post;
        this.text = text;
    }

    @JsonCreator
    public PostSteps(
        @JsonProperty("id") Long id,
        @JsonProperty("postId") Long postId,
        @JsonProperty("text") String text) {
        this(id, Post.withId(postId), text);
    }

    @JsonValue
    public Map getJsonObject() {
        Map result = new LinkedHashMap();
        result.put("id", id);
        result.put("postId", post != null ? post.getId() : null);
        result.put("text", text);
        return result;
    }

    public Long getId() {
        return id;
    }


    PostSteps() {}
}
