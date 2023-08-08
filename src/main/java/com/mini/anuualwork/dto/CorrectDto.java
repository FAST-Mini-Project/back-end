package com.mini.anuualwork.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CorrectDto {

    @Pattern(regexp = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$", message = "이메일 형식에 어긋납니다.")
    @NotBlank
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 8,message = "이전 비밀번호는 최소 8글자 입니다.")
    private String oldPassword;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 8,message = "새로운 비밀번호는 최소 8글자 입니다.")
    private String newPassword;


    @Data
    public static class CorrectSuccess{
        String message = "비밀번호가 정상적으로 변경되었습니다.";
    }
}
