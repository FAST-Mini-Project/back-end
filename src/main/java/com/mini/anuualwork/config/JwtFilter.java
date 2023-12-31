package com.mini.anuualwork.config;

import com.mini.anuualwork.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
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

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(authorization == null || !authorization.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        String token = authorization.split(" ")[1];

        if(JwtUtil.isExpired(token,secretKey)){
            log.error("token이 만료되었습니다.");
            filterChain.doFilter(request,response);
        }

        String userName = JwtUtil.getEmail(token,secretKey);
        String role = JwtUtil.getRole(token,secretKey);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                (userName,null, List.of(new SimpleGrantedAuthority(role)));
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
