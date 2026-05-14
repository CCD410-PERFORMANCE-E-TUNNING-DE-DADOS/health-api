package com.healthapi.health_api.repository;

import com.healthapi.health_api.domain.Schedule;

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
}