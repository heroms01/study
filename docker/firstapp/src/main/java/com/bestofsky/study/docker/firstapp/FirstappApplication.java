package com.bestofsky.study.docker.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FirstappApplication {

    int serverPort;

    public static void main(String[] args) {
        SpringApplication.run(FirstappApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "hello docker 2, port : " + serverPort;
    }

    @Bean
    public ApplicationListener<ServletWebServerInitializedEvent> portListener() {
        return e -> {
            ServletWebServerApplicationContext applicationContext = e.getApplicationContext();
            serverPort = applicationContext.getWebServer().getPort();
        };
    }

}
