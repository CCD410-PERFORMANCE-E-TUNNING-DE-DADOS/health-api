package com.healthapi.health_api.repository;

import com.healthapi.health_api.domain.Worker;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.Optional;

@Repository
public class WorkerRepository {

    private final JdbcTemplate jdbc;

    public WorkerRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Optional<Worker> findByLogin(String login) {

        String sql = """
            SELECT
                p.pessoaid AS id,
                p.cpf,
                p.nome AS name,
                p.dtnascimento AS birth_date,
                p.telefone AS phone_number,
                p.cep,
                p.cidade,
                p.uf,
                p.logradouro,
                p.numlogradouro AS num_logradouro,
                p.complemento AS complement,
                p.email,

                w.funcionarioid AS worker_id,
                w.login,
                w.senha AS password,
                w.statusfuncionario AS worker_status,
                w.dtcontratacao AS worker_start_date

            FROM funcionario w

            JOIN pessoa p
                ON p.pessoaid = w.pessoaid

            WHERE w.login = ?
        """;

        try {

            Worker worker = jdbc.queryForObject(
                sql,
                (rs, rowNum) -> new Worker(

                    rs.getLong("id"),
                    rs.getString("cpf"),
                    rs.getString("name"),
                    rs.getDate("birth_date"),
                    rs.getString("phone_number"),
                    rs.getString("cep"),
                    rs.getString("cidade"),
                    rs.getString("uf"),
                    rs.getString("logradouro"),
                    rs.getString("num_logradouro"),
                    rs.getString("complement"),
                    rs.getString("email"),

                    rs.getLong("worker_id"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("worker_status"),
                    rs.getDate("worker_start_date")
                ),
                login
            );

            return Optional.ofNullable(worker);

        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public Worker save(Worker worker) {

        // =========================
        // INSERT pessoa
        // =========================

        String personSql = """
            INSERT INTO pessoa (
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

        KeyHolder personKeyHolder = new GeneratedKeyHolder();

        jdbc.update(connection -> {

            PreparedStatement ps = connection.prepareStatement(
                personSql,
                new String[] { "pessoaid" }
            );

            ps.setString(1, worker.getCpf());
            ps.setString(2, worker.getName());

            ps.setDate(
                3,
                new java.sql.Date(
                    worker.getBirthDate().getTime()
                )
            );

            ps.setString(4, worker.getPhoneNumber());
            ps.setString(5, worker.getCep());
            ps.setString(6, worker.getCidade());
            ps.setString(7, worker.getUf());
            ps.setString(8, worker.getLogradouro());
            ps.setString(9, worker.getNumLogradouro());
            ps.setString(10, worker.getComplement());
            ps.setString(11, worker.getEmail());

            return ps;

        }, personKeyHolder);

        Long personId =
            personKeyHolder.getKey().longValue();

        worker.setId(personId);

        // =========================
        // INSERT funcionario
        // =========================

        String workerSql = """
            INSERT INTO funcionario (
                pessoaid,
                login,
                senha,
                statusfuncionario,
                dtcontratacao
            )
            VALUES (?, ?, ?, ?, ?)
        """;

        KeyHolder workerKeyHolder =
            new GeneratedKeyHolder();

        jdbc.update(connection -> {

            PreparedStatement ps = connection.prepareStatement(
                workerSql,
                new String[] { "funcionarioid" }
            );

            ps.setLong(1, personId);
            ps.setString(2, worker.getLogin());
            ps.setString(3, worker.getPassword());
            ps.setString(4, worker.getWorkerStatus());

            ps.setTimestamp(
                5,
                new java.sql.Timestamp(
                    worker.getWorkerStartDate().getTime()
                )
            );

            return ps;

        }, workerKeyHolder);

        Long workerId =
            workerKeyHolder.getKey().longValue();

        worker.setWorkerId(workerId);

        return worker;
    }
}