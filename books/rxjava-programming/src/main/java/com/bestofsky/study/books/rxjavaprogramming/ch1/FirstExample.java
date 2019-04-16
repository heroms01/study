package com.bestofsky.study.books.rxjavaprogramming.ch1;

import io.reactivex.Observable;

public class FirstExample {
    public void emit() {
        Observable.just("Hello", "RxJava 2")
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        FirstExample firstExample = new FirstExample();
        firstExample.emit();
    }
}
