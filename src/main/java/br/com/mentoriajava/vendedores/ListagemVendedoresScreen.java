package br.com.mentoriajava.vendedores;

import br.com.mentoriajava.database.VendedorDataSource;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ListagemVendedoresScreen extends VBox {

    private final TableView<Vendedor> tabelaVendedores = new TableView<>();
    private BorderPane root;

    public ListagemVendedoresScreen(BorderPane root) {
        configurarLayoutPrincipal();
        this.root = root;
        popularTabela();
    }

    private void configurarLayoutPrincipal() {
        setSpacing(20);
        setPadding(new Insets(20));
        setStyle("-fx-background-color: #ffffff;");

        Label titulo = new Label("Vendedores");
        titulo.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 20));
        titulo.setStyle("-fx-text-fill: #1f2937;");

        VBox secaoTabela = construirTabela();
        getChildren().addAll(titulo, secaoTabela);
    }

    private VBox construirTabela() {
        VBox caixaTabela = new VBox(10);
        caixaTabela.setStyle("-fx-background-color: #f1f5f9; -fx-border-color: #e2e8f0; -fx-border-radius: 8; -fx-background-radius: 8;");
        caixaTabela.setPadding(new Insets(15));

        configurarTabela();
        adicionarColunasTabela();
        Button botaoRetornarCadastro = criarBotaoVendedoresCadastrados();

        HBox boxBotao = new HBox(botaoRetornarCadastro);
        boxBotao.setAlignment(Pos.CENTER_RIGHT);
        boxBotao.setPadding(new Insets(5));
        Label titulo = new Label("Vendedores Cadastrados");
        titulo.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 16));

        caixaTabela.getChildren().addAll(titulo, tabelaVendedores, boxBotao);
        return caixaTabela;
    }

    private void configurarTabela() {
        tabelaVendedores.setItems(VendedorDataSource.getInstancia().getListaVendedores());
        tabelaVendedores.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabelaVendedores.setStyle("""
                    -fx-background-color: white;
                    -fx-border-color: #e5e7eb;
                    -fx-border-radius: 8;
                    -fx-table-cell-border-color: #f3f4f6;
                    -fx-padding: 8;
                """);
        tabelaVendedores.skinProperty().addListener((obs, oldSkin, newSkin) -> {
            tabelaVendedores.lookupAll(".column-header-background").forEach(header ->
                    header.setStyle("-fx-background-color: #e0f2fe;")
            );
        });
    }

    private void adicionarColunaLogradouro() {
        TableColumn<Vendedor, String> colunaLogradouro = new TableColumn<>("Logradouro");
        colunaLogradouro.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(cellData.getValue().getEndereco().getLogradouro()));
        colunaLogradouro.setStyle("-fx-alignment: CENTER-LEFT;");
        tabelaVendedores.getColumns().add(colunaLogradouro);
    }

    private void adicionarColunaNumero() {
        TableColumn<Vendedor, String> colunaNumero = new TableColumn<>("Numero");
        colunaNumero.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(cellData.getValue().getEndereco().getNumero()));
        colunaNumero.setStyle("-fx-alignment: CENTER-LEFT;");
        tabelaVendedores.getColumns().add(colunaNumero);
    }

    private void adicionarColunaComplemento() {
        TableColumn<Vendedor, String> colunaComplemento = new TableColumn<>("Complemento");
        colunaComplemento.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(cellData.getValue().getEndereco().getComplemento()));
        colunaComplemento.setStyle("-fx-alignment: CENTER-LEFT;");
        tabelaVendedores.getColumns().add(colunaComplemento);
    }

    private void adicionarColunaBairro() {
        TableColumn<Vendedor, String> colunaBairro = new TableColumn<>("Bairro");
        colunaBairro.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(cellData.getValue().getEndereco().getBairro()));
        colunaBairro.setStyle("-fx-alignment: CENTER-LEFT;");
        tabelaVendedores.getColumns().add(colunaBairro);
    }

    private void adicionarColunaPais() {
        TableColumn<Vendedor, String> colunaPais = new TableColumn<>("Pais");
        colunaPais.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(cellData.getValue().getEndereco().getPais()));
        colunaPais.setStyle("-fx-alignment: CENTER-LEFT;");
        tabelaVendedores.getColumns().add(colunaPais);
    }

    private void adicionarColunaEstado() {
        TableColumn<Vendedor, String> colunaEstado = new TableColumn<>("Estado");
        colunaEstado.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(cellData.getValue().getEndereco().getEstado()));
        colunaEstado.setStyle("-fx-alignment: CENTER-LEFT;");
        tabelaVendedores.getColumns().add(colunaEstado);
    }

    private void adicionarColunaCidade() {
        TableColumn<Vendedor, String> colunaCidade = new TableColumn<>("Cidade");
        colunaCidade.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(cellData.getValue().getEndereco().getCidade()));
        colunaCidade.setStyle("-fx-alignment: CENTER-LEFT;");
        tabelaVendedores.getColumns().add(colunaCidade);
    }

    private void adicionarColunaCep() {
        TableColumn<Vendedor, String> colunaCep = new TableColumn<>("CEP");
        colunaCep.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(cellData.getValue().getEndereco().getCep()));
        colunaCep.setStyle("-fx-alignment: CENTER-LEFT;");
        tabelaVendedores.getColumns().add(colunaCep);
    }

    private void adicionarDataNascimento() {
        TableColumn<Vendedor, String> colunaDataNascimento = new TableColumn<>("Data de Nascimento");
        colunaDataNascimento.setCellValueFactory(cellData -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return new ReadOnlyStringWrapper(formatter.format(cellData.getValue().getDataNascimento()));
        });
        colunaDataNascimento.setStyle("-fx-alignment: CENTER-LEFT;");
        tabelaVendedores.getColumns().add(colunaDataNascimento);
    }

    private void adicionarStatusCivil() {
        TableColumn<Vendedor, String> colunaStatusCivil = new TableColumn<>("Status");
        colunaStatusCivil.setCellValueFactory(cellData ->
            new ReadOnlyStringWrapper(cellData.getValue().getStatusCivil().toString()));
        colunaStatusCivil.setStyle("-fx-alignment: CENTER-LEFT;");
        tabelaVendedores.getColumns().add(colunaStatusCivil);
    }

    private void adicionarStatusVendedor() {
        TableColumn<Vendedor, String> colunaStatusVendedor = new TableColumn<>("Status");
        colunaStatusVendedor.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(cellData.getValue().getStatusCivil().toString()));
        colunaStatusVendedor.setStyle("-fx-alignment: CENTER-LEFT;");
        tabelaVendedores.getColumns().add(colunaStatusVendedor);
    }

    private void adicionarColunasTabela() {
        adicionarColuna("Nome", "nome", "CENTER-LEFT", true);
        adicionarColuna("CPF", "cpf", "CENTER-LEFT", true);
        adicionarColuna("Telefone", "telefone", "CENTER-LEFT", false);
        adicionarColunaLogradouro();
        adicionarColunaNumero();
        adicionarColunaComplemento();
        adicionarColunaBairro();
        adicionarColunaPais();
        adicionarColunaEstado();
        adicionarColunaCidade();
        adicionarColunaCep();
        adicionarDataNascimento();
        adicionarColuna("E-mail", "email", "CENTER-LEFT", false);
        adicionarStatusCivil();
        adicionarColuna("Setor", "setor", "CENTER-LEFT", false);
        adicionarColuna("Codigo Vendedor", "codigoVendedor", "CENTER-LEFT", false);
        adicionarStatusVendedor();
        adicionarColunaAcoes();
    }

    private void adicionarColuna(String titulo, String propriedade, String alinhamento, boolean negrito) {
        TableColumn<Vendedor, String> coluna = new TableColumn<>(titulo);
        coluna.setCellValueFactory(new PropertyValueFactory<>(propriedade));
        coluna.setStyle("-fx-alignment: " + alinhamento + ";" + (negrito ? " -fx-font-weight: bold;" : ""));
        tabelaVendedores.getColumns().add(coluna);
    }

    private void adicionarColunaAcoes() {
        TableColumn<Vendedor, Void> colunaAcao = new TableColumn<>("Ações");
        colunaAcao.setCellFactory(param -> new TableCell<>() {
            private final Button botaoRemover = criarBotaoRemover();

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : botaoRemover);
            }

            private Button criarBotaoRemover() {
                Button botao = new Button();
                ImageView icone = new ImageView(new Image(getClass().getResourceAsStream("/icons/lixeira.png")));
                icone.setFitWidth(16);
                icone.setFitHeight(16);
                botao.setGraphic(icone);
                botao.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
                botao.setOnAction(event -> removerVendedor(getIndex()));
                return botao;
            }
        });
        colunaAcao.setStyle("-fx-alignment: CENTER;");
        tabelaVendedores.getColumns().add(colunaAcao);
    }

    private void adicionarColunaNascimentoFormatada() {
        TableColumn<Vendedor, LocalDate> colunaNascimento = new TableColumn<>("Nascimento");
        colunaNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        colunaNascimento.setStyle("-fx-alignment: CENTER;");
        colunaNascimento.setCellFactory(column -> new TableCell<>() {
            private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            protected void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setText(empty || date == null ? null : formatter.format(date));
            }
        });
        tabelaVendedores.getColumns().add(colunaNascimento);
    }

    private Button criarBotaoVendedoresCadastrados() {
        Button botaoRetornarCadastro = new Button("Cadastrar Novo");
        botaoRetornarCadastro.setStyle("-fx-background-color: #008000; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-weight: bold; -fx-background-radius: 6;");
        botaoRetornarCadastro.setOnAction(event -> actionMudarTelaParaCadastro());
        return botaoRetornarCadastro;
    }

    private void actionMudarTelaParaCadastro() {
        root.setCenter(new VendedoresScreen(root));
    }

    private void removerVendedor(int index) {
        Vendedor vendedor = tabelaVendedores.getItems().get(index);
        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacao.setTitle("Remover Vendedor");
        confirmacao.setHeaderText("Deseja realmente remover o Vendedor??");
        confirmacao.setContentText(vendedor.getNome());

        confirmacao.showAndWait().ifPresent(resposta -> {
            if (resposta == ButtonType.OK) {
                VendedorDataSource.getInstancia().removerVendedor(vendedor);
            }
        });
    }

    private void popularTabela() {
        tabelaVendedores.setItems(VendedorDataSource.getInstancia().getListaVendedores());
    }
}