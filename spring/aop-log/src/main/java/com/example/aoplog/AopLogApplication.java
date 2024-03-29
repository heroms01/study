package com.example.aoplog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class AopLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopLogApplication.class, args);
    }

}
