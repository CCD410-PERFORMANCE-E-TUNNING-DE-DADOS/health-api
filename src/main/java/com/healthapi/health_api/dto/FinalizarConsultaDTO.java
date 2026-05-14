package com.healthapi.health_api.dto;

public record FinalizarConsultaDTO(
    int consultaId,
    String statusConsulta
) {}