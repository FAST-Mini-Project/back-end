package com.mini.anuualwork.component;

import com.mini.anuualwork.entity.Member;
import com.mini.anuualwork.repository.LoginMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final LoginMemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(final String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isEmpty()) {
            return null;
        }

        return new CustomUserDetails(member.get());
    }
}