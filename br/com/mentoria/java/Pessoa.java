package br.com.mentoria.java;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {
    private String cpf;
    private String nome;
    private Endereco endereco;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private StatusCivilEnum statusCivil;

    public Pessoa(
            String cpf,
            String nome,
            Endereco endereco,
            LocalDate dataNascimento,
            String telefone,
            String email,
            StatusCivilEnum statusCivil) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.statusCivil = statusCivil;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StatusCivilEnum getStatusCivil() {
        return statusCivil;
    }

    public void setStatusCivil(StatusCivilEnum statusCivil) {
        this.statusCivil = statusCivil;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    @Override
    public boolean equals(Object cpf) {
        if(this == cpf) return true;
        if (cpf == null || getClass() != cpf.getClass()) return false;
        Pessoa pessoa = (Pessoa) cpf;
        return Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
