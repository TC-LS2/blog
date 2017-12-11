package com.drpicox.blog.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserRestController() {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @GetMapping()
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }


}
