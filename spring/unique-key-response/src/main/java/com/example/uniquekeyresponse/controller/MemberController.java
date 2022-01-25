package com.example.uniquekeyresponse.controller;

import com.example.uniquekeyresponse.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @GetMapping("/hello")
    public ResponseEntity<UserDto> hello() {
        UserDto userDto = UserDto.builder()
                .userId("1234")
                .userName("hong")
                .build();

        return ResponseEntity.ok(userDto);
    }


    @PostMapping(value = "/file", consumes =  {"multipart/form-data"})
    public ResponseEntity<String> file(@ModelAttribute UserDto userDto) {

        return ResponseEntity.ok("ok");
    }

}
