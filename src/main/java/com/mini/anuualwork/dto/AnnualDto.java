package com.mini.anuualwork.dto;

import com.mini.anuualwork.entity.type.AnnualStatus;

import java.sql.Date;

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

}
