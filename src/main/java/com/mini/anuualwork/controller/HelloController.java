package com.mini.anuualwork.controller;

import com.mini.anuualwork.core.ApiDataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public ApiDataResponse<?> hello() {
        return new ApiDataResponse<>("Hello Spring!", HttpStatus.CREATED);
    }
}
