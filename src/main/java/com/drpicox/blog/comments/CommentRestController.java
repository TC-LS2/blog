package com.drpicox.blog.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/comments")
public class CommentRestController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    public CommentRestController() {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return comment;
    }

    @GetMapping()
    public Collection<Comment> getComments() {
        return commentRepository.findAllByOrderByIdDesc();
    }

    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable Long commentId) {
        Comment comment = commentRepository.findOne(commentId);
        return comment;
    }

    @DeleteMapping("/{commentId}")
    public Comment deleteComment(@PathVariable Long commentId) {
        Comment comment = getComment(commentId);
        commentRepository.delete(commentId);
        return comment;
    }
}
