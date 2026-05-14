package com.healthapi.health_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthapi.health_api.domain.Patient;
import com.healthapi.health_api.domain.Schedule;
import com.healthapi.health_api.dto.CriarConsultaDTO;
import com.healthapi.health_api.dto.FinalizarConsultaDTO;
import com.healthapi.health_api.repository.DoctorRepository;

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

    public void finishSchedule(FinalizarConsultaDTO dto) {
            String status =
                    dto.statusConsulta();
            if (!status.equals("FINALIZADA") && !status.equals("CANCELADA")) {
                    throw new RuntimeException("Status inválido");
            }

            doctorRepository.finishSchedule(dto.consultaId(), status);
    }

}