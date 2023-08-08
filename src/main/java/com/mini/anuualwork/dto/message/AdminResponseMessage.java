package com.mini.anuualwork.dto.message;

public interface AdminResponseMessage {
    String VERIFIED_ADMIN = "관리자 접근 권한이 확인되었습니다.";
    String SUCCESS_DELETE_MEMBER = "사원 계정이 정상적으로 삭제되었습니다.";
    String SUCCESS_CREATE_WORK = "당직등록에 성공했습니다.";
    String SUCCESS_DELETE_WORK = "당직이 삭제되었습니다.";
    String SUCCESS_APPROVE_ANNUAL = "연차 승인이 완료되었습니다.";
    String SUCCESS_APPROVE_ANNUAL_CANCEL = "연차 취소 신청이 승인되었습니다.";
    String SUCCESS_REJECT_ANNUAL = "연차 신청을 거부했습니다. 해당 연차 데이터는 삭제됩니다.";
    String SUCCESS_REJECT_ANNUAL_CANCEL = "연차 취소 신청이 거부되었습니다.";
}
