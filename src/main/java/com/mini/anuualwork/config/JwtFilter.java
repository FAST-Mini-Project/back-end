package com.mini.anuualwork.config;

import com.mini.anuualwork.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {


    private final String secretKey;

    //JWT이기 때문에 매번 요청에 대해서 처리를 해야 함. ( 문(door) 개념)
    //여기를 통해서 들어갈 수 있다, 권한을 부여해줄 수 있다(DB에 있거나,없거나(하드코딩))
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Header에서 authorization을 꺼내온다.
        final String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(authorization == null || !authorization.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        //token 꺼내기
        String token = authorization.split(" ")[1];

        //token의 유효기간 확인
        if(JwtUtil.isExpired(token,secretKey)){
            log.error("token이 만료되었습니다.");
            filterChain.doFilter(request,response);
        }


        //email 꺼내기
        String userName = JwtUtil.getEmail(token,secretKey);
        String role = JwtUtil.getRole(token,secretKey);

        // 권한 부여
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                (userName,null, List.of(new SimpleGrantedAuthority(role)));
        // Detail을 넣어줍니다.
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        //contextHolder에 authentication set
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request, response);
    }



}
