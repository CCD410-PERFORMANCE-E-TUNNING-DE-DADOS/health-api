package com.healthapi.health_api.dto;

import java.util.Date;

public record RegistrarFuncRequestDTO(

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

    String login,
    String password,
    String workerStatus
) {}