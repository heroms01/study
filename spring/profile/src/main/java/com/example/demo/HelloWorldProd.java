package com.example.demo;

public class HelloWorldProd implements HelloWorld {
    private String message = "This is Prod!";

    @Override
    public String sayHello() {
        return message;
    }
}
