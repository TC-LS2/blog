package com.drpicox.blog.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PostRepository extends JpaRepository<Post, Long> {

    public Collection<Post> findAllByOrderByIdDesc();
}
