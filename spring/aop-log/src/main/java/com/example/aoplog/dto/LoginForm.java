package com.example.aoplog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginForm {
    String password;
    String userId;
}
