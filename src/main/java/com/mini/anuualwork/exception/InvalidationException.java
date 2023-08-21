package com.mini.anuualwork.exception;

import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
public class InvalidationException extends RuntimeException {

    private List<FieldError> fieldErrors;

    public InvalidationException() {
    }


    public InvalidationException(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public InvalidationException(String message) {
        super(message);
    }

    public InvalidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidationException(Throwable cause) {
        super(cause);
    }
}
