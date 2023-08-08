package com.mini.anuualwork.core;

import lombok.Getter;

@Getter
public class ApiErrorResponse {
    private final String[] errorMessage;

    public ApiErrorResponse(String[] messages) {
        this.errorMessage = messages;
    }
}
