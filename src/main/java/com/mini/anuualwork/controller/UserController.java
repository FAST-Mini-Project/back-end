package com.mini.anuualwork.controller;

import com.mini.anuualwork.dto.LoginTestDto;
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
   public ResponseEntity<String> login(@RequestBody LoginTestDto loginTestDto){
       return ResponseEntity.ok().body(userService.login(loginTestDto.getUserName(),loginTestDto.getPassword()));
   }

   @PostMapping("/api/test")
   public ResponseEntity<String> test(Authentication authentication){
       return ResponseEntity.ok().body(authentication.getName());
   }

}
