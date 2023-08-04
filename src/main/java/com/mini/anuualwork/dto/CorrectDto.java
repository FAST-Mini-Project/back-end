package com.mini.anuualwork.dto;

import com.mini.anuualwork.entity.type.MemberRole;
import lombok.Data;
import lombok.Getter;

@Data
public class CorrectDto {
    private String email;
    private String oldPassword;
    private String newPassword;


    @Data
    public static class CorrectSuccess{
        String message = "비밀번호가 정상적으로 변경되었습니다.";
    }
}
