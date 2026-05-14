package com.healthapi.health_api.repository;

import com.healthapi.health_api.domain.Schedule;
import com.healthapi.health_api.domain.Patient;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepository {

    private final JdbcTemplate jdbc;

    public DoctorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Schedule> listSchedulesByDoc(
            Long workerId
    ) {

        String sql = """
            SELECT c.*
            FROM consulta c
            WHERE funcionarioid = ?
        """;

        return jdbc.query(
            sql,
            (rs, rowNum) -> new Schedule(
                rs.getLong("consultaid"),
                rs.getLong("pacienteid"),
                rs.getLong("funcionarioid"),
                rs.getTimestamp("dtconsulta"),
                rs.getBoolean("retorno"),
                rs.getString("descricao"),
                rs.getString("encaminhamento")
            ),
            workerId
        );
    }

    public List<Patient> listPatientsByDoc(
            Long workerId
    ) {

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
                rs.getLong("pessoaid"),
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
                rs.getLong("pacienteid"),
                rs.getString("planodesaude"),
                rs.getString("numcarteiraplano"),
                rs.getString("tiposanguineo"),
                rs.getTimestamp("ultimaconsulta")
            ),
            workerId
        );
    }
}