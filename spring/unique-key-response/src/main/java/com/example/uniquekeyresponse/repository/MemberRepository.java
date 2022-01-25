package com.example.uniquekeyresponse.repository;

import com.example.uniquekeyresponse.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
