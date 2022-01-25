package com.example.uniquekeyresponse.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class UserDto {
    private String userId;
    private String userName;
    private MultipartFile img;
}
