package com.healthapi.health_api.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Objects;

public class Patient extends Person {

    @Id
    private String patientId;
    private String healthPlan;
    private String healthPlanId;
    private String bloodType;
    private Date lastAppointment;

    public Patient(String id, String cpf, String name, Date birthDate, String phoneNumber, String cep, String uf,
                   String email, String patientId, String healthPlan, String healthPlanId, String bloodType, Date lastAppointment) {
        super(id, cpf, name, birthDate, phoneNumber, cep, uf, email);
        this.patientId = patientId;
        this.healthPlan = healthPlan;
        this.healthPlanId = healthPlanId;
        this.bloodType = bloodType;
        this.lastAppointment = lastAppointment;
    }

    public Patient(String patientId, String healthPlan, String healthPlanId,
                   String bloodType, Date lastAppointment) {
        this.patientId = patientId;
        this.healthPlan = healthPlan;
        this.healthPlanId = healthPlanId;
        this.bloodType = bloodType;
        this.lastAppointment = lastAppointment;
    }

    public Patient() {}

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getHealthPlan() {
        return healthPlan;
    }

    public void setHealthPlan(String healthPlan) {
        this.healthPlan = healthPlan;
    }

    public String getHealthPlanId() {
        return healthPlanId;
    }

    public void setHealthPlanId(String healthPlanId) {
        this.healthPlanId = healthPlanId;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Date getLastAppointment() {
        return lastAppointment;
    }

    public void setLastAppointment(Date lastAppointment) {
        this.lastAppointment = lastAppointment;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Patient patient)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(patientId, patient.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), patientId);
    }
}
