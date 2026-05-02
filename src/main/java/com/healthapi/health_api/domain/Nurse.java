package com.healthapi.health_api.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class Nurse extends Worker implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String coren;
    private String shift;

    public Nurse(Long id, String cpf, String name, Date birthDate, String phoneNumber, String cep, String cidade, String uf,
                 String logradouro, String numLogradouro, String complement, String email, Long workerId, String login,
                 String password, String workerStatus, Date workerStartDate, String coren, String shift) {
        super(id, cpf, name, birthDate, phoneNumber, cep, cidade, uf, logradouro, numLogradouro, complement, email, workerId,
                login, password, workerStatus, workerStartDate);
        this.coren = coren;
        this.shift = shift;
    }

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
