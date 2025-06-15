package br.com.mentoriajava.cupons;

import br.com.mentoriajava.clientes.StatusCivilEnum;

import java.time.LocalDate;

public class Cupom {

    private String codigo;
    private double valorMinimo;
    private LocalDate dataValidade;
    private double porcentagemDesconto;
    private int limiteMaximoUso;
    private String descricao;
    private boolean status;
    CuponsEnum cuponsEnum;
    private int vezesUtilizado;

    public Cupom(String codigo, double valorMinimo, LocalDate dataValidade, double porcentagemDesconto,
                 int limiteMaximoUso, String descricao, boolean status, CuponsEnum cuponsEnum) {
        this.codigo = codigo;
        this.valorMinimo = valorMinimo;
        this.dataValidade = dataValidade;
        this.porcentagemDesconto = porcentagemDesconto;
        this.limiteMaximoUso = limiteMaximoUso;
        this.descricao = descricao;
        this.status = status;
        this.cuponsEnum = cuponsEnum;
        this.vezesUtilizado = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public CuponsEnum getCuponsEnum() {
        return cuponsEnum;
    }

    public void setCuponsEnum(CuponsEnum cuponsEnum) {
        this.cuponsEnum = cuponsEnum;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public double getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    public void setPorcentagemDesconto(double porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }

    public int getLimiteMaximoUso() {
        return limiteMaximoUso;
    }

    public void setLimiteMaximoUso(int limiteMaximoUso) {
        this.limiteMaximoUso = limiteMaximoUso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public int getVezesUtilizado() {
        return vezesUtilizado;
    }

    public void incrementarUSo() {
        this.vezesUtilizado++;
    }
}

