package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfiguration {
    @Configuration
    @Profile("prod")
    static class ProdHelloWord {
        @Bean
        HelloWorldProd helloWorld() {
            return new HelloWorldProd();
        }
    }

    @Configuration
    @Profile("dev")
    static class DevHelloWorld {
        @Bean
        HelloWorldDev helloWorld() {
            return new HelloWorldDev();
        }
    }
}
