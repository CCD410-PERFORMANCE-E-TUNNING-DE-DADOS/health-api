package com.healthapi.health_api.dto;

public record LoginResponseDTO(

    Long workerId,

    String login,

    String name,

    String workerStatus
) {}