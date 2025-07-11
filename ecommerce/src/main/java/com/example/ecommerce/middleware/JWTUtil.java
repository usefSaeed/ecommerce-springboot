package com.example.ecommerce.middleware;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JWTUtil {
    private static Key key;
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 5;

    private static void loadKey(){
        String secret = System.getenv("JWT_SECRET");
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public static String generateToken(String username) {
        loadKey();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public static String validateToken(String token) {
        loadKey();
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (ExpiredJwtException e) {
            System.out.println("Token expired");
        } catch (UnsupportedJwtException e) {
            System.out.println("Unsupported token");
        } catch (MalformedJwtException e) {
            System.out.println("Malformed token");
        } catch (SignatureException e) {
            System.out.println("Invalid signature");
        } catch (IllegalArgumentException e) {
            System.out.println("Empty or null token");
        }

        return null;
    }
}
