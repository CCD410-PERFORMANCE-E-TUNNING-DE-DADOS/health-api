package com.healthapi.health_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthapi.health_api.domain.Schedule;
import com.healthapi.health_api.domain.Patient;

import com.healthapi.health_api.service.MedicoService;

import com.healthapi.health_api.dto.CriarConsultaDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final MedicoService doctorService;

    public FuncionarioController(MedicoService doctorService) {
        this.doctorService = doctorService;
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
    public ResponseEntity<Void>
    startSchedule(@RequestBody CriarConsultaDTO dto) {
        doctorService
            .startSchedule(dto);

        return ResponseEntity.ok().build();
    }
}
