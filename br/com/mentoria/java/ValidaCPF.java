package br.com.mentoria.java;

import java.sql.SQLOutput;

public class ValidaCPF {
    public String removerCaracteresNaoNumericos (String cpf){
        String cpfSemCaracteresNaoNumericos = cpf.replace(".", "").replace("-", "");
        return cpfSemCaracteresNaoNumericos;
    }

    public boolean validaTamanhoCPF (String cpf){
        if (cpf.length() != 11){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean validaDigitosIguais (String cpf){
        for (int i = 1; i <= cpf.length(); i++){
            if (i == 11){
                if (cpf.charAt(i-2) != cpf.charAt(i-1)){
                    return true;
                }
            }
            if (cpf.charAt(i-1) != cpf.charAt(i)){
                return true;
            }
        }
        return false;
    }
}
