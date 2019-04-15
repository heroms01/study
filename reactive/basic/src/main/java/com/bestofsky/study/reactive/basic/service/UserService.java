package com.bestofsky.study.reactive.basic.service;

import com.bestofsky.study.reactive.basic.vo.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class UserService {
    public Flux<User> getUsers(String name) {
        return null;
    }
}
