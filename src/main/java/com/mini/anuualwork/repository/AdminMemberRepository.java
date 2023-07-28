package com.mini.anuualwork.repository;

import com.mini.anuualwork.dto.AdminDto;
import com.mini.anuualwork.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/* TODO: 나중에 MemberRepository 생성시 리팩토링 가능 */
public interface AdminMemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m.id AS id, m.name AS name, m.email AS email, m.employeeNumber AS employeeNumber, " +
            "(SELECT 15 - COUNT(a) FROM Annual a WHERE a.member.id = m.id AND a.status != 'CANCELED') AS restAnnual, " +
            "(SELECT COUNT(w) FROM Work w WHERE w.member.id = m.id) AS workDay " +
            "FROM Member m " +
            "ORDER BY m.id ASC")
    List<AdminDto.RequestAllMembers> getAllMembersWithAnnualCountAndWorkCount();
}
