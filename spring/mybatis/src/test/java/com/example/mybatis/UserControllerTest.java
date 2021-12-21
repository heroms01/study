package com.example.mybatis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    UserController userController;

    @Autowired
    MockMvc mockMvc;

    String baseUrl = "http://localhost:8080/user";

    final static ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void findUser() throws Exception {
        String userId = "user1";
        mockMvc.perform(get(baseUrl + "/" + userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(equalTo(userId)));
    }


    @Test
    @Transactional
    void createUser() throws Exception {
        String userId = "user3";
        User newUser = User.builder()
                .userId(userId)
                .userPw("1234")
                .build();

        mockMvc.perform(post(baseUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isOk())
        ;
    }

    @Test
    @Transactional
    void updateUser() throws Exception {
        String userId = "user4";
        String koreanName = "소나무";
        User newUser = User.builder()
                .userId(userId)
                .userPw("1234")
                .koreanName(koreanName)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post(baseUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isOk())
        ;

        mockMvc.perform(get(baseUrl + "/" + userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(equalTo(userId)))
                .andExpect(jsonPath("$.koreanName").value(equalTo(koreanName)))
        ;

        String newKoreanName = "오소리";
        newUser.setKoreanName(newKoreanName);

        mockMvc.perform(put(baseUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isOk())
        ;

        mockMvc.perform(get(baseUrl + "/" + userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(equalTo(userId)))
                .andExpect(jsonPath("$.koreanName").value(equalTo(newKoreanName)))
        ;

    }
}