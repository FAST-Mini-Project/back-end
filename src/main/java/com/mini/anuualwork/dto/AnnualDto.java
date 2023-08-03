package com.mini.anuualwork.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mini.anuualwork.entity.Member;
import com.mini.anuualwork.entity.type.AnnualStatus;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnnualDto {

    public interface AnnualInfoResponse {
        Long getAnnualId();
        String getName();
        String getEmployeeNumber();
        Date getDate();
    }

    public interface MemberAnnualResponse{
        Long getAnnualId();
        Date getDate();
        AnnualStatus getStatus();
    }

    @Data
    public static class AnnualResponse{
        private final String message;
    }

    @Data
    public static class AnnualDate{

        private LocalDate date;
        private AnnualStatus status;
        private Member member;
    }

}
