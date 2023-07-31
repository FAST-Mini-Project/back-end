package com.mini.anuualwork.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignupDto {

    @Email(message = "이메일 형식에 어긋납니다.")
    @NotBlank(message = "이메일은 필수 입력 사항입니다.")
    private String email;

    @NotBlank(message = "이름은 필수 입력 사항입니다.")
    @Size(max = 20,message = "이름은 최대 20글자입니다.")
    private String name;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 8,message = "비밀번호는 최소 8글자 입니다.")
    private String password;

    private String employeeNumber;



    @Data
    public static class ResponseSignupSuccess{
        private String message = "회원가입에 성공했습니다.";
    }




}
