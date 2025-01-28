package com.kavindu.land_selling.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class JwtGenerator {

    private Key key;

    private JwtGenerator(@Value("${jwt.secret}")String secret) {
        this.key= Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
    }

    public String generateToken(String username, List<GrantedAuthority> grantedAuthorities,Long expiration) {


        List<String> roles = grantedAuthorities.stream()
                .map(GrantedAuthority::getAuthority)
                .toList();


        return Jwts.builder()
                .setSubject(username)
                .claim("roles",roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(key)
                .compact();
    }
}
