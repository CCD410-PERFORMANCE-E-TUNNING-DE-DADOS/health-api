package com.healthapi.health_api.dto;

import java.util.Date;

public record ConsultaRequestDTO(

    Long consultaId,
    Long pacienteId,
    Long funcionarioId,
    Boolean retorno,
    Date dtConsulta,
    String statusConsulta
) {}