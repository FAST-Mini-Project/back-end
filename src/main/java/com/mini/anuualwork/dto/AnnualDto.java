package com.mini.anuualwork.dto;

import com.mini.anuualwork.entity.Annual;
import com.mini.anuualwork.entity.Member;
import com.mini.anuualwork.entity.type.AnnualStatus;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AnnualDto {

    public interface AnnualInfoResponse {
        Long getAnnualId();
        String getName();
        String getEmployeeNumber();
        Date getDate();
        AnnualStatus getStatus();
    }

    public interface MemberAnnualResponse{
        Long getAnnualId();
        Date getDate();
        AnnualStatus getStatus();
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class AnnualResponse{
        private String message;

        public AnnualResponse(String message){
            this.message = message;
        }
    }

    @Data
    public static class AnnualDate{

        @NotNull(message = "Date는 필수 값입니다.")
        @FutureOrPresent(message = "현재 날짜 이후만 선택 가능합니다.")
        private LocalDate date;
        private AnnualStatus status;
        private Member member;

        public Annual toEntity(){
            Annual annual = new Annual();
            annual.setDate(LocalDateTime.of(this.date, LocalTime.now()));

            return annual;
        }
    }


}
