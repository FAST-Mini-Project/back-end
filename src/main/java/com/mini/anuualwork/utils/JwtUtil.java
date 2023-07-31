package com.mini.anuualwork.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JwtUtil {

    public static String getEmail(String token,String secretKey){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
                .getBody().get("email",String.class);
    }

    public static boolean isExpired(String token, String secretKey){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
                .getBody().getExpiration().before(new Date());
    }

    public static String createJwt(String email,String secretKey,Long expiredMs){
        //Claim => 유저 정보를 담아놓을 수 있음.
        Claims claims = Jwts.claims();
        claims.put("email",email);
        log.info("토큰이 발급되었습니다. 발급된 이메일 {}",email);

        return Jwts.builder()
                .setClaims(claims) // 유저 정보 설정
                .setIssuedAt(new Date(System.currentTimeMillis())) // 생성 일자
                .setExpiration(new Date(System.currentTimeMillis()+expiredMs))
                .signWith(SignatureAlgorithm.HS256,secretKey) // 어떤 암호화 알고리즘을 사용?
                .compact();
    }
    public static String deleteJwt(String token,String secretKey){
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        claims.setExpiration(new Date(0)); // 만료일을 과거 날짜로 설정 (1970년 1월 1일) -> 만료된 토큰이 됨.
        log.info("토큰을 만료시킵니다");
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
