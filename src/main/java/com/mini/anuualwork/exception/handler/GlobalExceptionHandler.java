package com.mini.anuualwork.exception.handler;

import com.mini.anuualwork.core.ApiErrorResponse;
import com.mini.anuualwork.exception.InvalidationException;
import com.mini.anuualwork.exception.UserException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidationException.class)
    public ApiErrorResponse handleInvalidationException(InvalidationException invalidationException) {
        List<FieldError> fieldErrors = invalidationException.getFieldErrors();
        String[] errorMessages = fieldErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toArray(String[]::new);

        return new ApiErrorResponse(errorMessages);
    }

}
