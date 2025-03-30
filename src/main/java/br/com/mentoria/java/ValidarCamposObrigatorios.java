package br.com.mentoria.java;

public class ValidarCamposObrigatorios {

    public boolean ValidaCamposVazios(
            String logradouro,
            String numero,
            String complemento,
            String bairro,
            String pais,
            String estado,
            String cidade,
            String cep){


        if (logradouro == null || logradouro.isEmpty()) {return false;}
        if (numero == null || numero.isEmpty()) {return false;}
        if (complemento == null || complemento.isEmpty()) {return false;}
        if (bairro == null || bairro.isEmpty()) {return false;}
        if (pais == null || pais.isEmpty()) {return false;}
        if (estado == null || cidade.isEmpty()) {return false;}
        if (cep == null || cep.isEmpty()) {return false;}

        return true;

    }
}
