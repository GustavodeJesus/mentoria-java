package br.com.mentoriajava.produtos;

import java.util.UUID;

public class Produto {

    //atributos
    private final String codigoProduto;
    private String nomeProduto;
    private String categoriaProduto;
    private Double precoProduto;
    private long estoqueProduto;

    //CONSTRUTOR DEFAULT
    public Produto ()
    {
        codigoProduto = UUID.randomUUID().toString();
    }

    //CONSTRUTOR
     public Produto (String _nomeProduto, String _categoriaProduto, Double _precoProduto, long _estoqueProduto)
     {
         this.codigoProduto = UUID.randomUUID().toString();
         this.nomeProduto = _nomeProduto;
         this.categoriaProduto = _categoriaProduto;
         this.precoProduto = _precoProduto;
         this.estoqueProduto = _estoqueProduto;
     }

     //MTODOS

    public String getCodigoProduto(){
        return this.codigoProduto;
    }

    public String getNomeProduto(){
        return this.nomeProduto;
    }

    public void setNomeProduto (String _nomeProduto){
        this.nomeProduto = _nomeProduto;
    }

    public String getCategoriaProduto(){
        return this.categoriaProduto;
    }

    public void setCategoriaProduto (String _categoriaProduto){
        this.categoriaProduto = _categoriaProduto;
    }

    public Double getPrecoProduto () {
        return this.precoProduto;
    }

    public void setPrecoProduto(Double _precoProduto){
        this.precoProduto = _precoProduto;
    }

    public long getEstoqueProduto () {
        return this.estoqueProduto;
    }

    public void setEstoqueProduto(long _estoqueProduto) {
        this.estoqueProduto = _estoqueProduto;
    }

}
