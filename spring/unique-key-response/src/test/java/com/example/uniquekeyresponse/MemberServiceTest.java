package com.example.uniquekeyresponse;

import com.example.uniquekeyresponse.entity.Member;
import com.example.uniquekeyresponse.repository.MemberRepository;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
//@Rollback(false)
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void saveMemberTest() {

        String name = "홍길동";
        String mobile = "010-1111-2222";
        String ssn = "901111-1212121";

        //given
        Member member = Member.builder()
                .name(name)
                .mobile(mobile)
                .ssn(ssn)
                .build();

        memberRepository.save(member);

        // when
        Member selectedMember = memberRepository.findById(member.getId()).get();

        // then
        assertEquals(name, selectedMember.getName());
        assertEquals(mobile, selectedMember.getMobile());
        assertEquals(ssn, selectedMember.getSsn());
    }


    @Test
    public void saveMemberListTest() {

        //given
        List<Member> members = new ArrayList<>();

        members.add(Member.builder()
                .name("홍길동1")
                .mobile("A1")
                .ssn("B1")
                .build());
        members.add(Member.builder()
                .name("홍길동2")
                .mobile("A2")
                .ssn("B2")
                .build());
        members.add(Member.builder()
                .name("홍길동3")
                .mobile("A3")
                .ssn("B3")
                .build());
        members.add(Member.builder()
                .name("홍길동4")
                .mobile("A3")
                .ssn("B3")
                .build());

        try {
            memberRepository.saveAll(members);
        } catch (DataIntegrityViolationException e) {
            String errorMessage = e.getMessage();
            String col = errorMessage.substring(errorMessage.indexOf("(")+1, errorMessage.indexOf(")"));
            String row = errorMessage.substring(errorMessage.indexOf("VALUES") + 7, errorMessage.indexOf("\"", errorMessage.indexOf("VALUES")));

            System.out.println("오류 컬럼 : " + col);
            System.out.println("오류 행 : " + row);
        }

        // when
        List<Member> selectedMembers = memberRepository.findAll();

        // then
        assertTrue(selectedMembers.size() > 0);
    }
}