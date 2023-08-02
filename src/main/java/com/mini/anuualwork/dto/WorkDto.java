package com.mini.anuualwork.dto;

import java.sql.Date;

public class WorkDto {

    public interface WorkInfoResponse {
        Long getWorkId();
        String getName();
        String getEmployeeNumber();
        Date getDate();
    }

    public interface MemberWorkResponse{
        Long getDutyId();
        Date getDate();
    }

}
