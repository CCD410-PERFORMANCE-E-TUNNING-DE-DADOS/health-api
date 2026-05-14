package com.healthapi.health_api.service;

import com.healthapi.health_api.domain.Schedule;
import com.healthapi.health_api.domain.Patient;

import com.healthapi.health_api.repository.DoctorRepository;

import com.healthapi.health_api.dto.CriarConsultaDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
        
        private final DoctorRepository doctorRepository;

        public MedicoService(DoctorRepository doctorRepository) {
                this.doctorRepository = doctorRepository;
        }

        public List<Schedule> listSchedulesByDoc(int workerId) {
        return doctorRepository
                .listSchedulesByDoc(workerId);
        }

        public List<Patient> listPatientsByDoc(int workerId) {
        return doctorRepository
                .listPatientsByDoc(workerId);
        }

        public void startSchedule(CriarConsultaDTO dto) {
                doctorRepository
                        .startSchedule(dto);
        }
}