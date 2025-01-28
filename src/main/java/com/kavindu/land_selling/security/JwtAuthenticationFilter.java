package com.kavindu.land_selling.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.Key;
import java.util.Base64;
import java.util.List;

@Configuration
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final Key key;

    public JwtAuthenticationFilter(@Value("${jwt.secret}")String secret) {
        this.key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = getTokenFromRequest(request);
        if(authHeader != null && validateToken(authHeader)){
            Claims claims=getCliamsFromToken(authHeader);

            @SuppressWarnings("unchecked")
            List<String> roles=claims.get("roles", List.class);

            List<GrantedAuthority> authorities=roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .map(authority -> (GrantedAuthority) authority)
                    .toList();

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken
                            (claims.getSubject(),null,authorities);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        }
        filterChain.doFilter(request, response);
    }

    private Claims getCliamsFromToken(String authHeader) {
        Claims claims=Jwts.parser().setSigningKey(key).parseClaimsJws(authHeader).getBody();
        return claims;
    }

    private boolean validateToken(String authHeader) {
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(authHeader);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            logger.debug("Authorization header is missing or does not start with Bearer");
            return authHeader.substring(7);
        }
        return null;
    }
}
