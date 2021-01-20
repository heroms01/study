package com.bestofsky.study.reactive.basic.step2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Component
public class Step2CommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
//        Flux<Integer> flowable = Flux.just(1, 2, 3, 4, 5)
//                .doOnNext(p -> {
//                    System.out.println("shit : "+ p);
////                    if (p == 3) {
////                        throw new RuntimeException("why!!!");
////                    }
//                    return null;
//                })
//                .filter(data -> data % 2 == 0)
//                .map(data -> data * 100);
//
//        flowable.subscribe(data -> System.out.println("*=" + data));

//        Mono<String> str = Mono.just("")
//            .zipWhen(p -> Mono.just(Boolean.TRUE))
//            .map(p -> {
//                if (p.getT2()) {
//                    throw new RuntimeException("hy!");
//                }
//                return p.getT1();
//            });
//
//        str.subscribe(System.out::println);
    }


}
