package com.example.logging.controller;

import com.example.logging.dto.LoginForm;
import com.example.logging.dto.LoginResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("hello/{arg1}/{arg2}")
    public String hello(@PathVariable String arg1, @PathVariable String arg2) {
        System.out.println("arg1 : " + arg1);
        System.out.println("arg2 : " + arg2);
        return "hello get args";
    }

    @PostMapping("hello")
    public ResponseEntity<LoginResult> helloPost(@RequestBody LoginForm loginForm) {
        log.info("POST Controller : {}", loginForm);

        LoginResult loginResult = LoginResult.builder()
                .userId(loginForm.getUserId())
                .result("Good!")
                .build();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(loginResult)
                ;
    }

}
