package com.mini.anuualwork.controller;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.CorrectDto;
import com.mini.anuualwork.dto.LoginDto;
import com.mini.anuualwork.dto.LogoutDto;
import com.mini.anuualwork.dto.SignupDto;
import com.mini.anuualwork.service.UserService;
import com.mini.anuualwork.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;

   @RequestMapping(value = "/api/login", method = RequestMethod.POST)
   public ApiDataResponse<LoginDto.ResponseLoginSuccess> login(@Valid @RequestBody LoginDto loginDto,
                                                               BindingResult bindingResult){
       ValidationUtils.checkValidation(bindingResult);
       return userService.login(loginDto.getEmail(),loginDto.getPassword());
   }

    @RequestMapping(value = "/api/signup", method = RequestMethod.POST)
    public ApiDataResponse<SignupDto.ResponseSignupSuccess> signup(@Valid @RequestBody SignupDto signupDto,
                                                                   BindingResult bindingResult){
        ValidationUtils.checkValidation(bindingResult);
        return userService.join(signupDto);
    }

    @RequestMapping(value = "/api/logout", method = RequestMethod.POST)
    public ApiDataResponse<LogoutDto> logout(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
        String token = authorization.split(" ")[1];
        return userService.logout(token);
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.PUT)
    public ApiDataResponse<CorrectDto.CorrectSuccess> correct(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
                                                              @Valid @RequestBody CorrectDto correctDto,
                                                              BindingResult bindingResult){
        ValidationUtils.checkValidation(bindingResult);
        String token = authorization.split(" ")[1];
        return userService.correct(correctDto, token);
    }
}
