package ch3;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;

import java.util.concurrent.TimeUnit;

@Slf4j
public class FlatMap2 {
    public static void main(String[] args) throws InterruptedException {
        // delay는 모든 단일 이벤트를 주어진 시간만큼 미룬다.
        Observable.just(1,2,3)
                .delay(1, TimeUnit.SECONDS)
                .subscribe(s -> log.info("delay : {}", s));

        // timer는 단순히 주어진 시간만큼 잠들었다가 방출한다.
        Observable
                .timer(1, TimeUnit.SECONDS)
                .flatMap(i -> Observable.just(1,2,3))
                .subscribe(i -> log.info("timer : {}", i));

        // 각 단어의 길이 만큼 지연
        Observable.just("Lorem", "ipsum", "in", "a", "international")
                .delay(word -> Observable.timer(word.length(), TimeUnit.SECONDS))
                .subscribe(word -> log.info("word timer : {}", word));

        // 위에 것을 flatMap으로 변경
        Observable.just("Lorem", "ipsum", "in", "a", "international")
                .flatMap(word -> Observable.timer(word.length(), TimeUnit.SECONDS).map(x -> word))
                .subscribe(word -> log.info("flatMap word timer : {}", word));


        TimeUnit.SECONDS.sleep(20);
    }
}
