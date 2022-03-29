package com.example.mybatis.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User selectUser(String userId);

    List<User> selectUserArr(UserArray user);

    User selectUserByNameAndHobby(String koreanName, String hobby);

    void createUser(User user);

    void updateUser(User user);
}
