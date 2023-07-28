package com.mini.anuualwork.repository;

import com.mini.anuualwork.entity.Member;
import com.mini.anuualwork.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminWorkRepository extends JpaRepository<Work, Long> {

    void deleteAllByMember(Member member);
}
