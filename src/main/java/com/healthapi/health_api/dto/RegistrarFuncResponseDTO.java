package com.healthapi.health_api.dto;

public record RegistrarFuncResponseDTO(

    int workerId,

    String login,

    String name,

    String workerStatus
) {}