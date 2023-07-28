package com.mini.anuualwork.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JwtUtil {

    public static String getUserName(String token,String secretKey){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
                .getBody().get("userName",String.class);
    }

    public static boolean isExpired(String token, String secretKey){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
                .getBody().getExpiration().before(new Date());
    }

    public static String createJwt(String userName,String secretKey,Long expiredMs){
        //Claim => 유저 정보를 담아놓을 수 있음.
        Claims claims = Jwts.claims();
        claims.put("userName",userName);
        log.info("유저네임 {}",userName);

        log.info("토큰이 발급되었습니다.");
        return Jwts.builder()
                .setClaims(claims) // 유저 정보 설정
                .setIssuedAt(new Date(System.currentTimeMillis())) // 생성 일자
                .setExpiration(new Date(System.currentTimeMillis()+expiredMs))
                .signWith(SignatureAlgorithm.HS256,secretKey) // 어떤 암호화 알고리즘을 사용?
                .compact();
    }
}
