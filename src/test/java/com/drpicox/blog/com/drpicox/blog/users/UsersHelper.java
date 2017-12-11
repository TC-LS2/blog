package com.drpicox.blog.com.drpicox.blog.users;

import com.drpicox.blog.users.User;
import com.drpicox.blog.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertNotNull;

@Component
public class UsersHelper {

    @Autowired
    private UserRepository userRepository;

    public void cleanup() throws Exception {
        userRepository.deleteAllInBatch();
    }

    public User make(String name) {
        return make(name, name + "@example.com");
    }

    public User make(String name, String email) {
        User user = new User(null, name, email);
        userRepository.save(user);
        return user;
    }
}
