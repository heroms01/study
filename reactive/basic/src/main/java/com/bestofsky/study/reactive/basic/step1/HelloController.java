package com.bestofsky.study.reactive.basic.step1;

import com.bestofsky.study.reactive.basic.step1.service.UserService;
import com.bestofsky.study.reactive.basic.step1.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

@Controller
@RequestMapping("view")
public class HelloController {
    @Autowired
    UserService userService;

    @GetMapping("hello1")
    public String hello() {
        return "view/hello1";
    }

    @GetMapping("hello2")
    public String hello2(Model model) {
        model.addAttribute("name", "Mins");

        return "view/hello2";
    }

    @GetMapping("hello3")
    public String hello3(Model model) {
        Flux<User> users = userService.getUsers();

        Flux<User> u1 = users.map(u -> {
            u.setName("aaa");
            return u;
        });

        Flux<User> u2 = users.flatMap(u -> Flux.just(u));


        model.addAttribute("users", users);
        model.addAttribute("usersUpper", u1);

        return "view/hello3";
    }
}
