package ch3;

import rx.Observable;

public class Quiz1 {
    public static void main(String[] args) {
        Observable
                .just(8, 9, 10)
                .doOnNext(i -> System.out.println("A: " + i))
                // 9를 제거하지 않고 대신 새로운 Observable을 생성한다
                // 누군가 구독하면 그때 8, 10을 방출한다
                // 대부분의 연산자가 같은 원칙을 따르고 기존의 내용이나 행위를 변조하는 대신 새로운 Observable을 만든다
                .filter(i -> i % 3 > 0)
                .doOnNext(i -> System.out.println("B: " + i))
                .map(i -> "#" + i * 10)
                .doOnNext(i -> System.out.println("C: " + i))
                .filter(s -> s.length() < 4)
                .subscribe(s -> System.out.println("D: " + s))
        ;

    }
}
