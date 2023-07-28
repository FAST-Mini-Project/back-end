package com.mini.anuualwork.service;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.AdminDto;
import com.mini.anuualwork.repository.AdminMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminMemberRepository adminMemberRepository;

    public ApiDataResponse<?> getAllMembers() {
        List<AdminDto.RequestAllMembers> allMembers = adminMemberRepository.getAllMembersWithAnnualCountAndWorkCount();

        return new ApiDataResponse<>(allMembers);
    }
}
