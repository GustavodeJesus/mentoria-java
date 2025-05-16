package br.com.mentoriajava.produtos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ProdutosScreen extends VBox {

    private final TextField campoNome = new TextField();
    private final TextField campoCategoria = new TextField();
    private final TextField campoPreco = new TextField();
    private final TextField campoEstoque = new TextField();


    public ProdutosScreen() {
        setSpacing(20);
        setPadding(new Insets(20));
        Label title = new Label("Tela de Produtos");
        title.setFont(Font.font("System",javafx.scene.text.FontWeight.BOLD,20));
        title.setStyle("-fx-text-fill: #1f2937;");


        VBox secaoFormulario = construirFormulario();
        getChildren().addAll(title, secaoFormulario);
    }

    private VBox construirFormulario() {
        VBox containerFormulario = new VBox (10);
        containerFormulario.setPadding(new Insets(20));
        containerFormulario.setStyle("-fx-background-color: #f9fafb; -fx-border-color: #e5e7eb; -fx-border-radius: 8; -fx-background-radius: 8;");

        GridPane grid = configurarGridFormulario();

        containerFormulario.getChildren().addAll(grid);
        return containerFormulario;
    }

    private GridPane configurarGridFormulario(){
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER_LEFT);

        campoNome.setPromptText("Nome Produto");
        campoNome.setPrefWidth(250);
        campoCategoria.setPromptText("Categoria");
        campoPreco.setPromptText("Preço");
        campoEstoque.setPromptText("Estoque");

        grid.add(new Label("Nome:"),0,0);
        grid.add(campoNome,1,0);
        grid.add(new Label("Categoria:"),2,0);
        grid.add(campoCategoria,3,0);

        grid.add(new Label("Preço:"),0,1);
        grid.add(campoPreco,1,1);
        grid.add(new Label("Estoque:"),2,1);
        grid.add(campoEstoque,3,1);

        return grid;
    }


}