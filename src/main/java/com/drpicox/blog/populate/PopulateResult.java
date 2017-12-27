package com.drpicox.blog.populate;

import com.drpicox.blog.comments.Comment;
import com.drpicox.blog.likes.Like;
import com.drpicox.blog.posts.Post;
import com.drpicox.blog.users.User;

import java.util.Collection;

public class PopulateResult {

    public Collection<Comment> comments;
    public Collection<Post> posts;
    public Collection<User> users;
    public Collection<Like> likes;

    public PopulateResult(Collection<Comment> comments, Collection<Post> posts, Collection<User> users,
                          Collection<Like> likes) {
        this.comments = comments;
        this.posts = posts;
        this.users = users;
        this.likes = likes;
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

    public Collection<Like> getLikes() {
        return likes;
    }
}
