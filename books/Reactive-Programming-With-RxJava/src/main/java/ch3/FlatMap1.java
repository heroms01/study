package ch3;

import rx.Observable;

public class FlatMap1 {
    public static void main(String[] args) {

//        Observable<Integer> map1 = Observable.just(1, 2, 3)
//                .map(i -> i * 2)
////                .subscribe(System.out::println)
//        ;
//
//        map1.subscribe(System.out::println);

//        Observable<Integer> map2 =
                Observable.just(1, 2, 3)
                .flatMap(i -> Observable.just("#"+i, i * 3))
                .filter(num -> num instanceof String)
                .subscribe(System.out::println)
                ;

//        map2.subscribe(System.out::println);
    }
}
