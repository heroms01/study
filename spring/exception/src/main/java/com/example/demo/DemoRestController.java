package com.example.demo;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;

@RestController
public class DemoRestController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/exception")
    public void exception() throws Exception {
        throw new Exception();
    }

    @GetMapping("/null")
    public void nullException() throws Exception {
        throw new NullPointerException();
    }

    @ExceptionHandler(NullPointerException.class)
    public Object adviseNull(Exception e) {
        System.out.println("null error :" + e.getMessage());
        return "null error";
    }
}
