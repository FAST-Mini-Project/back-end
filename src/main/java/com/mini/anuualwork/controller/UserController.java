package com.mini.anuualwork.controller;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.LoginDto;
import com.mini.anuualwork.dto.SignupDto;
import com.mini.anuualwork.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

   private final UserService userService;

   @RequestMapping(value = "/api/login", method = RequestMethod.POST)
   public ApiDataResponse<LoginDto.ResponseLoginSuccess> login(@RequestBody LoginDto loginDto){
       return userService.login(loginDto.getEmail(),loginDto.getPassword());
   }

   @PostMapping("/api/test")
   public ResponseEntity<String> test(Authentication authentication){
       return ResponseEntity.ok().body(authentication.getName());
   }

    @RequestMapping(value = "/api/signup", method = RequestMethod.POST)
    public ApiDataResponse<SignupDto.ResponseSignupSuccess> signup(@RequestBody SignupDto signupDto){
       return userService.join(signupDto);
    }

}
