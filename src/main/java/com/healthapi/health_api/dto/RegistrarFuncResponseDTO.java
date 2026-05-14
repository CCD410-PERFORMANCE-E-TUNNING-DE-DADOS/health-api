package com.healthapi.health_api.dto;

public record RegistrarFuncResponseDTO(

    Long workerId,

    String login,

    String name,

    String workerStatus
) {}