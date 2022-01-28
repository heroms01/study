package com.example.aoplog.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void login() throws Exception {
        mockMvc.perform(post( "http://localhost:8080/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"password\": \"pw\", \"userId\": \"id\"}")
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("OK")))
        ;
    }
}