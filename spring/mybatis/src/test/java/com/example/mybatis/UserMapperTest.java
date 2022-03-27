package com.example.mybatis;

import com.example.mybatis.model.User;
import com.example.mybatis.model.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void selectUser() {
        User user = userMapper.selectUser("user1");
        assertEquals("user1", user.getUserId());
    }

    @Test
    void selectUserByNameAndHobby() {
        User user = userMapper.selectUserByNameAndHobby("홍길동", "도적질");
        assertEquals("user1", user.getUserId());
    }
}