package br.com.mentoria.java;

import java.math.BigDecimal;

public class Entrega {

    private Endereco endereco;
    private String nomeTransportadora;
    private BigDecimal valorFrete;

    public Entrega(
            Endereco endereco,
            String nomeTransportadora,
            BigDecimal valorFrete){
        this.endereco = endereco;
        this.nomeTransportadora = nomeTransportadora;
        this.valorFrete = valorFrete;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNomeTransportadora() {
        return this.nomeTransportadora;
    }

    public void setNomeTransportadora(String nomeTransportadora) {
        this.nomeTransportadora = nomeTransportadora;
    }

    public BigDecimal getValorFrete() {
        return this.valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }
}
