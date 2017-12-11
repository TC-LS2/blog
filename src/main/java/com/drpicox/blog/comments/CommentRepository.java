package com.drpicox.blog.comments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    public Collection<Comment> findAllByOrderByIdDesc();
    Collection<Comment> findByCommenterId(Long id);
    Collection<Comment> findByPostId(Long id);
}
