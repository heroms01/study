package com.example.demo;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) {
        //Transient 상태
        Account account = new Account();
        account.setUsername("mins");
        account.setPassword("1");

        Study study = new Study();
        study.setName("spring jpa");

        //양방향 관계시 둘이 한쌍으로 설정
//        study.setOwner(account);
//        account.getStudies().add(study);
        account.addStudy(study);

//        entityManager.persist(account);
//        entityManager.persist(study);

        Session session = entityManager.unwrap(Session.class);
        // Persistent 상태, 캐쉬
        session.save(account);
        session.save(study);

        Account loadAccount = session.load(Account.class, account.getId());
        loadAccount.setUsername("mins2");
        loadAccount.setUsername("mins");
        System.out.println("**********");
        System.out.println(loadAccount.getUsername());
    }
}
