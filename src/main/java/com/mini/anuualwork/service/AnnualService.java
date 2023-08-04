package com.mini.anuualwork.service;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.AnnualDto;
import com.mini.anuualwork.entity.Annual;
import com.mini.anuualwork.entity.Member;
import com.mini.anuualwork.entity.type.AnnualStatus;
import com.mini.anuualwork.repository.AnnualRepository;
import com.mini.anuualwork.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnualService {

    private final AnnualRepository annualRepository;
    private final MemberRepository memberRepository;

    public ApiDataResponse<List<AnnualDto.AnnualInfoResponse>> getAnnualInfoList(Integer year, Integer month) {
        List<AnnualDto.AnnualInfoResponse> annualList = annualRepository.findAllByMember(year, month);

        return new ApiDataResponse<>(annualList);
    }

    public ApiDataResponse<?> getMemberAnnualList(String email, Integer year){
        List<AnnualDto.MemberAnnualResponse> memberAnnualList = annualRepository.findAnnuals(email, year);

        return new ApiDataResponse<>(memberAnnualList);
    }

    @Transactional
    public ApiDataResponse<?> requestAnnual(String email, AnnualDto.AnnualDate annualDate) {
        Member member = memberRepository.findMemberByEmail(email);

        Annual annual = annualDate.toEntity();
        annual.setMember(member);
        annual.setStatus(AnnualStatus.UNAPPROVED);

        annualRepository.save(annual);

        return new ApiDataResponse<>(new AnnualDto.AnnualResponse("연차 등록에 성공했습니다."));
    }

    @Transactional
    public ApiDataResponse<?> updateAnnual(String email, Long id) {
        AnnualDto.AnnualResponse response = new AnnualDto.AnnualResponse("신청이 완료되지 않았습니다.");

        Member member = memberRepository.findMemberByEmail(email);

        Annual annual = annualRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않습니다."));

        if(member != null && member.getId() == annual.getMember().getId()){

            if(annual.getStatus() == AnnualStatus.UNAPPROVED){
                annualRepository.deleteById(id);
                response.setMessage("연차 취소가 완료되었습니다.");
            }
            else if(annual.getStatus() == AnnualStatus.APPROVED){
                annual.setStatus(AnnualStatus.CANCELED);
                annualRepository.save(annual);
                response.setMessage("연차 취소 신청이 완료되었습니다.");
            }
        }

        return new ApiDataResponse<>(response);
    }
}
