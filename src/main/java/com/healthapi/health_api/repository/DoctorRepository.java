package com.healthapi.health_api.repository;

import com.healthapi.health_api.domain.Schedule;
import com.healthapi.health_api.domain.Patient;

import com.healthapi.health_api.dto.CriarConsultaDTO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepository {

    private final JdbcTemplate jdbc;

    public DoctorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Schedule> listSchedulesByDoc(int workerId) {
        String sql = """
            SELECT
                consultaid,
                pacienteid,
                funcionarioid,
                mongoid,
                dtconsulta,
                statusconsulta,
                retorno

            FROM consulta

            WHERE funcionarioid = ?
        """;

        return jdbc.query(
            sql,
            (rs, rowNum) -> new Schedule(
                rs.getInt("consultaid"),
                rs.getInt("pacienteid"),
                rs.getInt("funcionarioid"),
                rs.getString("mongoid"),
                rs.getTimestamp("dtconsulta"),
                rs.getString("statusconsulta"),
                rs.getBoolean("retorno")
            ),
            workerId
        );
    }

    public List<Patient> listPatientsByDoc(int workerId) {

        String sql = """
            SELECT
                p.pessoaid,
                p.cpf,
                p.nome,
                p.dtnascimento,
                p.telefone,
                p.email,
                p.cep,
                p.cidade,
                p.uf,
                p.logradouro,
                p.numlogradouro,
                p.complemento,

                pa.pacienteid,
                pa.planodesaude,
                pa.numcarteiraplano,
                pa.tiposanguineo,

                MAX(c.dtconsulta) AS ultimaconsulta

            FROM ccd410.consulta c
            INNER JOIN ccd410.paciente pa
                ON c.pacienteid = pa.pacienteid
            INNER JOIN ccd410.pessoa p
                ON pa.pessoaid = p.pessoaid
            WHERE c.funcionarioid = ?
            GROUP BY
                p.pessoaid,
                p.cpf,
                p.nome,
                p.dtnascimento,
                p.telefone,
                p.email,
                p.cep,
                p.cidade,
                p.uf,
                p.logradouro,
                p.numlogradouro,
                p.complemento,

                pa.pacienteid,
                pa.planodesaude,
                pa.numcarteiraplano,
                pa.tiposanguineo
        """;

        return jdbc.query(
            sql,
            (rs, rowNum) -> new Patient(
                rs.getInt("pessoaid"),
                rs.getString("cpf"),
                rs.getString("nome"),
                rs.getDate("dtnascimento"),
                rs.getString("telefone"),
                rs.getString("cep"),
                rs.getString("cidade"),
                rs.getString("uf"),
                rs.getString("logradouro"),
                rs.getString("numlogradouro"),
                rs.getString("complemento"),
                rs.getString("email"),
                rs.getInt("pacienteid"),
                rs.getString("planodesaude"),
                rs.getString("numcarteiraplano"),
                rs.getString("tiposanguineo"),
                rs.getTimestamp("ultimaconsulta")
            ),
            workerId
        );
    }

    public void startSchedule(CriarConsultaDTO dto) {
        String sql = """
            INSERT INTO consulta
            (
                dtconsulta,
                retorno,
                statusconsulta,
                pacienteid,
                funcionarioid
            )

            VALUES (?, ?, ?, ?, ?)
        """;

        jdbc.update(
            sql,
            dto.dataConsulta(),
            dto.retorno(),
            "EM_ANDAMENTO",
            dto.pacienteId(),
            dto.funcionarioId()
        );
    }
}