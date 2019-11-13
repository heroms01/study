package ch4;

import rx.Observable;
import rx.observables.BlockingObservable;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
//        List<Person> list = personDao.listPeople();

        // 완전한 리액티브, 비동기, 이벤트 주도
        Observable<Person> peopleStream = personDao.listPeople();
        // 이 느긋한 연산자는 onCompleted() 이벤트를 받을때까지 모든 Person 이벤트를 메모리에 버퍼 처리
        // 완료 통지를 받으면 그때 List<Person> 단일 이벤트로 방출한다
        Observable<List<Person>> peopleList = peopleStream.toList();
        // 정적 블로킹 뷰 제공
        BlockingObservable<List<Person>> peopleBlocking = peopleList.toBlocking();
        // Observable을 모두 걷어낸다
        // 비슷한 연산자 first는 T 값을 반환하고 무엇이 남았건 나머지는 버린다
        // single은 기반 Observable을 종료하기 전에 남아있는 보류 이벤트가 없음을 확실히 한다
        // 즉 onCompleted() 콜백이 호출되기까지 블록된다
        List<Person> list = peopleBlocking.single();

        System.out.println(list);

        //위와 동일
        List<Person> people = personDao
                .listPeople()
                .toList()
                .toBlocking()
                .single();

        System.out.println(people);
    }
}
