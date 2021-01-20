package com.bestofsky.study.reactive.basic.step2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class Step2ApplicationTest {
    @Test
    public void test_zipWhen() {
        Mono<String> str1 = Mono.just("aaaa");

        str1.zipWhen(s -> Mono.just(1))
                .doOnNext(t -> {
                    System.out.println(t.getT2());
                }).subscribe();
    }
}
