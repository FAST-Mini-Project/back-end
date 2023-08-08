package com.mini.anuualwork.service;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.AdminDto.*;
import com.mini.anuualwork.entity.Annual;
import com.mini.anuualwork.entity.Member;
import com.mini.anuualwork.entity.Work;
import com.mini.anuualwork.entity.type.AnnualStatus;
import com.mini.anuualwork.repository.AnnualRepository;
import com.mini.anuualwork.repository.MemberRepository;
import com.mini.anuualwork.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.mini.anuualwork.dto.message.AdminResponseMessage.*;
import static com.mini.anuualwork.exception.message.AdminErrorMessage.*;

@RequiredArgsConstructor
@Service
public class AdminService {
    private static final Long TOTAL_ANNUAL_COUNT = 15L;

    private final MemberRepository memberRepository;
    private final WorkRepository workRepository;
    private final AnnualRepository annualRepository;

    public ApiDataResponse<?> checkAdminAuth() {
        return new ApiDataResponse<>(VERIFIED_ADMIN);
    }

    public ApiDataResponse<List<ResponseMember>> getAllMembers() {
        List<ResponseMember> allMembers = memberRepository
                .getAllMembersWithAnnualCountAndWorkCount(TOTAL_ANNUAL_COUNT, getThisYear())
                .stream()
                .map(ResponseMember::fromEntity)
                .collect(Collectors.toList());

        return new ApiDataResponse<>(allMembers);
    }

    @Transactional
    public ApiDataResponse<ResponseSuccess> deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(NOT_FOUND_MEMBER));

        annualRepository.deleteAllByMember(member);
        workRepository.deleteAllByMember(member);
        memberRepository.delete(member);

        return new ApiDataResponse<>(new ResponseSuccess(SUCCESS_DELETE_MEMBER));
    }

    @Transactional
    public ApiDataResponse<ResponseSuccess> createWork(RequestCreateWork dto) {
        Member member = memberRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException(NOT_FOUND_MEMBER));

        Work work = dto.toEntity(member);
        workRepository.save(work);

        return new ApiDataResponse<>(new ResponseSuccess(SUCCESS_CREATE_WORK));
    }

    @Transactional
    public ApiDataResponse<ResponseSuccess> deleteWork(Long workId) {
        Work work = workRepository.findById(workId)
                .orElseThrow(() -> new RuntimeException(NOT_FOUND_WORK));

        workRepository.delete(work);

        return new ApiDataResponse<>(new ResponseSuccess(SUCCESS_DELETE_WORK));
    }

    public ApiDataResponse<List<ResponseAnnual>> getAnnualList() {
        List<ResponseAnnual> response = this.annualRepository
                .findAnnualsIsUnapprovedOrCanceled(getThisYear())
                .stream()
                .map(ResponseAnnual::fromEntity)
                .collect(Collectors.toList());

        return new ApiDataResponse<>(response);
    }

    private int getThisYear() {
        return LocalDateTime.now().getYear();
    }

    @Transactional
    public ApiDataResponse<ResponseSuccess> approveAnnual(Long annualId) {
        Annual annual = annualRepository.findById(annualId)
                .orElseThrow(() -> new RuntimeException(NOT_FOUND_ANNUAL));

        AnnualStatus status = annual.getStatus();
        ResponseSuccess responseDto = new ResponseSuccess();
        if (status == AnnualStatus.APPROVED) {
            throw new RuntimeException(ALREADY_APPROVED_ANNUAL);
        } else if (status == AnnualStatus.UNAPPROVED) {
            annual.setStatus(AnnualStatus.APPROVED);
            responseDto.setMessage(SUCCESS_APPROVE_ANNUAL);
        } else if (status == AnnualStatus.CANCELED) {
            annualRepository.delete(annual);
            responseDto.setMessage(SUCCESS_APPROVE_ANNUAL_CANCEL);
        }

        return new ApiDataResponse<>(responseDto);
    }

    @Transactional
    public ApiDataResponse<ResponseSuccess> rejectAnnual(Long annualId) {
        Annual annual = annualRepository.findById(annualId)
                .orElseThrow(() -> new RuntimeException(NOT_FOUND_ANNUAL));

        AnnualStatus status = annual.getStatus();
        ResponseSuccess responseDto = new ResponseSuccess();
        if (status == AnnualStatus.APPROVED) {
            throw new RuntimeException(ALREADY_APPROVED_ANNUAL);
        } else if (status == AnnualStatus.UNAPPROVED) {
            annualRepository.delete(annual);
            responseDto.setMessage(SUCCESS_REJECT_ANNUAL);
        } else if (status == AnnualStatus.CANCELED) {
            annual.setStatus(AnnualStatus.APPROVED);
            responseDto.setMessage(SUCCESS_REJECT_ANNUAL_CANCEL);
        }

        return new ApiDataResponse<>(responseDto);
    }
}
