package com.mini.anuualwork.exception.handler;

import com.mini.anuualwork.core.ApiErrorResponse;
import com.mini.anuualwork.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ApiErrorResponse handleException(Exception exception) {
        String[] errorMessages = {exception.getMessage()};

        return new ApiErrorResponse(errorMessages);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserException.class)
    public ApiErrorResponse handleUserException(UserException userException) {
        String[] errorMessages = {userException.getMessage()};

        return new ApiErrorResponse(errorMessages);
    }

}
