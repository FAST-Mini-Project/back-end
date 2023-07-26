package com.mini.anuualwork.core;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/* 에러 공통 응답 클래스 */
@Getter
public class ApiErrorResponse {
    private final Integer errorCode;
    private final String message;

    public ApiErrorResponse(HttpStatus status, String message) {
        this.errorCode = status.value();
        this.message = message;
    }
}
