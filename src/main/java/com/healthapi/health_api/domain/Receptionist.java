package com.healthapi.health_api.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class Receptionist extends Worker implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String sector;
    private String workPhoneNumber;
    private String shift;

    public Receptionist(Long id, String cpf, String name, Date birthDate, String phoneNumber, String cep, String cidade, String uf, String logradouro, String numLogradouro, String complement, String email, Long workerId, String login, String password, String workerStatus, Date workerStartDate, String sector, String workPhoneNumber, String shift) {
        super(id, cpf, name, birthDate, phoneNumber, cep, cidade, uf, logradouro, numLogradouro, complement, email, workerId, login, password, workerStatus, workerStartDate);
        this.sector = sector;
        this.workPhoneNumber = workPhoneNumber;
        this.shift = shift;
    }

    public Receptionist() {
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
