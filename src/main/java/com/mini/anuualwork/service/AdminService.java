package com.mini.anuualwork.service;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.AdminDto;
import com.mini.anuualwork.entity.Member;
import com.mini.anuualwork.repository.AdminAnnualRepository;
import com.mini.anuualwork.repository.AdminMemberRepository;
import com.mini.anuualwork.repository.AdminWorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {
    private static final Long TOTAL_ANNUAL_COUNT = 15L;

    private final AdminMemberRepository memberRepository;
    private final AdminWorkRepository workRepository;
    private final AdminAnnualRepository annualRepository;

    public ApiDataResponse<List<AdminDto.RequestAllMembers>> getAllMembers() {
        int year = LocalDateTime.now().getYear();

        List<AdminDto.RequestAllMembers> allMembers =
                memberRepository.getAllMembersWithAnnualCountAndWorkCount(TOTAL_ANNUAL_COUNT, year);

        return new ApiDataResponse<>(allMembers);
    }

    @Transactional
    public ApiDataResponse<AdminDto.ResponseSuccess> deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다."));

        annualRepository.deleteAllByMember(member);
        workRepository.deleteAllByMember(member);
        memberRepository.delete(member);

        return new ApiDataResponse<>(new AdminDto.ResponseSuccess("사원 계정이 정상적으로 삭제되었습니다."));
    }
}
