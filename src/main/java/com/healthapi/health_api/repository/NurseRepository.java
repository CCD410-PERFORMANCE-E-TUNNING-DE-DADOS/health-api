package com.healthapi.health_api.repository;

import com.healthapi.health_api.domain.Patient;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

@Repository
public class NurseRepository {

    private final JdbcTemplate jdbc;

    public NurseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public boolean cpfExists(String cpf) {

        String sql = """
            SELECT COUNT(*)
            FROM pessoa
            WHERE cpf = ?
        """;

        Integer count =
                jdbc.queryForObject(
                        sql,
                        Integer.class,
                        cpf
                );

        return count != null && count > 0;
    }

    @Transactional
    public Patient anamnesis(Patient patient) {
        // =====================
        // pessoa
        // =====================

        String insertPessoa = """
            INSERT INTO pessoa
            (
                cpf,
                nome,
                dtnascimento,
                telefone,
                cep,
                cidade,
                uf,
                logradouro,
                numlogradouro,
                complemento,
                email
            )

            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        jdbc.update(
                insertPessoa,
                patient.getCpf(),
                patient.getName(),
                patient.getBirthDate(),
                patient.getPhoneNumber(),
                patient.getCep(),
                patient.getCidade(),
                patient.getUf(),
                patient.getLogradouro(),
                patient.getNumLogradouro(),
                patient.getComplement(),
                patient.getEmail()
        );

        int pessoaId =
                jdbc.queryForObject(
                        """
                        SELECT pessoaid

                        FROM pessoa

                        WHERE cpf = ?
                        """,
                        int.class,
                        patient.getCpf()
                );

        // =====================
        // paciente
        // =====================

        String insertPaciente = """
            INSERT INTO paciente
            (
                planodesaude,
                numcarteiraplano,
                tiposanguineo,
                pessoaid
            )

            VALUES (?, ?, ?, ?)
        """;

        jdbc.update(

                insertPaciente,
                patient.getHealthPlan(),
                patient.getHealthPlanId(),
                patient.getBloodType(),
                pessoaId
        );

        int pacienteId =
                jdbc.queryForObject(
                        """
                        SELECT pacienteid

                        FROM paciente

                        WHERE pessoaid = ?
                        """,
                        int.class,
                        pessoaId
                );

        // =====================
        // alergias
        // =====================

        if (patient.getAlergias() != null) {
            String insertAlergia = """
                INSERT INTO alergias
                (
                    descricao,
                    pacienteid
                )

                VALUES (?, ?)
            """;

            for (String alergia : patient.getAlergias()) {
                jdbc.update(
                        insertAlergia,
                        alergia,
                        pacienteId
                );
            }
        }

        // =====================
        // remedios recorrentes
        // =====================

        if (patient.getRemediosRecorrentes() != null) {

            String insertRemedio = """
                INSERT INTO remedios_recorrentes
                (
                    descricao,
                    pacienteid
                )

                VALUES (?, ?)
            """;

            for (String remedio : patient.getRemediosRecorrentes()) {

                jdbc.update(
                        insertRemedio,
                        remedio,
                        pacienteId
                );
            }
        }

        patient.setId(pessoaId);
        patient.setPatientId(pacienteId);

        return patient;
    }
}