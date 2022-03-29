package com.example.mybatis.service;

import com.example.mybatis.model.User;
import com.example.mybatis.model.UserArray;
import com.example.mybatis.model.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findUser(String userId) {
        return userMapper.selectUser(userId);
    }

    public List<User> findUsers() {
        String[] userArray = {"1", "2"};
        UserArray user = UserArray.builder()
                .userArray(userArray)
                .build();

        return userMapper.selectUserArr(user);
    }

    public void createUser(User user) {
        userMapper.createUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
