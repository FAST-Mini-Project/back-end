package com.mini.anuualwork.service;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.AnnualDto;
import com.mini.anuualwork.entity.Annual;
import com.mini.anuualwork.entity.Member;
import com.mini.anuualwork.entity.type.AnnualStatus;
import com.mini.anuualwork.repository.AnnualRepository;
import com.mini.anuualwork.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

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

    public ApiDataResponse<?> requestAnnual(String email, String request) throws ParseException {
        //json 파싱 -> string을 date로 변환
        String data = null;

        StringTokenizer st = new StringTokenizer(request, "{:}");
        while(st.hasMoreTokens() && !st.nextToken().equals("}")){
            data = st.nextToken();
        }

        data = data.replaceAll("\"", "");
        data = data.replaceAll(" ", "");
        data = data.replaceAll("\n", "");
        data += "T00:00:00";

        LocalDateTime date = LocalDateTime.parse(data);

        Member member = memberRepository.findMemberByEmail(email);

        Annual annual = new Annual();
        annual.setStatus(AnnualStatus.UNAPPROVED);
        annual.setDate(date);

        annual.setMember(member);
        annualRepository.save(annual);

        return new ApiDataResponse<>(new AnnualDto.AnnualResponse("연차 등록에 성공했습니다."));
    }
}
