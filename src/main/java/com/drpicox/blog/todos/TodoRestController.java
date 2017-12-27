package com.drpicox.blog.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/todos")
public class TodoRestController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    public TodoRestController() {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todo) {
        todoRepository.save(todo);
        return todo;
    }

    @GetMapping()
    public Collection<Todo> getTodos() {
        return todoRepository.findAllByOrderByIdDesc();
    }

}
