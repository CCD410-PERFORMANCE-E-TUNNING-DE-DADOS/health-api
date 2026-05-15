package com.healthapi.health_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthapi.health_api.domain.AuditLog;

import com.healthapi.health_api.dto.AtribuirCargoDTO;

import com.healthapi.health_api.repository.SystemRepository;

@Service
public class SystemService {
        
    private final SystemRepository systemRepository;

    public SystemService(SystemRepository systemRepository) {
            this.systemRepository = systemRepository;
    }

    public void assignWorkerRole(AtribuirCargoDTO dto) {
        if (systemRepository.workerAlreadyHasRole(dto.funcionarioId())) {
            throw new RuntimeException(
                "Funcionário já possui cargo"
            );
        }

        switch (dto.cargo()) {
            case "MEDICO" -> systemRepository.assignDoctor(
                dto.funcionarioId(),
                dto.crm(),
                dto.especialidade()
            );

            case "ENFERMEIRO" -> systemRepository.assignNurse(
                dto.funcionarioId(),
                dto.coren()
            );

            case "RECEPCIONISTA" -> systemRepository.assignReceptionist(
                dto.funcionarioId(),
                dto.setor(),
                dto.ramal(),
                dto.telefoneProfissional()
            );

            default -> throw new RuntimeException(
                "Cargo inválido"
            );
        }
    }

    public List<AuditLog> listLogs() {
        return systemRepository.listLogs();
    }
}