package br.com.mentoriajava.produtos;

import br.com.mentoriajava.database.ProdutoDataSource;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.StringConverter;

public class ProdutosScreen extends VBox {

    private final TextField campoNome = new TextField();
    private final TextField campoPreco = new TextField();
    private final TextField campoEstoque = new TextField();
    private final ComboBox<ProdutoCategoria> comboBoxCategoria = new ComboBox<>();


    public ProdutosScreen() {
        configurarLayout();
    }

    private void configurarLayout()
    {
        setSpacing(20);
        setPadding(new Insets(20));
        Label title = new Label("Tela de Produtos");
        title.setFont(Font.font("System",javafx.scene.text.FontWeight.BOLD,20));
        title.setStyle("-fx-text-fill: #1f2937;");
        setStyle("-fx-background-color: #ffffff;");


        VBox secaoFormulario = construirFormulario();
        getChildren().addAll(title, secaoFormulario);
    }

    private VBox construirFormulario() {
        VBox containerFormulario = new VBox (10);
        containerFormulario.setPadding(new Insets(20));
        containerFormulario.setStyle("-fx-background-color: #f9fafb; -fx-border-color: #e5e7eb; -fx-border-radius: 8; -fx-background-radius: 8;");

        GridPane grid = configurarGridFormulario();
        Button botaoCadastrar = criarBotaoCadastrar();

        HBox boxBotao = new HBox(botaoCadastrar);
        boxBotao.setAlignment(Pos.CENTER_RIGHT);

        containerFormulario.getChildren().addAll(grid,boxBotao);
        return containerFormulario;
    }

    private GridPane configurarGridFormulario(){
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER_LEFT);

        campoNome.setPromptText("Nome Produto");
        campoNome.setPrefWidth(250);
        comboBoxCategoria.setPromptText("Categoria");
        comboBoxCategoria.setItems(ProdutoDataSource.getInstanciaProduto().getListaDeCategorias());
        comboBoxCategoria.setConverter(new StringConverter<>(){

            @Override
            public String toString(ProdutoCategoria produtoCategoria) {
                return produtoCategoria.getDescricao();
            }

            @Override
            public ProdutoCategoria fromString(String s) {
                return null;
            }
        });
        campoPreco.setPromptText("Preço");
        campoEstoque.setPromptText("Estoque");

        grid.add(new Label("Nome:"),0,0);
        grid.add(campoNome,1,0);
        grid.add(new Label("Categoria:"),2,0);
        grid.add(comboBoxCategoria,3,0);


        grid.add(new Label("Preço:"),0,1);
        grid.add(campoPreco,1,1);
        grid.add(new Label("Estoque:"),2,1);
        grid.add(campoEstoque,3,1);

        return grid;
    }

    private Button criarBotaoCadastrar()
    {
        Button botaoCadastrar = new Button("Cadastrar Produto");
        botaoCadastrar.setStyle("-fx-background-color: #3b82f6; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-weight: bold; -fx-background-radius: 6;");
        //botaoCadastrar.setOnAction(event -> cadastrarProduto()); **CRIAR METODO
        return botaoCadastrar;
    }

  /* private void cadastrarProduto()
    {
        String nome = campoNome.getText();
        ProdutoCategoria categoria = comboBoxCategoria.getValue();
        Double preco = Double.parseDouble(campoPreco.getText());
        Long estoque = Long.parseLong(campoEstoque.getText());

        **FINALIZAR

    }*/

}