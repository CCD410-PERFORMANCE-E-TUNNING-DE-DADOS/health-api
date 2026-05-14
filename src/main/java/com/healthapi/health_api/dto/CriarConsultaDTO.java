package com.healthapi.health_api.dto;

import java.util.Date;

public record CriarConsultaDTO(
    int pacienteId,
    int funcionarioId,
    Date dataConsulta,
    Boolean retorno
) {}