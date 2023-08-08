package com.mini.anuualwork.repository;

import com.mini.anuualwork.dto.AdminDto;
import com.mini.anuualwork.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    Member findMemberByEmail(String email);

    @Query("SELECT m.id AS id, m.name AS name, m.email AS email, m.employeeNumber AS employeeNumber, " +
            "(" +
            "   SELECT :totalAnnualCount - COUNT(a) " +
            "   FROM Annual a " +
            "   WHERE a.member.id = m.id AND a.status != 'CANCELED' AND YEAR(a.date) = :year" +
            ") AS restAnnual, " +
            "(" +
            "   SELECT COUNT(w) " +
            "   FROM Work w " +
            "   WHERE w.member.id = m.id AND YEAR(w.date) = :year" +
            ") AS workDay " +
            "FROM Member m " +
            "WHERE m.memberRole = 'ROLE_USER' " +
            "ORDER BY m.id ASC")
    List<AdminDto.ResponseMemberEntity> getAllMembersWithAnnualCountAndWorkCount(
            @Param("totalAnnualCount") Long totalAnnualCount, @Param("year") Integer year);
}
