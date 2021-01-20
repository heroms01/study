package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {

    @Autowired
    private HelloWorld helloWorld;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(helloWorld.sayHello());
    }
}
