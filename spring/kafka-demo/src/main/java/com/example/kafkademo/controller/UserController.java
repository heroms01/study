package com.example.kafkademo.controller;

import com.example.kafkademo.User;
import com.example.kafkademo.UserProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserProducer userProducer;

    @GetMapping("user")
    void user() {
        User user = User.builder()
                .userId("hongid")
                .userName("홍길동")
                .build();

        userProducer.pubUser(user);
    }

    @GetMapping("users")
    void users() {
        List<User> userList = new ArrayList<>();
        userList.add(User.builder()
                .userId("hongid1")
                .userName("홍길동1")
                .build());
        userList.add(User.builder()
                .userId("hongid2")
                .userName("홍길동2")
                .build());

        userProducer.pubUserList(userList);
    }
}
