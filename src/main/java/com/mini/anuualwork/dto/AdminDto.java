package com.mini.anuualwork.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

public class AdminDto {

    /* 집계 쿼리가 포함된 JPQL Projection 결과를 Converting 하기 위해서는 interface + Getter 사용 */
    public interface RequestAllMembers {
        Long getId();
        String getName();
        String getEmail();
        String getEmployeeNumber();
        Integer getRestAnnual();
        Integer getWorkDay();
    }

    @AllArgsConstructor
    @Getter
    public static class ResponseSuccess {
        private String message;
    }
}
