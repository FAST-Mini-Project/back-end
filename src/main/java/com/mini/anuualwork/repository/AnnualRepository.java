package com.mini.anuualwork.repository;

import com.mini.anuualwork.dto.AnnualDto;
import com.mini.anuualwork.entity.Annual;
import com.mini.anuualwork.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnualRepository extends JpaRepository<Annual, Long> {

    @Query("select a.id as annualId, m.name as name, concat('#', substring(m.employeeNumber, 5, 4))  as employeeNumber, " +
            "DATE(a.date) as date, a.status as status " +
            "from Annual a " +
            "inner join Member m " +
            "on a.member.id = m.id " +
            "where YEAR(a.date) = :year and MONTH(a.date) = :month")
    List<AnnualDto.AnnualInfoResponse> findAllByMember(@Param("year") Integer year, @Param("month") Integer month);

    @Query("select a.id as annualId, DATE(a.date) as date, a.status as status " +
            "from Annual a inner join Member m " +
            "on a.member.id = m.id " +
            "where YEAR(date) = :year and m.email = :email")
    List<AnnualDto.MemberAnnualResponse> findAnnuals(@Param("email") String email, @Param("year") Integer year);
}

