package com.mini.anuualwork.dto;

import com.mini.anuualwork.entity.type.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class LoginDto {

    @Pattern(regexp = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$", message = "이메일 형식에 어긋납니다.")
    @NotBlank
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 8,message = "비밀번호는 최소 8글자 입니다.")
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
