package com.mini.anuualwork.dto.message;


public interface ValidationMessage {
    String NOT_NULL_ID = "ID는 필수 값입니다.";
    String NOT_NULL_DATE = "Date는 필수 값입니다.";
    String DATE_REQUIRED_FUTURE = "선택된 날짜는 오늘보다 미래 날짜여야 합니다.";
}
