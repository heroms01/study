package com.bestofsky.study.reactive.basic.step1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

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

    @GetMapping("member1")
    public Mono<List<String>> member1() {
        List<String> list = Arrays.asList("A,B,C".split(","));
        return Mono.just(list);
    }

    @GetMapping(value="member2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> member2() {
        List<String> list = Arrays.asList("A,B,C".split(","));
        return Flux.fromIterable(list);
    }
}
