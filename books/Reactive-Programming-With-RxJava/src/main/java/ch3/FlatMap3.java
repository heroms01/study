package ch3;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;

import java.time.DayOfWeek;
import java.util.concurrent.TimeUnit;

@Slf4j
public class FlatMap3 {
    public static void main(String[] args) throws InterruptedException {

        /*
        flatMap이 본질적으로 하는 일은 시간(이벤트)에 따른 값의 원본 순열의 취해 각각을 독립적인 부분 순열로 대체하는 것이다.
        이들 부분 순열은 원본 순열의 이벤트와 무관하다.
        더이상 원본 순열이 아닌 각각 별개로 동작한다.
        따라서 부속 이벤트가 다운스트림 연산자/구독자에게 도달하는 순서를 보장할 수 없다.
         */
        Observable.just(10, 1)
                .flatMap(i -> Observable.just(i).delay(i, TimeUnit.SECONDS))
                .subscribe(s -> log.info("뒤바뀐 순서 {}", s));

        /*
        최초 loadRecordsFor(SUNDAY) 호출하면 실행 결과를 바로 다운스트림으로 보낸다.
        거의 동시에 loadRecordsFor(MONDAY) 가 호출되서 실행 결과를 바로 다운스트림으로 보내지며 스트림이 뒤섞인다.
         */
        Observable.just(DayOfWeek.SUNDAY, DayOfWeek.MONDAY)
                .flatMap(FlatMap3::loadRecordsFor)
                .subscribe(s -> log.info("{}", s));

        TimeUnit.SECONDS.sleep(20);
    }

    public static Observable<String> loadRecordsFor(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
                return Observable.interval(65, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(i -> "Mon-" + i);
            case SUNDAY:
                return Observable.interval(90, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(i -> "Sun-" + i);
        }

        return Observable.empty();
    }
}
