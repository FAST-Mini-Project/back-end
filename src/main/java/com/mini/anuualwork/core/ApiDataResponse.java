package com.mini.anuualwork.core;

import lombok.Getter;

/* 정상 응답 클래스 */
@Getter
public class ApiDataResponse<T> {
    private final T data;

    public ApiDataResponse(T data) {
        this.data = data;
    }
}
