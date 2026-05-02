package com.healthapi.health_api.repository;

import com.healthapi.health_api.domain.Worker;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class WorkerRepository {

    private final JdbcTemplate jdbc;

    public WorkerRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Optional<Worker> findByLogin(String login) {
        String sql = """
            SELECT p.pessoaid AS id, p.cpf, p.nome AS name, p.dtnascimento AS birth_date,
                   p.telefone AS phone_number, p.cep, p.cidade, p.uf, p.logradouro,
                   p.numlogradouro AS num_logradouro, p.complemento AS complement,
                   p.email,
                   w.funcionarioid AS worker_id, w.login, w.senha AS password,
                   w.statusfuncionario AS worker_status, w.dtcontratacao AS worker_start_date
            FROM funcionario w
            JOIN pessoa p ON p.pessoaid = w.pessoaid
            WHERE w.login = ?
            """;

        try {
            Worker worker = jdbc.queryForObject(sql, (rs, rowNum) -> new Worker(
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
            ), login);
            return Optional.ofNullable(worker);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}