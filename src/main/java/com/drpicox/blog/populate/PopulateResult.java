package com.drpicox.blog.populate;

import com.drpicox.blog.comments.Comment;
import com.drpicox.blog.interactions.Interaction;
import com.drpicox.blog.posts.Post;
import com.drpicox.blog.users.User;

import java.util.Collection;

public class PopulateResult {

    public Collection<Comment> comments;
    public Collection<Post> posts;
    public Collection<User> users;
    public Collection<Interaction> interactions;


    public PopulateResult(Collection<Comment> comments, Collection<Post> posts, Collection<User> users, Collection<Interaction> interactions) {
        this.comments = comments;
        this.posts = posts;
        this.users = users;
        this.interactions = interactions;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public Collection<Interaction> getInteractions() { return interactions; }

}
