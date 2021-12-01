package com.example.logging.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    final String baseUrl = "http://localhost:8082";

    @Test
    @DisplayName("Get No Args")
    void hello() throws Exception {
        mockMvc.perform(get(baseUrl + "/hello"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get Args")
    void hello2() throws Exception {
        mockMvc.perform(get(baseUrl + "/hello/101/202"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Post json args")
    void hello3() throws Exception {
        mockMvc.perform(post(baseUrl + "/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"password\": \"pw\", \"userId\": \"id\"}")
                )
                .andExpect(status().isOk());
    }
}