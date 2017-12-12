package com.drpicox.blog.todos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    public Collection<Todo> findAllByOrderByIdDesc();

}
