package com.healthapi.health_api.domain;

import java.util.Date;

public class Schedule {

    private Long consultaId;

    private Long pacienteId;

    private Long funcionarioId;

    private Date dtConsulta;
    
    private String descricao;

    private String encaminhamento;

    private Boolean retorno;

    public Schedule() {}

    public Schedule(
            Long consultaId,
            Long pacienteId,
            Long funcionarioId,
            Date dtConsulta,
            Boolean retorno,
            String descricao,
            String encaminhamento
    ) {
        this.consultaId = consultaId;
        this.pacienteId = pacienteId;
        this.funcionarioId = funcionarioId;
        this.dtConsulta = dtConsulta;
        this.retorno = retorno;
        this.descricao = descricao;
        this.encaminhamento = encaminhamento;
    }

    public Long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Date getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(Date dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public Boolean getRetorno() {
        return retorno;
    }

    public void setRetorno(Boolean retorno) {
        this.retorno = retorno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }
}