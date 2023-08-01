package com.mini.anuualwork.controller;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.AnnualDto;
import com.mini.anuualwork.entity.Work;
import com.mini.anuualwork.service.AnnualService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class AnnualController {

    private final AnnualService annualService;

    //일정 목록 조회(연차)
    @GetMapping("/api/schedule/annual")
    public ApiDataResponse<List<AnnualDto.AnnualInfoResponse>> getAnnualInfoList(@RequestParam Integer year, @RequestParam Integer month) {
        return annualService.getAnnualInfoList(year, month);
    }

}
