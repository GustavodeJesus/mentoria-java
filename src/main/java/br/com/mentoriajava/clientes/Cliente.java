package br.com.mentoriajava.clientes;

import br.com.mentoriajava.base.Endereco;
import br.com.mentoriajava.base.Pessoa;

import java.time.LocalDate;
import java.util.UUID;

public class Cliente extends Pessoa {

    private final String codigoCliente;
    private int numeroPedidos;
    private boolean possuiRestricoes;
    private final LocalDate dataCadastro;

    public Cliente (){
        super();
        this.dataCadastro = LocalDate.now();
        this.codigoCliente = UUID.randomUUID().toString();
    }

    public Cliente(
            String cpf,
            String nome,
            Endereco endereco,
            LocalDate dataNascimento,
            String telefone,
            String email,
            StatusCivilEnum statusCivil
    ){
        super(cpf, nome, endereco, dataNascimento, telefone, email, statusCivil);
        this.codigoCliente = UUID.randomUUID().toString();
        this.numeroPedidos = 0;
        this.possuiRestricoes = false;
        this.dataCadastro = LocalDate.now();

    }

    public void atualizarNumeroDePedidos(){
        numeroPedidos++;
    }

    public String getCodigoCliente() {
        return this.codigoCliente;
    }

    public int getNumeroPedidos() {
        return this.numeroPedidos;
    }

    public void setNumeroPedidos(int numeroPedidos) {
        this.numeroPedidos = numeroPedidos;
    }

    public boolean getPossuiRestricoes() {
        return this.possuiRestricoes;
    }

    public void setPossuiRestricoes(boolean possuiRestricoes) {
        this.possuiRestricoes = possuiRestricoes;
    }

    public LocalDate getDataCadastro() {
        return this.dataCadastro;
    }



}
