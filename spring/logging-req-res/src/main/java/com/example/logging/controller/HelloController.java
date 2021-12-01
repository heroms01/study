package com.example.logging.controller;

import com.example.logging.dto.LoginForm;
import org.springframework.web.bind.annotation.*;

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
    public String helloPost(@RequestBody LoginForm loginForm) {
        System.out.println("id: "+loginForm.getUserId()+" pw: "+loginForm.getPassword());
        return "hello";
    }

}
