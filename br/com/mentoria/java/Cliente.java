package br.com.mentoria.java;
import java.util.UUID;
import java.time.LocalDate;

public class Cliente {

    private String codigoCliente;
    private int numeroPedidos;
    private boolean possuiRestricoes;
    private final LocalDate dataCadastro;

    public Cliente(
            String codigoCliente,
            int numeroPedidos,
            boolean possuiRestricoes,
            LocalDate dataCadastro){
        this.codigoCliente = UUID.randomUUID().toString();
        this.numeroPedidos = numeroPedidos;
        this.possuiRestricoes = possuiRestricoes;
        this.dataCadastro = dataCadastro;
    }

    public String getCodigoCliente() {
        return this.codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
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
