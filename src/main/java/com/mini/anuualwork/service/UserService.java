package com.mini.anuualwork.service;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.CorrectDto;
import com.mini.anuualwork.dto.LoginDto;
import com.mini.anuualwork.dto.LogoutDto;
import com.mini.anuualwork.dto.SignupDto;
import com.mini.anuualwork.entity.Member;
import com.mini.anuualwork.entity.type.MemberRole;
import com.mini.anuualwork.repository.LoginMemberRepository;
import com.mini.anuualwork.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    @Value("${jwt.secret}")
    private String secretKey;

    private Long expriedMs = 1000 * 60 * 60l;


    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final LoginMemberRepository loginMemberRepository;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;



    public ApiDataResponse<LoginDto.ResponseLoginSuccess> login(String email, String password){


        Member member = loginMemberRepository.findByEmail(email).
                orElseThrow(() -> new RuntimeException("잘못된 이메일입니다."));

        //비밀번호 DB와 검증
        if(!bCryptPasswordEncoder.matches(password, member.getPassword()))
            throw new RuntimeException("잘못된 비밀번호입니다.");

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);



        LoginDto.LoginMemberDto loginMemberDto = new LoginDto.LoginMemberDto();
        loginMemberDto.setEmail(member.getEmail());
        loginMemberDto.setName(member.getName());
        loginMemberDto.setRole(member.getMemberRole());
        loginMemberDto.setEmployeeNumber("#" + member.getEmployeeNumber().substring(4,8));


        //성공한다면, jwt 줌.
        String token = JwtUtil.createJwt(email,member.getMemberRole(),secretKey,expriedMs);

        return new ApiDataResponse<>(new LoginDto.ResponseLoginSuccess(loginMemberDto,token));


    }

    public ApiDataResponse<SignupDto.ResponseSignupSuccess> join(SignupDto joinRequestDto){

        //이메일 중복 검사.
        if(loginMemberRepository.findByEmail(joinRequestDto.getEmail()).isPresent()){
            throw new RuntimeException("이미 가입된 이메일 입니다.");
        }


        Member member = new Member();
        member.setId(1l);
        member.setEmail(joinRequestDto.getEmail());
        member.setMemberRole(MemberRole.ROLE_USER);
        member.setPassword(bCryptPasswordEncoder.encode(joinRequestDto.getPassword()));
        member.setEmployeeNumber(joinRequestDto.getEmployeeNumber());
        member.setName(joinRequestDto.getName());
        loginMemberRepository.save(member);
        log.info("회원가입 처리가 완료되었습니다. {}",member);
        return new ApiDataResponse<>(new SignupDto.ResponseSignupSuccess());


    }

    public ApiDataResponse<LogoutDto> logout(String token){
        JwtUtil.deleteJwt(token,secretKey);
        return new ApiDataResponse<>(new LogoutDto());
    }

    public ApiDataResponse<CorrectDto.CorrectSuccess> correct(CorrectDto correctDto,String token) {

        Member member = loginMemberRepository.findByEmail(correctDto.getEmail()).
                orElseThrow(() -> new RuntimeException("잘못된 유저 이메일입니다."));

        if(!JwtUtil.getEmail(token,secretKey).equals(correctDto.getEmail())){
            throw new RuntimeException("사용자 토큰 정보가 일치하지 않습니다.");
        }


        if(!bCryptPasswordEncoder.matches(correctDto.getOldPassword(), member.getPassword())){
            throw new RuntimeException("잘못된 비밀번호입니다.");
        }

        member.setPassword(bCryptPasswordEncoder.encode(correctDto.getNewPassword()));
        loginMemberRepository.save(member);


        return new ApiDataResponse<>(new CorrectDto.CorrectSuccess());
    }


}


