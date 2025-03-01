package br.com.mentoria.java;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CupomDeDesconto {

    private String codigo;
    private BigDecimal porcentagem;
    private BigDecimal valorMinimo;
    private LocalDate dataValidade;


    public CupomDeDesconto(String codigo,
                           BigDecimal porcentagem,
                           BigDecimal valorMinimo,
                           LocalDate dataValidade) {
        this.codigo = codigo;
        this.porcentagem = porcentagem;
        this.valorMinimo = valorMinimo;
        this.dataValidade = dataValidade;
    }


    public String getCodigo(){
        return this.codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public BigDecimal getPorcentagem(){
        return this.porcentagem;
    }

    public void setPorcentagem(BigDecimal Porcentagem){
        this.porcentagem = porcentagem;
    }

}
