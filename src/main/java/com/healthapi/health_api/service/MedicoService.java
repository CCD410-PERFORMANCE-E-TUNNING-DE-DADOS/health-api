package com.healthapi.health_api.service;

import com.healthapi.health_api.domain.Schedule;
import com.healthapi.health_api.domain.Patient;

import com.healthapi.health_api.repository.DoctorRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final DoctorRepository doctorRepository;

    public MedicoService(
            DoctorRepository doctorRepository
    ) {
        this.doctorRepository = doctorRepository;
    }

    public List<Schedule> listSchedulesByDoc(
            Long workerId
    ) {

        return doctorRepository
                .listSchedulesByDoc(workerId);
    }

    public List<Patient> listPatientsByDoc(
            Long workerId
    ) {

        return doctorRepository
                .listPatientsByDoc(workerId);
    }
}