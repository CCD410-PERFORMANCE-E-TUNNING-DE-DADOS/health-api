package com.healthapi.health_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthapi.health_api.dto.LoginRequestDTO;
import com.healthapi.health_api.dto.LoginResponseDTO;
import com.healthapi.health_api.dto.RegistrarFuncResponseDTO;
import com.healthapi.health_api.dto.RegistrarFuncRequestDTO;
import com.healthapi.health_api.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService auth;

    public AuthController(AuthService authService) {
        this.auth = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(
                auth
                    .login(dto)
        );
    }

    @PostMapping("/registrar/funcionario")
    public ResponseEntity<RegistrarFuncResponseDTO> registrar_funcionario(@RequestBody RegistrarFuncRequestDTO dto) {

        return ResponseEntity.ok(
                auth
                    .registrar_funcionario(dto)
        );
    }
}
