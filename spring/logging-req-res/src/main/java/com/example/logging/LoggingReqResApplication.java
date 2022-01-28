package com.example.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class LoggingReqResApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoggingReqResApplication.class, args);
    }

}
