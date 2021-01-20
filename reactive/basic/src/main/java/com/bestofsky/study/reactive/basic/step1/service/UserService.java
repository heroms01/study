package com.bestofsky.study.reactive.basic.step1.service;

import com.bestofsky.study.reactive.basic.step1.vo.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    public Flux<User> getUsers() {
        List<User> users = Arrays.asList(new User(1, "Bob"), new User(2, "Mike"));
        return Flux.fromIterable(users);
    }
}
