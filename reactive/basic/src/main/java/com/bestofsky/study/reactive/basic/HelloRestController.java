package com.bestofsky.study.reactive.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("hello")
public class HelloRestController {
    @GetMapping("mono")
    public Mono<String> mono() {
        return Mono.just("hello mono");
    }

    @GetMapping("flux")
    public Flux<String> flux() {
        return Flux.just("hi", "how are you");
    }
}
