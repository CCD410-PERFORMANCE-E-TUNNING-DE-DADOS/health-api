package com.healthapi.health_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthapi.health_api.domain.Patient;
import com.healthapi.health_api.domain.Schedule;

import com.healthapi.health_api.dto.CriarConsultaDTO;
import com.healthapi.health_api.dto.FinalizarConsultaDTO;
import com.healthapi.health_api.dto.RegistrarPacienteDTO;

import com.healthapi.health_api.service.MedicoService;
import com.healthapi.health_api.service.NurseService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final MedicoService doctorService;
    private final NurseService nurseService;

    public FuncionarioController(MedicoService doctorService, NurseService nurseService) {
        this.doctorService = doctorService;
        this.nurseService = nurseService;
    }

    @GetMapping("/medico/listar/consultas")
    public ResponseEntity<List<Schedule>> listarConsultas(@RequestParam int workerId) {
        List<Schedule> consultas =
                doctorService
                        .listSchedulesByDoc(workerId);

        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/medico/listar/pacientes")
    public ResponseEntity<List<Patient>> listarPacientes(@RequestParam int workerId) {
        List<Patient> patients =
                doctorService
                        .listPatientsByDoc(workerId);

        return ResponseEntity.ok(patients);
    }

    @PostMapping("/medico/iniciar/consulta")
    public ResponseEntity<Void> startSchedule(@RequestBody CriarConsultaDTO dto) {
        doctorService
            .startSchedule(dto);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/medico/finalizar/consulta")
    public ResponseEntity<Void> finishConsult(@RequestBody FinalizarConsultaDTO dto) {
        doctorService
            .finishSchedule(dto);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/enfermeiro/anamnese")
    public ResponseEntity<Patient> anamnesis(@RequestBody RegistrarPacienteDTO dto) {
        Patient patient = nurseService
                            .anamnesis(dto);

        return ResponseEntity.ok(patient);
    }
}
