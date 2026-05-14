package com.healthapi.health_api.dto;

import java.util.Date;

public record ConsultaRequestDTO(
    int consultaId,
    int pacienteId,
    int funcionarioId,
    Boolean retorno,
    Date dtConsulta,
    String statusConsulta
) {}