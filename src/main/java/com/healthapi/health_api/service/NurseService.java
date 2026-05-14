package com.healthapi.health_api.service;

import org.springframework.stereotype.Service;

import com.healthapi.health_api.domain.Patient;
import com.healthapi.health_api.dto.RegistrarPacienteDTO;

import com.healthapi.health_api.repository.NurseRepository;

@Service
public class NurseService {
        
    private final NurseRepository nurseRepository;

    public NurseService(NurseRepository nurseRepository) {
            this.nurseRepository = nurseRepository;
    }

    public Patient anamnesis(RegistrarPacienteDTO dto) {
        if (nurseRepository.cpfExists(dto.cpf())) {
            throw new RuntimeException(
                    "CPF já cadastrado"
            );
        }

        Patient patient = new Patient();
        patient.setCpf(dto.cpf());
        patient.setName(dto.name());
        patient.setBirthDate(dto.birthDate());
        patient.setPhoneNumber(dto.phoneNumber());

        patient.setCep(dto.cep());
        patient.setCidade(dto.cidade());
        patient.setUf(dto.uf());
        patient.setLogradouro(dto.logradouro());
        patient.setNumLogradouro(dto.numLogradouro());
        patient.setComplement(dto.complement());
        patient.setEmail(dto.email());

        patient.setHealthPlan(dto.healthPlan());
        patient.setHealthPlanId(dto.healthPlanId());
        patient.setBloodType(dto.bloodType());

        patient.setAlergias(dto.alergias());
        patient.setRemediosRecorrentes(dto.remediosRecorrentes());

        return nurseRepository
                .anamnesis(patient);
        }
}