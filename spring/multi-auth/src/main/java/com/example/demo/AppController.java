package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/login")
    public String getLogin(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String getUser(Model model) {
        User user = new User();
        user.setName("Mins");

        model.addAttribute(user);

        return "user";
    }

    @GetMapping("/api/user")
    public ResponseEntity<User> getApiUser(Model model) {
        User user = new User();
        user.setName("Mins");

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}

class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
