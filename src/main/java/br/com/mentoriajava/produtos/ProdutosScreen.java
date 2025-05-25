package br.com.mentoriajava.produtos;

import br.com.mentoriajava.database.ProdutoDataSource;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private final TableView<Produto> tabelaProdutos = new TableView<>();


    public ProdutosScreen() {
        configurarLayout();
        popularTabela();
    }

    private void configurarLayout() {
        setSpacing(20);
        setPadding(new Insets(20));
        Label title = new Label("Tela de Produtos");
        title.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 20));
        title.setStyle("-fx-text-fill: #1f2937;");
        setStyle("-fx-background-color: #ffffff;");


        VBox secaoFormulario = construirFormulario();
        VBox secaoTabela = construirTabela();

        getChildren().addAll(title, secaoFormulario, secaoTabela);
    }

    private VBox construirFormulario() {
        VBox containerFormulario = new VBox(10);
        containerFormulario.setPadding(new Insets(20));
        containerFormulario.setStyle("-fx-background-color: #f9fafb; -fx-border-color: #e5e7eb; -fx-border-radius: 8; -fx-background-radius: 8;");

        GridPane grid = configurarGridFormulario();
        Button botaoCadastrar = criarBotaoCadastrar();

        HBox boxBotao = new HBox(botaoCadastrar);
        boxBotao.setAlignment(Pos.CENTER_RIGHT);

        containerFormulario.getChildren().addAll(grid, boxBotao);
        return containerFormulario;
    }

    private GridPane configurarGridFormulario() {
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER_LEFT);

        campoNome.setPromptText("Nome Produto");
        campoNome.setPrefWidth(250);
        comboBoxCategoria.setPromptText("Categoria");
        comboBoxCategoria.setItems(ProdutoDataSource.getInstanciaProduto().getListaDeCategorias());
        comboBoxCategoria.setConverter(new StringConverter<>() {

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
        campoEstoque.setPromptText("Estoque Inicial");

        grid.add(new Label("Nome:"), 0, 0);
        grid.add(campoNome, 1, 0);
        grid.add(new Label("Categoria:"), 2, 0);
        grid.add(comboBoxCategoria, 3, 0);


        grid.add(new Label("Preço:"), 0, 1);
        grid.add(campoPreco, 1, 1);
        grid.add(new Label("Estoque Inicial:"), 2, 1);
        grid.add(campoEstoque, 3, 1);

        return grid;
    }

    private Button criarBotaoCadastrar() {
        Button botaoCadastrar = new Button("Cadastrar Produto");
        botaoCadastrar.setStyle("-fx-background-color: #3b82f6; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-weight: bold; -fx-background-radius: 6;");
        //botaoCadastrar.setOnAction(event -> cadastrarProduto()); **CRIAR METODO
        return botaoCadastrar;
    }

    private void cadastrarProduto()
    {
        String nome = campoNome.getText();
        ProdutoCategoria categoria = comboBoxCategoria.getValue();
        Double preco = Double.parseDouble(campoPreco.getText());
        Long estoque = Long.parseLong(campoEstoque.getText());


    }

    private void limparCamposFormulario() {
        campoNome.clear();
        campoPreco.clear();
        campoEstoque.clear();
        comboBoxCategoria.setValue(null);
    }

    private VBox construirTabela() {
        VBox caixaTabela = new VBox(10);
        caixaTabela.setStyle("-fx-background-color: #f1f5f9; -fx-border-color: #e2e8f0; -fx-border-radius: 8; -fx-background-radius: 8;");
        caixaTabela.setPadding(new Insets(15));

        configurarTabela();
        adicionarColunasTabela();

        Label titulo = new Label("Produtos Cadastrados");
        titulo.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 16));

        caixaTabela.getChildren().addAll(titulo, tabelaProdutos);
        return caixaTabela;
    }

    private void configurarTabela() {
        tabelaProdutos.setItems(ProdutoDataSource.getInstanciaProduto().getListaDeProdutos());
        tabelaProdutos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabelaProdutos.setStyle("""
                    -fx-background-color: white;
                    -fx-border-color: #e5e7eb;
                    -fx-border-radius: 8;
                    -fx-table-cell-border-color: #f3f4f6;
                    -fx-padding: 8;
                """);
        tabelaProdutos.skinProperty().addListener((obs, oldSkin, newSkin) -> {
            tabelaProdutos.lookupAll(".column-header-background").forEach(header ->
                    header.setStyle("-fx-background-color: #e0f2fe;")
            );
        });
    }

    private void adicionarColunasTabela() {
        adicionarColuna("Nome", "nomeProduto", "CENTER-LEFT", true);
        adicionarColuna("Preço", "precoProduto", "CENTER", false);
        adicionarColuna("Estoque", "estoqueProduto", "CENTER", false);
        adicionarColunaCategoria();
        adicionarColunaAcoes();

    }

    private void adicionarColuna(String titulo,String propriedade, String alinhamento, boolean negrito) {
        TableColumn<Produto, String> coluna = new TableColumn<>(titulo);
        coluna.setCellValueFactory(new PropertyValueFactory<>(propriedade));
        coluna.setStyle("-fx-alignment: " + alinhamento + ";" + (negrito ? " -fx-font-weight: bold;" : ""));
        tabelaProdutos.getColumns().add(coluna);
    }

    private void adicionarColunaCategoria(){
        TableColumn<Produto, String> colunaCategoria = new TableColumn<>("Categoria");
        colunaCategoria.setCellValueFactory( cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCategoriaProduto().getDescricao()));
        colunaCategoria.setStyle("-fx-alignment: CENTER;");

        tabelaProdutos.getColumns().add(colunaCategoria);
    }

    private void adicionarColunaAcoes(){

    }

    private void popularTabela() {
        tabelaProdutos.setItems(ProdutoDataSource.getInstanciaProduto().getListaDeProdutos());
    }

}