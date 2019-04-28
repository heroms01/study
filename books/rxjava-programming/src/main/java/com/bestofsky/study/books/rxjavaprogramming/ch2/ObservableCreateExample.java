package com.bestofsky.study.books.rxjavaprogramming.ch2;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public class ObservableCreateExample {
    public void emit() {
        Observable.just(1,2,3,4,5,6)
                .subscribe(System.out::println);
    }

    public void basic() {
        Observable<Integer> source = Observable.create(
                (ObservableEmitter<Integer> emitter) -> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onComplete();
                });
        source.subscribe(System.out::println);
    }

    public void notSubscribed() {
        Observable<Integer> source = Observable.create(
        (ObservableEmitter<Integer> emitter) -> {
            emitter.onNext(100);
            emitter.onNext(200);
            emitter.onNext(300);
            emitter.onComplete();
        });
    }

    public void subscribeLambda() {
        Observable<Integer> source = Observable.create(
        (ObservableEmitter<Integer> emitter) -> {
            emitter.onNext(100);
            emitter.onNext(200);
            emitter.onNext(300);
            emitter.onComplete();
        });
        source.subscribe(data -> System.out.println("result: " + data));
    }

    public static void main(String[] args) {
        ObservableCreateExample observableCreateExample = new ObservableCreateExample();
        observableCreateExample.emit();
        observableCreateExample.basic();
        observableCreateExample.notSubscribed();
        observableCreateExample.subscribeLambda();
    }
}
