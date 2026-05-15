package com.healthapi.health_api.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.Row;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import com.healthapi.health_api.domain.AuditLog;

@Repository
public class SystemRepository {

    private final JdbcTemplate jdbc;
    private final CqlSession cassandra;

    public SystemRepository(JdbcTemplate jdbc, CqlSession cassandra) {
        this.jdbc = jdbc;
        this.cassandra = cassandra;
    }

    public boolean workerAlreadyHasRole(int funcionarioId) {
        String sql = """
            SELECT cargo

            FROM funcionario

            WHERE funcionarioid = ?
        """;

        String cargo =
                jdbc.queryForObject(
                        sql,
                        String.class,
                        funcionarioId
                );

        return cargo != null;
    }

    public void assignDoctor(int funcionarioId, String crm, String especialidade) {
        jdbc.update(
            """
            UPDATE funcionario

            SET cargo = 'MEDICO'

            WHERE funcionarioid = ?
            """,
            funcionarioId
        );

        jdbc.update(
            """
            INSERT INTO medico
            (
                especialidade,
                crm,
                funcionarioid
            )

            VALUES (?, ?, ?)
            """,

            especialidade,
            crm,
            funcionarioId
        );
    }

    public void assignNurse(int funcionarioId, String coren) {
        jdbc.update(
            """
            UPDATE funcionario

            SET cargo = 'ENFERMEIRO'

            WHERE funcionarioid = ?
            """,
            funcionarioId
        );

        jdbc.update(
            """
            INSERT INTO enfermeiro
            (
                coren,
                funcionarioid
            )

            VALUES (?, ?)
            """,

            coren,
            funcionarioId
        );
    }

    public void assignReceptionist(int funcionarioId, String setor, Integer ramal, String telefoneProfissional) {
        jdbc.update(
            """
            UPDATE funcionario

            SET cargo = 'RECEPCIONISTA'

            WHERE funcionarioid = ?
            """,
            funcionarioId
        );

        jdbc.update(
            """
            INSERT INTO recepcionista
            (
                setor,
                ramal,
                telefoneprofissional,
                funcionarioid
            )

            VALUES (?, ?, ?, ?)
            """,

            setor,
            ramal,
            telefoneProfissional,
            funcionarioId
        );
    }

    public List<AuditLog> listLogs() {
        String cql = """
            SELECT *
            FROM auditoria_dados
            WHERE data_evento = '2026-05-14'
            LIMIT 10;
        """;

        List<AuditLog> logs = new ArrayList<>();
        for (Row row : cassandra.execute(cql)) {
            logs.add(
                new AuditLog(
                    row.getString("entidade"),
                    row.getUuid("entidade_id"),
                    row.getInstant("timestamp_evento"),
                    row.getUuid("usuario_id"),
                    row.getString("campo_alterado"),
                    row.getString("valor_antigo"),
                    row.getString("valor_novo")
                )
            );
        }

        return logs;
    }
}