package com.mini.anuualwork.utils;

import com.mini.anuualwork.entity.type.MemberRole;
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

    public static String getRole(String token,String secretKey){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
                .getBody().get("role",String.class);
    }

    public static boolean isExpired(String token, String secretKey){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
                .getBody().getExpiration().before(new Date());
    }

    public static String createJwt(String email, MemberRole role, String secretKey, Long expiredMs){
        Claims claims = Jwts.claims();
        claims.put("email",email);
        claims.put("role",role);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expiredMs))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
    }

    public static String deleteJwt(String token,String secretKey){
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        claims.setExpiration(new Date(0));
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
