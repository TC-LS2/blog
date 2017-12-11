package com.drpicox.blog.com.drpicox.blog.posts;

import com.drpicox.blog.posts.Post;
import com.drpicox.blog.posts.PostRepository;
import com.drpicox.blog.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostsHelper {

    @Autowired
    private PostRepository postRepository;

    public void cleanup() throws Exception {
        postRepository.deleteAllInBatch();
    }

    public Post make(String title) {
        return make(null, title, title + " body");
    }

    public Post make(String title, String body) {
        return make(null, title, body);
    }

    public Post make(User user, String title) {
        return make(user, title, title + " body");
    }

    public Post make(User user, String title, String body) {
        Post post = new Post(null, user, title, body);
        postRepository.save(post);
        return post;
    }
}
