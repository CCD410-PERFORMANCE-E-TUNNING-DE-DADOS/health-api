package com.healthapi.health_api.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class Doctor extends Worker implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String crm;
    private String specialty;

    public Doctor(String id, String cpf, String name, Date birthDate, String phoneNumber, String cep, String uf,
                  String email, String workerId, String login, String password, String workerStatus, Date workerStartDate,
                  String crm, String specialty) {
        super(id, cpf, name, birthDate, phoneNumber, cep, uf, email, workerId, login, password, workerStatus, workerStartDate);
        this.crm = crm;
        this.specialty = specialty;
    }

    public Doctor(String workerId, String login, String password, String workerStatus, Date workerStartDate, String crm, String specialty) {
        super(workerId, login, password, workerStatus, workerStartDate);
        this.crm = crm;
        this.specialty = specialty;
    }

    public Doctor(String crm, String specialty) {
        this.crm = crm;
        this.specialty = specialty;
    }

    public Doctor(){}

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }


}
