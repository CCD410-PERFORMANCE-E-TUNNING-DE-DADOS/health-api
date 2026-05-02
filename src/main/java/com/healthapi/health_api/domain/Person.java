package com.healthapi.health_api.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    private Long id;
    private String cpf;
    private String name;
    private Date birthDate;
    private String phoneNumber;
    private String cep;
    private String cidade;
    private String uf;
    private String logradouro;
    private String numLogradouro;
    private String complement;
    private String email;

    public Person(Long id, String cpf, String name, Date birthDate, String phoneNumber, String cep, String cidade,
                  String uf, String logradouro, String numLogradouro, String complement, String email) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.logradouro = logradouro;
        this.numLogradouro = numLogradouro;
        this.complement = complement;
        this.email = email;
    }

    public Person() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumLogradouro() {
        return numLogradouro;
    }

    public void setNumLogradouro(String numLogradouro) {
        this.numLogradouro = numLogradouro;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
