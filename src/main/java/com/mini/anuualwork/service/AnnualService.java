package com.mini.anuualwork.service;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.AnnualDto;
import com.mini.anuualwork.repository.AnnualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnualService {

    private final AnnualRepository annualRepository;

    public ApiDataResponse<List<AnnualDto.AnnualInfoResponse>> getAnnualInfoList(Integer year, Integer month) {
        List<AnnualDto.AnnualInfoResponse> annualList = annualRepository.findAllByMember(year, month);

        return new ApiDataResponse<>(annualList);
    }

    public ApiDataResponse<?> getMemberAnnualList(String email, Integer year){
        List<AnnualDto.MemberAnnualResponse> memberAnnualList = annualRepository.findAnnuals(email, year);

        return new ApiDataResponse<>(memberAnnualList);
    }

}
