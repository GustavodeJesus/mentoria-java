package br.com.mentoria.java;

public class FormaDePagamento {

    private TiposDePagamentos tipo;
    private int numeroMaximoParcelas;
    private String bandeira;
    private final int MIN_PARCELAS = 1;
    private final int MAX_PARCELAS = 24;

    public FormaDePagamento(TiposDePagamentos tipo, int numeroMaximoParcelas, String bandeira) {
        this.tipo = tipo;
        this.numeroMaximoParcelas = numeroMaximoParcelas;
        this.bandeira = bandeira;
    }

    public boolean validarParcelamento(int parcelas) {

        if (parcelas >= MIN_PARCELAS && parcelas <= MAX_PARCELAS) {
            System.out.println(parcelas + " é um valor válido de parcelas");
            return true;

        } else {
            System.out.println(parcelas + " não é um valor válido de parcelas");
            return false;

        }
    }


    public TiposDePagamentos getTipo() {
        return this.tipo;
    }

    public void setTipo(TiposDePagamentos tipo) {
        this.tipo = tipo;
    }

    public int getNumeroMaximoParcelas() {
        return this.numeroMaximoParcelas;
    }

    public void setNumeroMaximoParcelas(int numeroMaximoParcelas) {
        this.numeroMaximoParcelas = numeroMaximoParcelas;
    }

    public String getBandeira() {
        return this.bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
}
