package com.rean.blogrest.configuration;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {

    // 256-bit secret random key
    private static final String SECRET_KEY = "873f3eaa8a649dc13cf283cc02f102626b26150fd09daeba1eed5353d9a0e599";
    private static final Long EXPIRATION_DATE = 3600000L; //expires after 1 hour (in milliseconds)

    public String getUserNameFromJWT(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }

    // We want to check if this token belongs to that userDetails (user) and if it is not expired
    public boolean isTokenValid(String token, UserDetails userDetails){
        String userName = getUserNameFromJWT(token);
        return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails){
        Date currentDate = new Date();
        Date expiredDate = new Date(currentDate.getTime() + EXPIRATION_DATE);
        System.out.println(currentDate);
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(currentDate)
                .setExpiration(expiredDate)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
