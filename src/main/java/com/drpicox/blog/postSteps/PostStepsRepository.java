package com.drpicox.blog.postSteps;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by Albert on 12/12/2017.
 */
public interface PostStepsRepository extends JpaRepository<PostSteps, Long> {
    public Collection<PostSteps> findAllByOrderByIdDesc();
    Collection<PostSteps> findByPostId(Long id);
}
