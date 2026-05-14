package com.healthapi.health_api.dto;

import java.util.Date;
import java.util.List;

public record RegistrarPacienteDTO(

    String cpf,
    String name,
    Date birthDate,
    String phoneNumber,

    String cep,
    String cidade,
    String uf,
    String logradouro,
    String numLogradouro,
    String complement,
    String email,

    String healthPlan,
    String healthPlanId,
    String bloodType,

    List<String> alergias,
    List<String> remediosRecorrentes
) {}