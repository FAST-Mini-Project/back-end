package com.mini.anuualwork.repository;

import com.mini.anuualwork.dto.WorkDto;
import com.mini.anuualwork.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Long> {

    @Query("select w.id as workId, DATE(w.date) as date, m.name as name, concat('#', substring(m.employeeNumber, 5, 4)) as employeeNumber " +
            "from Work w " +
            "inner join Member m " +
            "on w.member.id = m.id where YEAR(w.date) = :year and MONTH(w.date) = :month")
    List<WorkDto.WorkInfoResponse> findAllByMember(@Param("year") Integer year, @Param("month") Integer month);

    @Query("select w.id as dutyId, DATE(w.date) as date " +
            "from Work w " +
            "inner join Member m " +
            "on w.member.id = m.id " +
            "where YEAR(date) = :year and MONTH(date) = :month and m.email = :email")
    List<WorkDto.MemberWorkResponse> findWorks(@Param("email") String email, @Param("year") Integer year, @Param("month") Integer month);
}
