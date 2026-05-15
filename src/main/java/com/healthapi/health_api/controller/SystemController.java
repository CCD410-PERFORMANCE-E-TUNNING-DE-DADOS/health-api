package com.healthapi.health_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthapi.health_api.domain.AuditLog;
import com.healthapi.health_api.dto.AtribuirCargoDTO;
import com.healthapi.health_api.service.SystemService;
@RestController
@RequestMapping("/system")
public class SystemController {
    private final SystemService systemService;

    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    @PostMapping("/atribuir/funcionario")
    public ResponseEntity<Void> assignWorkerRole(@RequestBody AtribuirCargoDTO dto) {
        systemService
                .assignWorkerRole(dto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar/auditoria")
    public ResponseEntity<List<AuditLog>> listLogs() {
        return ResponseEntity.ok(
                systemService.listLogs()
        );
    }
}
