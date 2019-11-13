package ch4;

import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class PersonDao {
//    List<Person> listPeople() {
//        return query("SELECT * FROM PEOPLE");
//    }

    //기존 API 손상되는 변경
    Observable<Person> listPeople() {
        final List<Person> people = query("SELECT * FROM PEOPLE");
        return Observable.from(people);
    }

    private List<Person> query(String s) {
        List<Person> list = List.of(new Person("Mike"),new Person("Bob"));
        return list;
    }
}
