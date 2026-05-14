package com.healthapi.health_api.domain;

import java.util.Date;
import java.util.Objects;

public class Worker extends Person{


    private int workerId;
    private String login;
    private String password;
    private String workerStatus;
    private Date workerStartDate;

    public Worker(int id, String cpf, String name, Date birthDate, String phoneNumber, String cep, String cidade, String uf,
                  String logradouro, String numLogradouro, String complement, String email, int workerId, String login,
                  String password, String workerStatus, Date workerStartDate) {
        super(id, cpf, name, birthDate, phoneNumber, cep, cidade, uf, logradouro, numLogradouro, complement, email);
        this.workerId = workerId;
        this.login = login;
        this.password = password;
        this.workerStatus = workerStatus;
        this.workerStartDate = workerStartDate;
    }

    public Worker(){}

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorkerStatus() {
        return workerStatus;
    }

    public void setWorkerStatus(String workerStatus) {
        this.workerStatus = workerStatus;
    }

    public Date getWorkerStartDate() {
        return workerStartDate;
    }

    public void setWorkerStartDate(Date workerStartDate) {
        this.workerStartDate = workerStartDate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Worker worker)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(workerId, worker.workerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workerId);
    }
}
