package com.mini.anuualwork.exception.message;

public interface AdminErrorMessage {
    String NOT_FOUND_MEMBER = "존재하지 않는 유저입니다.";
    String NOT_FOUND_WORK = "존재하지 않는 당직 정보입니다.";
    String ALREADY_EXIST_WORK = "이미 해당 날짜에 당직이 등록된 유저입니다.";
    String NOT_FOUND_ANNUAL = "존재하지 않는 연차 정보입니다.";
    String ALREADY_APPROVED_ANNUAL = "이미 승인된 연차 정보입니다.";
    String ALREADY_EXIST_ANNUAL = "이미 해당 날짜에 연차 또는 신청 내역이 존재합니다. 해당 날짜의 연차를 확인해주세요.";
}
