package com.mini.anuualwork.core;

import lombok.Getter;

/* 에러 공통 응답 클래스 */
@Getter
public class ApiErrorResponse {
    private final String[] errorMessage;

    public ApiErrorResponse(String[] messages) {
        this.errorMessage = messages;
    }
}
