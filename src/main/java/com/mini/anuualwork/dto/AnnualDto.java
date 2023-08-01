package com.mini.anuualwork.dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class AnnualDto {

    public interface AnnualInfoResponse {
        Long getAnnualId();
        String getName();
        String getEmployeeNumber();
        Date getDate();
    }

}
