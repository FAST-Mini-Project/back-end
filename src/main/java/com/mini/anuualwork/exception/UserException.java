package com.mini.anuualwork.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}