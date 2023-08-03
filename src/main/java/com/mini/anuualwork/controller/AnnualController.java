package com.mini.anuualwork.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.AnnualDto;
import com.mini.anuualwork.service.AnnualService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

@RestController
@RequiredArgsConstructor
public class AnnualController {

    private final AnnualService annualService;

    //일정 목록 조회(연차)
    @GetMapping("/api/schedule/annual")
    public ApiDataResponse<List<AnnualDto.AnnualInfoResponse>> getAnnualInfoList(@RequestParam Integer year, @RequestParam Integer month) {
        return annualService.getAnnualInfoList(year, month);
    }

    //개인 연차 조회
    @GetMapping("/api/user/annual")
    public ApiDataResponse<?> getMemberAnnualList(Authentication authentication, @RequestParam Integer year){
        return annualService.getMemberAnnualList(authentication.getName(), year);
    }

    //연차 등록 신청
    @PostMapping("/api/schedule/annual")
    public ApiDataResponse<?> requestAnnual(Authentication authentication, @RequestBody String request) throws ParseException {;
        return annualService.requestAnnual(authentication.getName(), request);
    }

}
