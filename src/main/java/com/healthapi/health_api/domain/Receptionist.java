package com.healthapi.health_api.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class Receptionist extends Worker implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String sector;
    private String extension; //ramal?
    private String workPhoneNumber;
    private String shift;

    public Receptionist(String id, String cpf, String name, Date birthDate, String phoneNumber, String cep, String uf,
                        String email, String workerId, String login, String password, String workerStatus, Date workerStartDate,
                        String sector, String extension, String workPhoneNumber, String shift) {
        super(id, cpf, name, birthDate, phoneNumber, cep, uf, email, workerId, login, password, workerStatus, workerStartDate);
        this.sector = sector;
        this.extension = extension;
        this.workPhoneNumber = workPhoneNumber;
        this.shift = shift;
    }

    public Receptionist(String workerId, String login, String password, String workerStatus, Date workerStartDate,
                        String sector, String extension, String workPhoneNumber, String shift) {
        super(workerId, login, password, workerStatus, workerStartDate);
        this.sector = sector;
        this.extension = extension;
        this.workPhoneNumber = workPhoneNumber;
        this.shift = shift;
    }

    public Receptionist(String sector, String extension, String workPhoneNumber, String shift) {
        this.sector = sector;
        this.extension = extension;
        this.workPhoneNumber = workPhoneNumber;
        this.shift = shift;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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
