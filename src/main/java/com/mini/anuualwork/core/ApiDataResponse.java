package com.mini.anuualwork.core;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/** 정상 응답 클래스 */
@Getter
public class ApiDataResponse<T> {
    private final Integer statusCode;
    private final T data;

    public ApiDataResponse(T data, HttpStatus status) {
        this.statusCode = status.value();
        this.data = data;
    }
}
