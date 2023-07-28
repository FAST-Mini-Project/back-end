package com.mini.anuualwork.exception.handler;

import com.mini.anuualwork.core.ApiErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ApiErrorResponse handleException(Exception exception) {
        String[] errorMessages = {exception.getMessage()};

        return new ApiErrorResponse(errorMessages);
    }

}
