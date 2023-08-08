package com.mini.anuualwork.service;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.AnnualDto;
import com.mini.anuualwork.entity.Annual;
import com.mini.anuualwork.entity.Member;
import com.mini.anuualwork.entity.type.AnnualStatus;
import com.mini.anuualwork.repository.AnnualRepository;
import com.mini.anuualwork.repository.MemberRepository;
import com.mini.anuualwork.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnualService {

    private final AnnualRepository annualRepository;
    private final MemberRepository memberRepository;
    private final WorkRepository workRepository;

    public ApiDataResponse<List<AnnualDto.AnnualInfoResponse>> getAnnualInfoList(Integer year, Integer month) {
        List<AnnualDto.AnnualInfoResponse> annualList = annualRepository.findAllByMember(year, month);

        return new ApiDataResponse<>(annualList);
    }

    public ApiDataResponse<?> getMemberAnnualList(String email, Integer year){
        List<AnnualDto.MemberAnnualResponse> memberAnnualList = annualRepository.findAnnuals(email, year);

        return new ApiDataResponse<>(memberAnnualList);
    }

    @Transactional
    public ApiDataResponse<?> createAnnual(String email, AnnualDto.AnnualDate annualDate) {
        Member member = memberRepository.findMemberByEmail(email);

        checkDate(member, annualDate.getDate());
        checkAnnual(member);

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

    public void checkDate(Member member, LocalDate date){
        Long count = annualRepository.findAnnualByMemberAndDate(member, date.toString());

        if(count > 0){
            throw new RuntimeException("이미 연차를 신청한 날짜입니다.");
        }

        count = workRepository.findWorkByMemberAndDate(member, date.toString());
        if(count > 0){
            throw new RuntimeException("이미 해당 날짜에 당직이 등록되어 있습니다. 해당 날짜의 당직을 확인해주세요.");
        }
    }

    public void checkAnnual(Member member){
        Long count = annualRepository.countByMember(member);

        if(count >= 15){
            throw new RuntimeException("사용 가능한 연차가 존재하지 않습니다.");
        }

    }
}
