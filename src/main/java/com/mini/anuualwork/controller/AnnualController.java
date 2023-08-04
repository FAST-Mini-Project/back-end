package com.mini.anuualwork.controller;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.AnnualDto;
import com.mini.anuualwork.service.AnnualService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/api/schedule/annual")
    public ApiDataResponse<?> createAnnual(Authentication authentication, @RequestBody AnnualDto.AnnualDate annualDate){
        return annualService.requestAnnual(authentication.getName(), annualDate);
    }

    //개인 연차 취소 및 취소 신청
    @PostMapping("/api/user/annual/{id}")
    public ApiDataResponse<?> updateAnnual(Authentication authentication, @PathVariable Long id){
        return annualService.updateAnnual(authentication.getName(), id);
    }

}
