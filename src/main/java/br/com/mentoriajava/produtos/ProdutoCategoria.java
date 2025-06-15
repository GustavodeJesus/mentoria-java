package br.com.mentoriajava.produtos;

import java.util.UUID;

public class ProdutoCategoria {

    //ATRIBUTOS
    private final String codigoCategoria;
    private String descricao;

    //CONSTRUTOR
    public ProdutoCategoria(String descricao)
    {
        codigoCategoria = UUID.randomUUID().toString();
        this.descricao = descricao;
    }

    //MÉTODOS

    public String getCodigoCategoria() {
        return codigoCategoria;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
}
