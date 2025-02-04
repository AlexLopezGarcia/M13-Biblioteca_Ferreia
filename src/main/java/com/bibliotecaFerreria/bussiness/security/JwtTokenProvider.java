//package com.bibliotecaFerreria.bussiness.security;
//
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtTokenProvider {
//    @Value("${security.jwt.secret-key:MyKey}") // ✅ Si la propiedad no existe, usa "MyKey" por defecto
//    private String secretKey;
//
//    private final long validityInMilliseconds = 3600000; // 1h
//
//    public String createToken(String username) {
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + validityInMilliseconds);
//
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(now)
//                .setExpiration(validity)
//                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes()) // ✅ Usa getBytes() para evitar errores
//                .compact();
//    }
//
//    public String getUsernameFromToken(String token) {
//        return Jwts.parserBuilder() // ✅ Usa parserBuilder() en lugar de parser()
//                .setSigningKey(secretKey.getBytes())
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parserBuilder()
//                    .setSigningKey(secretKey.getBytes())
//                    .build()
//                    .parseClaimsJws(token);
//            return true;
//        } catch (JwtException | IllegalArgumentException e) {
//            return false;
//        }
//    }
//
//    public Authentication getAuthentication(String token) {
//        String username = getUsernameFromToken(token);
//        return new UsernamePasswordAuthenticationToken(username, "", null);
//    }
//}
