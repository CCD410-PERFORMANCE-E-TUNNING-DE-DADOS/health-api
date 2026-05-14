package com.healthapi.health_api.service;

import org.springframework.stereotype.Service;

import java.util.Date;

import com.healthapi.health_api.domain.Worker;
import com.healthapi.health_api.dto.LoginRequestDTO;
import com.healthapi.health_api.dto.LoginResponseDTO;
import com.healthapi.health_api.dto.RegistrarFuncResponseDTO;
import com.healthapi.health_api.dto.RegistrarFuncRequestDTO;
import com.healthapi.health_api.repository.WorkerRepository;

@Service
public class AuthService {

    private final WorkerRepository workerRepository;

    public AuthService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {
        Worker worker = workerRepository.findByLogin(dto.login())
                .orElseThrow(() -> new RuntimeException("Login ou senha inválidos"));

        // Texto puro por enquanto
        if (!worker.getPassword().equals(dto.password())) {
            throw new RuntimeException("Login ou senha inválidos");
        }

        return new LoginResponseDTO(
            worker.getWorkerId(),
            worker.getLogin(),
            worker.getName(),
            worker.getWorkerStatus()
        );
    }

    public RegistrarFuncResponseDTO registrar_funcionario(RegistrarFuncRequestDTO dto) {

        if (workerRepository
                .findByLogin(dto.login())
                .isPresent()) {

            throw new RuntimeException(
                    "Login já cadastrado"
            );
        }

        Worker worker = new Worker();

        worker.setCpf(dto.cpf());
        worker.setName(dto.name());
        worker.setBirthDate(dto.birthDate());
        worker.setPhoneNumber(dto.phoneNumber());
        worker.setCep(dto.cep());
        worker.setCidade(dto.cidade());
        worker.setUf(dto.uf());
        worker.setLogradouro(dto.logradouro());
        worker.setNumLogradouro(dto.numLogradouro());
        worker.setComplement(dto.complement());
        worker.setEmail(dto.email());
        worker.setLogin(dto.login());

        worker.setPassword(dto.password());
        worker.setWorkerStatus(dto.workerStatus());
        worker.setWorkerStartDate(new Date());

        Worker savedWorker =
                workerRepository.save(worker);

        return new RegistrarFuncResponseDTO(
                savedWorker.getWorkerId(),
                savedWorker.getLogin(),
                savedWorker.getName(),
                savedWorker.getWorkerStatus()
        );
    }
}