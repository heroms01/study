package com.example.mybatis;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectUser(String userId);

    void createUser(User user);

    void updateUser(User user);
}
