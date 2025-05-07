package br.com.mentoriajava.database;

import br.com.mentoriajava.produtos.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProdutoDataSource {

    //Singleton
    private static final ProdutoDataSource instancia = new ProdutoDataSource();

    //Construtor
    private ProdutoDataSource(){

    }

    //Lista de Produtos
    private final ObservableList<Produto> listaDeProdutos = FXCollections.observableArrayList(
            new Produto ("Kaiak 100ML" , "Perfume" , 150.9, 15),
            new Produto ("Hidratante Flor de Cerejeira 250ML" , "Creme" , 99.90, 12),
            new Produto ("Sabonete Vegano Cereja UN" , "Sabonete", 4.90, 89),
            new Produto ("Ilia 50ML" , "Perfume", 185.9, 22),
            new Produto( "Essencial Fem 120ML" , "Perfume" , 179.9 , 6),
            new Produto ("Creme Nutritivo Ameixa 400ML" , "Creme" , 44.9 , 55),
            new Produto("Sabonete Vegano Alecrim UN" , "Sabonete", 4.90, 52),
            new Produto("Sabonete Vegano Amora UN" , "Sabonete", 4.90, 13),
            new Produto("Una 75ML", "Perfume" , 219.90 , 3),
            new Produto("Hidratante Baunilha 250ML" , "Creme", 99.9,9)
    );

    //Métodos
    public static ProdutoDataSource getInstanciaProduto() {
        return instancia;
    }

    public ObservableList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void adicionarProduto (Produto produto){
        listaDeProdutos.add(produto);
    }

    public void removerProduto (Produto produto){
        listaDeProdutos.remove(produto);
    }
}
