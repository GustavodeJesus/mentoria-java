package br.com.mentoriajava.base;

public class ValidaCPF {
    public String removerCaracteresNaoNumericos(String cpf) {
        String cpfSemCaracteresNaoNumericos = cpf.replace(".", "").replace("-", "");
        return cpfSemCaracteresNaoNumericos;
    }

    public boolean validaTamanhoCPF(String cpf) {
        if (cpf.length() != 11) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validaDigitosIguais(String cpf) {
        for (int i = 1; i <= cpf.length(); i++) {
            if (i == 11) {
                if (cpf.charAt(i - 2) != cpf.charAt(i - 1)) {
                    return true;
                }
            }
            if (cpf.charAt(i - 1) != cpf.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean validaDigitos(String cpfSemCaracteresNaoNumericos) {

        char digitoUm;
        char digitoDois;
        char digitoTres;
        char digitoQuatro;
        char digitoCinco;
        char digitoSeis;
        char digitoSete;
        char digitoOito;
        char digitoNove;
        char digitoDez;
        char digitoOnze;
        int somaTodosDois = 0;

        digitoUm = cpfSemCaracteresNaoNumericos.charAt(0);
        int digitoUmNumerico = Character.getNumericValue(digitoUm);

        digitoDois = cpfSemCaracteresNaoNumericos.charAt(1);
        int digitoDoisNumerico = Character.getNumericValue(digitoDois);

        digitoTres = cpfSemCaracteresNaoNumericos.charAt(2);
        int digitoTresNumerico = Character.getNumericValue(digitoTres);

        digitoQuatro = cpfSemCaracteresNaoNumericos.charAt(3);
        int digitoQuatroNumerico = Character.getNumericValue(digitoQuatro);

        digitoCinco = cpfSemCaracteresNaoNumericos.charAt(4);
        int digitoCincoNumerico = Character.getNumericValue(digitoCinco);

        digitoSeis = cpfSemCaracteresNaoNumericos.charAt(5);
        int digitoSeisNumerico = Character.getNumericValue(digitoSeis);

        digitoSete = cpfSemCaracteresNaoNumericos.charAt(6);
        int digitoSeteNumerico = Character.getNumericValue(digitoSete);

        digitoOito = cpfSemCaracteresNaoNumericos.charAt(7);
        int digitoOitoNumerico = Character.getNumericValue(digitoOito);

        digitoNove = cpfSemCaracteresNaoNumericos.charAt(8);
        int digitoNoveNumerico = Character.getNumericValue(digitoNove);

        digitoDez = cpfSemCaracteresNaoNumericos.charAt(9);
        int digitoDezNumerico = Character.getNumericValue(digitoDez);

        digitoOnze = cpfSemCaracteresNaoNumericos.charAt(10);
        int digitoOnzeNumerico = Character.getNumericValue(digitoOnze);

        int resultadoUm = digitoUmNumerico * 10;
        int resultadoDois = digitoDoisNumerico * 9;
        int resultadoTres = digitoTresNumerico * 8;
        int resultadoQuatro = digitoQuatroNumerico * 7;
        int resultadoCinco = digitoCincoNumerico * 6;
        int resultadoSeis = digitoSeisNumerico * 5;
        int resultadoSete = digitoSeteNumerico * 4;
        int resultadoOito = digitoOitoNumerico * 3;
        int resultadoNove = digitoNoveNumerico * 2;

        int somaTodos = resultadoUm + resultadoDois + resultadoTres + resultadoQuatro + resultadoCinco + resultadoSeis + resultadoSete + resultadoOito + resultadoNove;
        somaTodos = somaTodos % 11;
        somaTodos = 11 - somaTodos;
        if (somaTodos >= 10) {
            somaTodos = 0;
        } else {
            somaTodos = somaTodos;
        }

        if (somaTodos == digitoDezNumerico) {

            resultadoUm = digitoUmNumerico * 11;
            resultadoDois = digitoDoisNumerico * 10;
            resultadoTres = digitoTresNumerico * 9;
            resultadoQuatro = digitoQuatroNumerico * 8;
            resultadoCinco = digitoCincoNumerico * 7;
            resultadoSeis = digitoSeisNumerico * 6;
            resultadoSete = digitoSeteNumerico * 5;
            resultadoOito = digitoOitoNumerico * 4;
            resultadoNove = digitoNoveNumerico * 3;
            int resultadoDez = digitoDezNumerico * 2;

            somaTodosDois = resultadoUm + resultadoDois + resultadoTres + resultadoQuatro + resultadoCinco + resultadoSeis + resultadoSete + resultadoOito + resultadoNove + resultadoDez;
            somaTodosDois = somaTodosDois % 11;
            somaTodosDois = 11 - somaTodosDois;

            if (somaTodosDois >= 10) {
                somaTodosDois = 0;
            } else {
                somaTodosDois = somaTodosDois;
            }
        }
        if (digitoDezNumerico == somaTodos && digitoOnzeNumerico == somaTodosDois) {
            return true;
        } else {
            return false;
        }
    }
}
