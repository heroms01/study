package com.example.uniquekeyresponse.controller;

import com.example.uniquekeyresponse.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hello")));
    }

    @Test
    void postFile() throws Exception {
        Resource resource = new ClassPathResource("images/1.png");
        MockMultipartFile mockMultipartFile = new MockMultipartFile("img",
                resource.getFilename(),
                MediaType.MULTIPART_FORM_DATA_VALUE,
                resource.getInputStream());

        mockMvc.perform(MockMvcRequestBuilders.multipart("/file")
                        .file(mockMultipartFile)
                        .param("userId", "1234")
                        .param("userName", "홍길동")
                )
                .andExpect(status().isOk());
    }
}