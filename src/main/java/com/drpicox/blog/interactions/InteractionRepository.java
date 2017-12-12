package com.drpicox.blog.interactions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {

    public Collection<Interaction> findAllByOrderByIdDesc();
    Collection<Interaction> findByLikerId(Long id);
    Collection<Interaction> findByPostId(Long id);
}
