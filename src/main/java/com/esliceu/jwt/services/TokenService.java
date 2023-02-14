package com.esliceu.jwt.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
@Service
public class TokenService {
    @Value("${token.secret}")
    String tokenSecret;

    @Value("${token.expiration}")
    int tokenExpiration;
    public String newToken(String user) {
        String token = JWT.create()
                .withSubject(user)
                .withExpiresAt(new Date(System.currentTimeMillis() + tokenExpiration))
                .sign(Algorithm.HMAC512(tokenSecret.getBytes()));
        return token;
    }
}
