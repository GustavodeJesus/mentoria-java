package br.com.mentoriajava.database;

import br.com.mentoriajava.produtos.Produto;
import br.com.mentoriajava.produtos.ProdutoCategoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProdutoDataSource {

    //Singleton
    private static final ProdutoDataSource instancia = new ProdutoDataSource();

    //Construtor
    private ProdutoDataSource(){

    }

    //Lista de Categorias
    private final ObservableList<ProdutoCategoria> listaDeCategorias = FXCollections.observableArrayList(
            new ProdutoCategoria ("Perfume"),
            new ProdutoCategoria("Creme"),
            new ProdutoCategoria("Sabonete")
    );

    //Lista de Produtos
    private final ObservableList<Produto> listaDeProdutos = FXCollections.observableArrayList(
            new Produto ("Kaiak 100ML" , new ProdutoCategoria("Perfume"), 150.9, 15),
            new Produto ("Hidratante Flor de Cerejeira 250ML" , new ProdutoCategoria("Creme") , 99.90, 12),
            new Produto ("Sabonete Vegano Cereja UN" , new ProdutoCategoria("Sabonete"), 4.90, 89),
            new Produto ("Ilia 50ML" , new ProdutoCategoria("Perfume"), 185.9, 22),
            new Produto( "Essencial Fem 120ML" , new ProdutoCategoria("Perfume") , 179.9 , 6),
            new Produto ("Creme Nutritivo Ameixa 400ML" , new ProdutoCategoria("Creme") , 44.9 , 55),
            new Produto("Sabonete Vegano Alecrim UN" , new ProdutoCategoria("Sabonete"), 4.90, 52),
            new Produto("Sabonete Vegano Amora UN" , new ProdutoCategoria("Sabonete"), 4.90, 13),
            new Produto("Una 75ML", new ProdutoCategoria("Perfume") , 219.90 , 3),
            new Produto("Hidratante Baunilha 250ML" , new ProdutoCategoria("Creme"), 99.9,9)
    );

    //Métodos
    public static ProdutoDataSource getInstanciaProduto() {
        return instancia;
    }

    public ObservableList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public ObservableList<ProdutoCategoria> getListaDeCategorias(){
        return listaDeCategorias;
    }

    public void adicionarProduto (Produto produto){
        listaDeProdutos.add(produto);
    }

    public void removerProduto (Produto produto){
        listaDeProdutos.remove(produto);
    }
}
