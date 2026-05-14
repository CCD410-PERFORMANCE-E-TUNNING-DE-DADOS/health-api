package com.healthapi.health_api.domain;

import java.util.Date;
import java.util.Objects;

public class Schedule {

    private int consultaId;
    private int pacienteId;
    private int funcionarioId;
    private String mongoId;
    private Date dtConsulta;
    private String statusConsulta;
    private Boolean retorno;

    public Schedule() {}

    public Schedule(
            int consultaId,
            int pacienteId,
            int funcionarioId,
            String mongoId,
            Date dtConsulta,
            String statusConsulta,
            Boolean retorno
    ) {

        this.consultaId = consultaId;
        this.pacienteId = pacienteId;
        this.funcionarioId = funcionarioId;
        this.mongoId = mongoId;
        this.dtConsulta = dtConsulta;
        this.statusConsulta = statusConsulta;
        this.retorno = retorno;
    }

    public int getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(int consultaId) {
        this.consultaId = consultaId;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getMongoId() {
        return mongoId;
    }

    public void setMongoId(String mongoId) {
        this.mongoId = mongoId;
    }

    public Date getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(Date dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public String getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public Boolean getRetorno() {
        return retorno;
    }

    public void setRetorno(Boolean retorno) {
        this.retorno = retorno;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Schedule schedule))
            return false;

        return Objects.equals(
                consultaId,
                schedule.consultaId
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(consultaId);
    }
}