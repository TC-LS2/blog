package com.drpicox.blog.likes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    public Collection<Likes> findAllByOrderByIdDesc();

}
