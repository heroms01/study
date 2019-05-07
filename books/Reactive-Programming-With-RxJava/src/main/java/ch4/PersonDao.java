package ch4;

import java.util.Arrays;
import java.util.List;

public class PersonDao {
    List<Person> listPeople() {
        return query("SELECT * FROM PEOPLE");
    }

    private List<Person> query(String s) {
        List<Person> list = List.of(new Person("Mike"),new Person("Bob"));
        return list;
    }
}
