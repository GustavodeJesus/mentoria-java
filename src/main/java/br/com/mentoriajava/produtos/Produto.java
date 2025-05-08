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
     public Produto (String nomeProduto, String categoriaProduto, Double precoProduto, long estoqueProduto)
     {
         this.codigoProduto = UUID.randomUUID().toString();
         this.nomeProduto = nomeProduto;
         this.categoriaProduto = categoriaProduto;
         this.precoProduto = precoProduto;
         this.estoqueProduto = estoqueProduto;
     }

     //MÉTODOS

    public String getCodigoProduto(){
        return this.codigoProduto;
    }

    public String getNomeProduto(){
        return this.nomeProduto;
    }

    public void setNomeProduto (String nomeProduto){
        this.nomeProduto = nomeProduto;
    }

    public String getCategoriaProduto(){
        return this.categoriaProduto;
    }

    public void setCategoriaProduto (String categoriaProduto){
        this.categoriaProduto = categoriaProduto;
    }

    public Double getPrecoProduto () {
        return this.precoProduto;
    }

    public void setPrecoProduto(Double precoProduto){
        this.precoProduto = precoProduto;
    }

    public long getEstoqueProduto () {
        return this.estoqueProduto;
    }

    public void setEstoqueProduto(long estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
    }

}
