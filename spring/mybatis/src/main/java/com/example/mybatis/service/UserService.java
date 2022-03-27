package com.example.mybatis.service;

import com.example.mybatis.model.User;
import com.example.mybatis.model.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findUser(String userId) {
        return userMapper.selectUser(userId);
    }

    public void createUser(User user) {
        userMapper.createUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
