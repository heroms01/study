package ch4;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        List<Person> list = personDao.listPeople();

        System.out.println(list);
    }
}
