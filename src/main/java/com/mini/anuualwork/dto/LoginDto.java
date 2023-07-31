package com.mini.anuualwork.dto;

import com.mini.anuualwork.entity.type.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class LoginDto {

    private String email;
    private String password;




    @Data
    public static class LoginMemberDto{
        String email;
        String name;
        String employeeNumber;
        MemberRole role;
    }


    @Data
    @AllArgsConstructor
    public static class ResponseLoginSuccess{
        LoginMemberDto user;
        private String token;
    }
}
