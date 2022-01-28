package com.example.aoplog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResult {
    String userId;
    String result;
}
