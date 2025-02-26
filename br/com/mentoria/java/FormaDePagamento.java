package br.com.mentoria.java;

public class FormaDePagamento {

    private String tipodepagamento;
    private int numeroMaximoParcelas;
    private String bandeira;

    public String getTipodepagamento() {
        return tipodepagamento;
    }

    public void setTipodepagamento(String tipodepagamento) {
        this.tipodepagamento = tipodepagamento;
    }

    public int getNumeroMaximoParcelas() {
        return numeroMaximoParcelas;
    }

    public void setNumeroMaximoParcelas(int numeroMaximoParcelas) {
        this.numeroMaximoParcelas = numeroMaximoParcelas;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
}
