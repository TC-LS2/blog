package com.drpicox.blog.interactions;

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
public class Interaction {

    @Id
    @GeneratedValue
    private Long id;

    private Boolean value;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User liker;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    public Interaction(Long id, User liker, Post post, boolean value) {
        this.id = id;
        this.liker = liker;
        this.post = post;
        this.value = value;
    }

    @JsonCreator
    public Interaction(
            @JsonProperty("id") Long id,
            @JsonProperty("likerId") Long likerId,
            @JsonProperty("postId") Long postId,
            @JsonProperty("value") boolean value) {
        this(id, User.withId(likerId), Post.withId(postId), value);
    }

    @JsonValue
    public Map getJsonObject() {
        Map result = new LinkedHashMap();
        result.put("id", id);
        result.put("likerId", liker != null ? liker.getId() : null);
        result.put("postId", post != null ? post.getId() : null);
        result.put("value", value);
        return result;
    }

    public Long getId() {
        return id;
    }

    public boolean getLike(){ return this.value;}


    Interaction() {}

}
