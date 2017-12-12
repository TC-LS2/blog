package com.drpicox.blog.likes;

import com.drpicox.blog.users.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity(name="OneLike")
public class Like {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User giver;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User receiver;

    private boolean value;


    public Like(User giver, User receiver, boolean value) {
        this.giver = giver;
        this.receiver = receiver;
        this.value = value;
    }

    public Like(Long id, User giver, User receiver, boolean value) {
        this.id = id;
        this.giver = giver;
        this.receiver = receiver;
        this.value = value;
    }

    public static Like withId(Long likeId) {
        if (likeId == null) return null;

        return new Like(likeId, (User) null, (User) null, false);
    }


    @JsonCreator
    public Like(
        @JsonProperty("id") Long id,
        @JsonProperty("giverId") Long giverId,
        @JsonProperty("receiverId") Long receiverId,
        @JsonProperty("value") Boolean value) {
        this(id, User.withId(giverId), User.withId(receiverId), value);
    }

    @JsonValue
    public Map getJsonObject() {
        Map result = new LinkedHashMap();
        result.put("id", id);
        result.put("giverId", giver != null ? giver.getId() : null);
        result.put("receiverId", receiver != null ? receiver.getId() : null);
        result.put("value", value);
        return result;
    }

    public Long getId() {
        return id;
    }

    Like() {}
}
