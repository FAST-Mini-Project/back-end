package com.mini.anuualwork.core;

import lombok.Getter;

@Getter
public class ApiDataResponse<T> {
    private final T data;

    public ApiDataResponse(T data) {
        this.data = data;
    }
}



