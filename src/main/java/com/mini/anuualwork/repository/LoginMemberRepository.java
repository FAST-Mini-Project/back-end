package com.mini.anuualwork.repository;

import com.mini.anuualwork.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginMemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByEmail(String email);
}
