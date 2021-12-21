package com.example.mybatis;

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
