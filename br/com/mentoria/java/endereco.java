package br.com.mentoria.java;; // questionar o porque precisa incluir essa linha

public class Endereco{

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String pais;
    private String estado;
    private String cidade;
    private String cep;

    public Endereco(
            String logradouro,
            String numero,
            String complemento,
            String bairro,
            String pais,
            String estado,
            String cidade,
            String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
            }

}   