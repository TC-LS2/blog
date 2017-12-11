package com.drpicox.blog.com.drpicox.blog.comments;

import com.drpicox.blog.comments.Comment;
import com.drpicox.blog.comments.CommentRepository;
import com.drpicox.blog.posts.Post;
import com.drpicox.blog.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentsHelper {

    @Autowired
    private CommentRepository commentRepository;

    public void cleanup() throws Exception {
        commentRepository.deleteAllInBatch();
    }

    public Comment stub(String body) {
        return stub(null, null, body);
    }

    public Comment stub(Post post, String body) {
        return stub(null, post, body);
    }

    public Comment stub(User user, String body) {
        return stub(user, null, body);
    }

    public Comment stub(User user, Post post, String body) {
        Comment comment = new Comment(null, user, post, body);
        commentRepository.save(comment);
        return comment;
    }
}
