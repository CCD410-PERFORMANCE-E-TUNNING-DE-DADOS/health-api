package com.healthapi.health_api.service;

import com.healthapi.health_api.domain.Worker;
import com.healthapi.health_api.dto.LoginRequestDTO;
import com.healthapi.health_api.repository.WorkerRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final WorkerRepository workerRepository;
    private final TokenService tokenService;

    public AuthService(WorkerRepository workerRepository, TokenService tokenService) {
        this.workerRepository = workerRepository;
        this.tokenService = tokenService;
    }

    public String login(LoginRequestDTO dto) {
        Worker worker = workerRepository.findByLogin(dto.login())
                .orElseThrow(() -> new RuntimeException("Login ou senha inválidos"));

        // Texto puro por enquanto
        if (!worker.getPassword().equals(dto.password())) {
            throw new RuntimeException("Login ou senha inválidos");
        }

        // Quando migrar pra BCrypt, troca a linha acima por:
        // if (!passwordEncoder.matches(dto.password(), worker.getPassword()))

        return tokenService.generateToken(worker);
    }
}