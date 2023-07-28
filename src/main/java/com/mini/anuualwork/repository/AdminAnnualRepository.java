package com.mini.anuualwork.repository;

import com.mini.anuualwork.entity.Annual;
import com.mini.anuualwork.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAnnualRepository extends JpaRepository<Annual, Long> {

    void deleteAllByMember(Member member);
}
