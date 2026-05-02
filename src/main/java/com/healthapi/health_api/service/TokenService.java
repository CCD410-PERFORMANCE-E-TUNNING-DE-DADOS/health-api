package com.healthapi.health_api.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.healthapi.health_api.domain.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Worker worker) {
        return JWT.create()
                .withSubject(worker.getLogin())
                .withClaim("workerId", worker.getWorkerId())
                .withExpiresAt(Instant.now().plus(8, ChronoUnit.HOURS))
                .sign(Algorithm.HMAC256(secret));
    }

    public String validateToken(String token) {
        return JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token)
                .getSubject(); // retorna o login ou lança exceção se inválido
    }
}