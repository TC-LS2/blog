package com.drpicox.blog.Pertinensa;

import com.drpicox.blog.posts.Post;
import com.drpicox.blog.users.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Àlex on 12/12/2017.
 */
@Entity
public class Pertinensa {

        @Id
        @GeneratedValue
        private Long id;

        private String text;

        @ManyToOne
        @OnDelete(action = OnDeleteAction.CASCADE)
        private User associate;


        public Pertinensa(Long id, User associate, String text) {
            this.id = id;
            this.associate = associate;
            this.text = text;
        }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public User getAssociate() {
        return associate;
    }

@JsonCreator
    public Pertinensa(
        @JsonProperty("id") Long id,
        @JsonProperty("associateId") Long associateId,
        @JsonProperty("text") String text) {
        this(id, User.withId(associateId), text);
    }

       public Pertinensa(){

       }

}
