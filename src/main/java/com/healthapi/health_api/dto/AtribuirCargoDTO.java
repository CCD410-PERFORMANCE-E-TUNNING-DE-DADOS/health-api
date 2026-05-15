package com.healthapi.health_api.dto;

public record AtribuirCargoDTO(
    int funcionarioId,
    String cargo,
    String crm,
    String especialidade,
    String coren,
    String setor,
    Integer ramal,
    String telefoneProfissional
) {}