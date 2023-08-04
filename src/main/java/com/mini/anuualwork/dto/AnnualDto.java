package com.mini.anuualwork.dto;

import com.mini.anuualwork.entity.Annual;
import com.mini.anuualwork.entity.Member;
import com.mini.anuualwork.entity.type.AnnualStatus;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

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

        private Timestamp date;
        private AnnualStatus status;
        private Member member;

        public Annual toEntity(){
            Annual annual = new Annual();
            annual.setDate(this.date.toLocalDateTime());

            return annual;
        }
    }


}
