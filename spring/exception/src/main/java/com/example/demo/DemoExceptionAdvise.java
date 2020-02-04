package com.example.demo;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DemoExceptionAdvise {
    @ExceptionHandler(Exception.class)
    public Object adviceException(Exception e) {
        System.out.println("error :" + e.getMessage());
        return "error";
    }
}
