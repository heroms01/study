package com.example.mybatis.controller;

import com.example.mybatis.model.User;
import com.example.mybatis.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    public User findUser(@PathVariable String userId) {
        return userService.findUser(userId);
    }

    @GetMapping("/users")
    public List<User> findUsers() {
        return userService.findUsers();
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}
