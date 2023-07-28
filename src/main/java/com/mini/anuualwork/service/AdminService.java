package com.mini.anuualwork.service;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.AdminDto;
import com.mini.anuualwork.repository.AdminMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {
    private static final Long TOTAL_ANNUAL_COUNT = 15L;

    private final AdminMemberRepository adminMemberRepository;

    public ApiDataResponse<?> getAllMembers() {
        int year = LocalDateTime.now().getYear();

        List<AdminDto.RequestAllMembers> allMembers =
                adminMemberRepository.getAllMembersWithAnnualCountAndWorkCount(TOTAL_ANNUAL_COUNT, year);

        return new ApiDataResponse<>(allMembers);
    }
}
