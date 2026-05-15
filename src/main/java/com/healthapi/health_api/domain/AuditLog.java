package com.healthapi.health_api.domain;

import java.time.Instant;
import java.util.UUID;

public class AuditLog {

    private String entidade;
    private UUID entidadeId;
    private Instant timestampEvento;
    private UUID usuarioId;
    private String campoAlterado;
    private String valorAntigo;
    private String valorNovo;

    public AuditLog() {}

    public AuditLog(String entidade, UUID entidadeId, Instant timestampEvento,
                    UUID usuarioId, String campoAlterado, String valorAntigo,
                    String valorNovo) {

        this.entidade = entidade;
        this.entidadeId = entidadeId;
        this.timestampEvento = timestampEvento;
        this.usuarioId = usuarioId;
        this.campoAlterado = campoAlterado;
        this.valorAntigo = valorAntigo;
        this.valorNovo = valorNovo;
    }
    
    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public UUID getEntidadeId() {
        return entidadeId;
    }

    public void setEntidadeId(UUID entidadeId) {
        this.entidadeId = entidadeId;
    }

    public Instant getTimestampEvento() {
        return timestampEvento;
    }

    public void setTimestampEvento(Instant timestampEvento) {
        this.timestampEvento = timestampEvento;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCampoAlterado() {
        return campoAlterado;
    }

    public void setCampoAlterado(String campoAlterado) {
        this.campoAlterado = campoAlterado;
    }

    public String getValorAntigo() {
        return valorAntigo;
    }

    public void setValorAntigo(String valorAntigo) {
        this.valorAntigo = valorAntigo;
    }

    public String getValorNovo() {
        return valorNovo;
    }

    public void setValorNovo(String valorNovo) {
        this.valorNovo = valorNovo;
    }
    
}