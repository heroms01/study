package ch3;

import rx.Observable;

public class FlatMap1 {
    public static void main(String[] args) {

        Observable<Integer> map1 = Observable.just(1, 2, 3)
                //map은 리턴되는 Integer를 Observable로 감싼다
                .map(i -> i * 2)
                ;
        map1.subscribe(System.out::println);

        Observable<Integer> flatMap1 = Observable.just(1, 2, 3)
                //flatMap은 Observable을 감싸줘야 한다.
                .flatMap(i -> Observable.just(i * 3))
                ;
        flatMap1.subscribe(System.out::println);

        Observable<?> flatMap2 = Observable.just(1, 2, 3)
                //flatMap은 다른 Observable로 반환할수도 있다.
                .flatMap(i -> Observable.just("#"+i, i * 4))
                ;
        flatMap2.subscribe(System.out::println);
    }
}
