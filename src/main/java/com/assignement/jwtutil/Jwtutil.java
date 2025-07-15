package com.assignement.jwtutil;
import io.jsonwebtoken.*;

import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class Jwtutil {

    private final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final static long expirationMillis = 1000 * 60 * 60; // 1 hour

    public static String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key)
                .compact();
    }

    public String validateTokenAndGetEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
