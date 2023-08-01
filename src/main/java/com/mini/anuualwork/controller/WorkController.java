package com.mini.anuualwork.controller;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.WorkDto;
import com.mini.anuualwork.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkController {

    private final WorkService workService;

    //일정 목록 조회(당직)
    @GetMapping("/api/schedule/work")
    public ApiDataResponse<List<WorkDto.WorkInfoResponse>> getWorkInfoList(@RequestParam Integer year, @RequestParam Integer month){
        return workService.getWorkInfoList(year, month);
    }

}
