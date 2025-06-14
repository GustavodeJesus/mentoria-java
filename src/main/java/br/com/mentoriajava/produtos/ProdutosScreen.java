package br.com.mentoriajava.produtos;

import br.com.mentoriajava.database.ProdutoDataSource;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.StringConverter;
import java.text.NumberFormat;
import java.util.Locale;

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
        Label title = new Label("Cadastro de Produtos");
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
        botaoCadastrar.setOnAction(event -> cadastrarProduto());
        return botaoCadastrar;
    }

    private void cadastrarProduto()
    {
        String nome = campoNome.getText();
        ProdutoCategoria categoria = comboBoxCategoria.getValue();
        Double preco;
        String auxPreco = campoPreco.getText().replace(".","").replace(",",".");

        try {
            preco = Double.parseDouble(auxPreco);
        }
        catch (NumberFormatException exception){
            preco = null;
        }
        Long estoque;
        try {
            estoque = Long.parseLong(campoEstoque.getText());
        }
        catch (NumberFormatException exception)
        {
            estoque = null;
        }


        if (nome.isEmpty() || categoria == null || preco == null || estoque == null){

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Por favor, preencha os campos obrigatórios!");

            String validacaoNome = "";
            String validacaoCategoria = "";
            String validacaoPreco = "";
            String validacaoEstoque = "";

            if (nome.isEmpty()) {validacaoNome = " *Nome";}
            if (categoria == null) {validacaoCategoria = " *Categoria";}
            if (preco == null) {validacaoPreco = " *Preço";}
            if (estoque == null) {validacaoEstoque = " *Estoque";}



            alerta.setHeaderText(null);
            alerta.setContentText(validacaoNome + validacaoCategoria + validacaoPreco + validacaoEstoque);
            alerta.showAndWait();
        }
        else{
            Produto produto = new Produto(nome, categoria,preco,estoque);
            ProdutoDataSource.getInstanciaProduto().adicionarProduto(produto);
            limparCamposFormulario();

            Alert popUp = new Alert(Alert.AlertType.INFORMATION);
            popUp.setTitle(null);
            popUp.setHeaderText(null);
            popUp.setContentText("Produto cadastrado com sucesso!");
            popUp.showAndWait();
        }


    }

    private void limparCamposFormulario() {
        campoNome.clear();
        campoPreco.clear();
        campoEstoque.clear();
        this.comboBoxCategoria.setValue(null);
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
        adicionarColunasPreco();
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

    private void adicionarColunasPreco(){
        TableColumn<Produto, String> colunaPreco = new TableColumn<>("Preço");
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.of("pt","BR"));
        colunaPreco.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(formatador.format(cellData.getValue().getPrecoProduto())));
        colunaPreco.setStyle("-fx-alignment: CENTER;");
        tabelaProdutos.getColumns().add(colunaPreco);
    }

    private void adicionarColunaCategoria(){
        TableColumn<Produto, String> colunaCategoria = new TableColumn<>("Categoria");
        colunaCategoria.setCellValueFactory( cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCategoriaProduto().getDescricao()));
        colunaCategoria.setStyle("-fx-alignment: CENTER;");

        tabelaProdutos.getColumns().add(colunaCategoria);
    }

    private void adicionarColunaAcoes(){
        TableColumn<Produto, Void> colunaAcao = new TableColumn ("Ações");
        colunaAcao.setCellFactory(param -> new TableCell<>() {
            private final Button botaoRemover = criarBotaoRemover();

            @Override
            protected void updateItem(Void item, boolean empty){
                super.updateItem(item,empty);
                setGraphic(empty ? null : botaoRemover);
            }

            private Button criarBotaoRemover() {
                Button botao = new Button();
                ImageView icone = new ImageView(new Image(getClass().getResourceAsStream("/icons/lixeira.png")));
                icone.setFitWidth(16);
                icone.setFitHeight(16);
                botao.setGraphic(icone);
                botao.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
                botao.setOnAction(event -> removerProduto(getIndex()));
                return botao;
            }
        });
        colunaAcao.setStyle("-fx-alignment: CENTER;");
        tabelaProdutos.getColumns().add(colunaAcao);

    }

    private void removerProduto(int index){
        Produto produto = tabelaProdutos.getItems().get(index);
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Remover Produto");
        alerta.setHeaderText("Deseja realmente remover o produto?");
        alerta.setContentText(produto.getNomeProduto());

        alerta.showAndWait().ifPresent(resposta -> {
            if (resposta == ButtonType.OK) {
                ProdutoDataSource.getInstanciaProduto().removerProduto(produto);
            }
        });
    }

    private void popularTabela() {
        tabelaProdutos.setItems(ProdutoDataSource.getInstanciaProduto().getListaDeProdutos());
    }

}