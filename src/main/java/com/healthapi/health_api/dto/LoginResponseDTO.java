package com.healthapi.health_api.dto;

public record LoginResponseDTO(
    int workerId,
    String login,
    String name,
    String workerStatus
) {}