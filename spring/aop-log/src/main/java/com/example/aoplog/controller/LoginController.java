package com.example.aoplog.controller;

import com.example.aoplog.dto.LoginForm;
import com.example.aoplog.dto.LoginResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @PostMapping("login")
    public ResponseEntity<LoginResult> login(@RequestBody LoginForm loginForm) {
        log.info("Controller LOG : {}", loginForm);

        LoginResult loginResult = LoginResult.builder()
                .userId(loginForm.getUserId())
                .result("OK")
                .build();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(loginResult)
                ;
    }
}
