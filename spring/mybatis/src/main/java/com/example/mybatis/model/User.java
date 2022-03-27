package com.example.mybatis.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    String userId;
    String userPw;
    String koreanName;
    String englishName;
    String hobby;
}
