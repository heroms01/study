package com.example.demo;

public class HelloWorldDev implements HelloWorld {
    private String message = "This is Develop";

    @Override
    public String sayHello() {
        return message;
    }
}
