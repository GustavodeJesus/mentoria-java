package br.com.mentoriajava;

import java.time.LocalDate;

public class Vendedor extends Pessoa {
    private String codigoVendedor;
    private String setor;

    public Vendedor(String cpf,
                    String nome,
                    Endereco endereco,
                    LocalDate dataNascimento,
                    String telefone,
                    String email,
                    StatusCivilEnum statusCivil,
                    String setor,
                    String codigoVendedor) {
        super(cpf,
                nome,
                endereco,
                dataNascimento,
                telefone,
                email,
                statusCivil);
        this.setor = setor;
        this.codigoVendedor = codigoVendedor;
    }

    public String getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(String codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
