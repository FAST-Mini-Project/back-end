package com.mini.anuualwork.service;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.WorkDto;
import com.mini.anuualwork.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkService {

    private final WorkRepository workRepository;

    public ApiDataResponse<List<WorkDto.WorkInfoResponse>> getWorkInfoList(Integer year, Integer month){
        List<WorkDto.WorkInfoResponse> workList = workRepository.findAllByMember(year, month);

        return new ApiDataResponse<>(workList);
    }

}
