package br.com.mentoriajava.exemplo;

import br.com.mentoriajava.database.PetDataSource;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Tela principal da aplicação, com formulário para cadastro de pets e listagem dos pets cadastrados.
 */
public class PetScreen extends VBox {

    // Campos de entrada do formulário
    private final TextField campoNome = new TextField();
    private final TextField campoPeso = new TextField();
    private final TextField campoRaca = new TextField();
    private final TextField campoDono = new TextField();
    private final ComboBox<String> comboTipoPet = new ComboBox<>();
    private final DatePicker campoNascimento = new DatePicker();
    private final TableView<Pet> tabelaPets = new TableView<>();

    public PetScreen() {
        configurarLayoutPrincipal();
        popularTabela();
    }

    /**
     * Define o layout principal da tela, incluindo o título e as seções de formulário e tabela.
     */
    private void configurarLayoutPrincipal() {
        setSpacing(20);
        setPadding(new Insets(20));
        setStyle("-fx-background-color: #ffffff;");

        Label titulo = new Label("Cadastro de Pets");
        titulo.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 20));
        titulo.setStyle("-fx-text-fill: #1f2937;");

        VBox secaoFormulario = construirFormulario();
        VBox secaoTabela = construirTabela();

        getChildren().addAll(titulo, secaoFormulario, secaoTabela);
    }

    /**
     * Constrói o formulário de entrada de dados com campos organizados em duas linhas.
     * Inclui botão para cadastrar pet.
     */
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

    /**
     * Cria e configura o layout em grid com os campos de entrada do formulário.
     */
    private GridPane configurarGridFormulario() {
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER_LEFT);

        campoNome.setPromptText("Nome do Pet");
        campoNome.setPrefWidth(250);
        campoPeso.setPromptText("Peso (kg)");
        campoRaca.setPromptText("Raça");
        campoDono.setPromptText("Nome do Dono");

        comboTipoPet.getItems().addAll("Cão", "Gato", "Ave", "Roedor", "Outro");
        comboTipoPet.setPromptText("Tipo de Pet");

        campoNascimento.setPromptText("Data de Nascimento");
        campoNascimento.setConverter(criarConversorData());

        grid.add(new Label("Nome:"), 0, 0);
        grid.add(campoNome, 1, 0);
        grid.add(new Label("Peso:"), 2, 0);
        grid.add(campoPeso, 3, 0);
        grid.add(new Label("Raça:"), 4, 0);
        grid.add(campoRaca, 5, 0);

        grid.add(new Label("Tipo de Pet:"), 0, 1);
        grid.add(comboTipoPet, 1, 1);
        grid.add(new Label("Data de Nascimento:"), 2, 1);
        grid.add(campoNascimento, 3, 1);
        grid.add(new Label("Dono:"), 4, 1);
        grid.add(campoDono, 5, 1);

        return grid;
    }

    /**
     * Cria o conversor para exibição e leitura de datas no formato brasileiro.
     */
    private StringConverter<LocalDate> criarConversorData() {
        return new StringConverter<>() {
            private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate date) {
                return (date != null) ? dtf.format(date) : "";
            }

            @Override
            public LocalDate fromString(String string) {
                return (string != null && !string.isEmpty()) ? LocalDate.parse(string, dtf) : null;
            }
        };
    }

    /**
     * Cria o botão de cadastro com validação e inserção de dados no DataSource.
     */
    private Button criarBotaoCadastrar() {
        Button botaoCadastrar = new Button("Cadastrar Pet");
        botaoCadastrar.setStyle("-fx-background-color: #3b82f6; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-weight: bold; -fx-background-radius: 6;");
        botaoCadastrar.setOnAction(event -> cadastrarPet());
        return botaoCadastrar;
    }

    /**
     * Realiza a validação dos campos e cadastra um novo pet no PetDataSource.
     */
    private void cadastrarPet() {
        String nome = campoNome.getText();
        String peso = campoPeso.getText();
        String raca = campoRaca.getText();
        String tipo = comboTipoPet.getValue();
        LocalDate nascimento = campoNascimento.getValue();
        String dono = campoDono.getText();

        if (nome.isEmpty() || peso.isEmpty() || raca.isEmpty() || tipo == null || nascimento == null || dono.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos obrigatórios");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos antes de cadastrar o pet.");
            alerta.showAndWait();
            return;
        }

        Pet novoPet = new Pet(nome, peso, raca, tipo, nascimento, dono);
        PetDataSource.getInstancia().adicionarPet(novoPet);

        limparCamposFormulario();
    }

    /**
     * Limpa os campos do formulário após o cadastro.
     */
    private void limparCamposFormulario() {
        campoNome.clear();
        campoPeso.clear();
        campoRaca.clear();
        campoDono.clear();
        comboTipoPet.setValue(null);
        campoNascimento.setValue(null);
    }

    /**
     * Constrói a tabela de visualização dos pet cadastrados com colunas e ações.
     */
    private VBox construirTabela() {
        VBox caixaTabela = new VBox(10);
        caixaTabela.setStyle("-fx-background-color: #f1f5f9; -fx-border-color: #e2e8f0; -fx-border-radius: 8; -fx-background-radius: 8;");
        caixaTabela.setPadding(new Insets(15));

        configurarTabela();
        adicionarColunasTabela();

        Label titulo = new Label("Pets Cadastrados");
        titulo.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 16));

        caixaTabela.getChildren().addAll(titulo, tabelaPets);
        return caixaTabela;
    }

    /**
     * Aponta a tabela para a lista de pets observável.
     */
    private void configurarTabela() {
        tabelaPets.setItems(PetDataSource.getInstancia().getListaDePets());
        tabelaPets.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabelaPets.setStyle("""
                    -fx-background-color: white;
                    -fx-border-color: #e5e7eb;
                    -fx-border-radius: 8;
                    -fx-table-cell-border-color: #f3f4f6;
                    -fx-padding: 8;
                """);
        tabelaPets.skinProperty().addListener((obs, oldSkin, newSkin) -> {
            tabelaPets.lookupAll(".column-header-background").forEach(header ->
                    header.setStyle("-fx-background-color: #e0f2fe;")
            );
        });
    }

    /**
     * Define e adiciona as colunas de dados e ações à tabela.
     */
    private void adicionarColunasTabela() {
        adicionarColuna("Nome", "nome", "CENTER-LEFT", true);
        adicionarColuna("Peso", "peso", "CENTER", false);
        adicionarColuna("Raça", "raca", "CENTER", false);
        adicionarColuna("Tipo", "tipo", "CENTER", false);
        adicionarColunaNascimentoFormatada();
        adicionarColuna("Dono", "dono", "CENTER", false);
        adicionarColunaAcoes();
    }

    /**
     * Adiciona uma coluna simples à tabela.
     */
    private void adicionarColuna(String titulo, String propriedade, String alinhamento, boolean negrito) {
        TableColumn<Pet, String> coluna = new TableColumn<>(titulo);
        coluna.setCellValueFactory(new PropertyValueFactory<>(propriedade));
        coluna.setStyle("-fx-alignment: " + alinhamento + ";" + (negrito ? " -fx-font-weight: bold;" : ""));
        tabelaPets.getColumns().add(coluna);
    }

    /**
     * Adiciona a coluna de nascimento formatada como dd/MM/yyyy.
     */
    private void adicionarColunaNascimentoFormatada() {
        TableColumn<Pet, LocalDate> colunaNascimento = new TableColumn<>("Nascimento");
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
        tabelaPets.getColumns().add(colunaNascimento);
    }

    /**
     * Cria a coluna de ações com ícone de lixeira.
     */
    private void adicionarColunaAcoes() {
        TableColumn<Pet, Void> colunaAcao = new TableColumn<>("Ações");
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
                botao.setOnAction(event -> removerPet(getIndex()));
                return botao;
            }
        });
        colunaAcao.setStyle("-fx-alignment: CENTER;");
        tabelaPets.getColumns().add(colunaAcao);
    }

    /**
     * Remove o pets da linha informada com confirmação do usuário.
     */
    private void removerPet(int index) {
        Pet pet = tabelaPets.getItems().get(index);
        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacao.setTitle("Remover Pet");
        confirmacao.setHeaderText("Deseja realmente remover o pet?");
        confirmacao.setContentText(pet.getNome());

        confirmacao.showAndWait().ifPresent(resposta -> {
            if (resposta == ButtonType.OK) {
                PetDataSource.getInstancia().removerPet(pet);
            }
        });
    }

    /**
     * Atualiza a tabela com os pets do DataSource.
     */
    private void popularTabela() {
        tabelaPets.setItems(PetDataSource.getInstancia().getListaDePets());
    }
}