package com.drpicox.blog.populate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by Alvaro Costa Sanchez on 12/12/2017.
 */
public interface PopulateRepository extends JpaRepository<Populate, Long> {

    public Collection<Populate> findAllByOrderByIdDesc();
}
