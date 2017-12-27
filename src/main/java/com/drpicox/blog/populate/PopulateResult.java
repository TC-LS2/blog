package com.drpicox.blog.populate;

import com.drpicox.blog.comments.Comment;
import com.drpicox.blog.likes.Likes;
import com.drpicox.blog.posts.Post;
import com.drpicox.blog.users.User;

import java.util.Collection;

public class PopulateResult {

    public Collection<Comment> comments;
    public Collection<Post> posts;
    public Collection<User> users;
    public Collection<Likes> likes;

    public PopulateResult(Collection<Comment> comments, Collection<Post> posts, Collection<User> users, Collection<Likes> likes) {
        this.comments = comments;
        this.posts = posts;
        this.users = users;
        this.likes = likes;
    }

    public PopulateResult(Collection<Comment> comments, Collection<Post> posts, Collection<User> users) {
        this.comments = comments;
        this.posts = posts;
        this.users = users;
    }

    public Collection<Likes> getLikes() {
        return likes;
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



}
