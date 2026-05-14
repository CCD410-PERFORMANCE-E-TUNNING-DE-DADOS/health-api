package com.healthapi.health_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthapi.health_api.domain.Schedule;
import com.healthapi.health_api.service.MedicoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final MedicoService doctorService;

    public FuncionarioController(
            MedicoService doctorService
    ) {
        this.doctorService = doctorService;
    }

    @GetMapping("/medico/listar/consultas")
    public ResponseEntity<List<Schedule>>
    listarConsultas(

            @RequestParam Long workerId
    ) {

        List<Schedule> consultas =
                doctorService
                        .listSchedulesByDoc(workerId);

        return ResponseEntity.ok(consultas);
    }
}
