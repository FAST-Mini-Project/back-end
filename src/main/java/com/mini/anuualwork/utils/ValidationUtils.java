package com.mini.anuualwork.utils;

import com.mini.anuualwork.exception.InvalidationException;
import org.springframework.validation.BindingResult;

public class ValidationUtils {
    public static void checkValidation(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidationException(bindingResult.getFieldErrors());
        }
    }
}
