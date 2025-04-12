package br.com.mentoriajava.exemplo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExemploScreen extends VBox {

    private final TextField campoNome = new TextField();
    private final TextField campoPeso = new TextField();
    private final TextField campoRaca = new TextField();
    private final ComboBox<String> comboTipoPet = new ComboBox<>();
    private final DatePicker campoNascimento = new DatePicker();
    private final TableView<Pet> tabelaPets = new TableView<>();

    public ExemploScreen() {
        setSpacing(20);
        setPadding(new Insets(20));
        setStyle("-fx-background-color: #ffffff;");

        Label titulo = new Label("Cadastro de Pets");
        titulo.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 20));
        titulo.setStyle("-fx-text-fill: #1f2937;");

        VBox secaoFormulario = construirFormulario();
        VBox secaoTabela = construirTabela();

        getChildren().addAll(titulo, secaoFormulario, secaoTabela);

        popularTabela();
    }

    /**
     * Constrói o formulário de cadastro do pet com os campos distribuídos em duas linhas
     * e botão posicionado no canto inferior direito.
     *
     * @return VBox contendo o formulário estilizado.
     */
    private VBox construirFormulario() {
        VBox caixaFormulario = new VBox(10);
        caixaFormulario.setPadding(new Insets(20));
        caixaFormulario.setStyle("-fx-background-color: #f9fafb; -fx-border-color: #e5e7eb; -fx-border-radius: 8; -fx-background-radius: 8;");

        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER_LEFT);

        // Ajuste de largura preferencial para o campo nome
        campoNome.setPromptText("Nome do Pet");
        campoNome.setPrefWidth(250);
        campoPeso.setPromptText("Peso (kg)");
        campoRaca.setPromptText("Raça");

        comboTipoPet.getItems().addAll("Cão", "Gato", "Ave", "Roedor", "Outro");
        comboTipoPet.setPromptText("Tipo de Pet");

        campoNascimento.setPromptText("Data de Nascimento");
        campoNascimento.setConverter(new StringConverter<>() {
            private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate date) {
                return (date != null) ? dtf.format(date) : "";
            }

            @Override
            public LocalDate fromString(String string) {
                return (string != null && !string.isEmpty()) ? LocalDate.parse(string, dtf) : null;
            }
        });

        // Primeira linha do formulário
        grid.add(new Label("Nome:"), 0, 0);
        grid.add(campoNome, 1, 0);
        grid.add(new Label("Peso:"), 2, 0);
        grid.add(campoPeso, 3, 0);
        grid.add(new Label("Raça:"), 4, 0);
        grid.add(campoRaca, 5, 0);

        // Segunda linha do formulário
        grid.add(new Label("Tipo de Pet:"), 0, 1);
        grid.add(comboTipoPet, 1, 1);
        grid.add(new Label("Data de Nascimento:"), 2, 1);
        grid.add(campoNascimento, 3, 1);

        // Botão alinhado à direita
        Button botaoCadastrar = new Button("Cadastrar Pet");
        botaoCadastrar.setStyle("-fx-background-color: #3b82f6; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-weight: bold; -fx-background-radius: 6;");
        HBox boxBotao = new HBox(botaoCadastrar);
        boxBotao.setAlignment(Pos.CENTER_RIGHT);

        caixaFormulario.getChildren().addAll(grid, boxBotao);
        return caixaFormulario;
    }

    /**
     * Cria a tabela com colunas que representam os dados dos pets cadastrados.
     *
     * @return VBox com título e tabela personalizada.
     */
    private VBox construirTabela() {
        VBox caixaTabela = new VBox(10);
        caixaTabela.setStyle("-fx-background-color: #f1f5f9; -fx-border-color: #e2e8f0; -fx-border-radius: 8; -fx-background-radius: 8;");
        caixaTabela.setPadding(new Insets(15));

        tabelaPets.setStyle("""
                    -fx-background-color: white;
                    -fx-border-color: #e5e7eb;
                    -fx-border-radius: 8;
                    -fx-table-cell-border-color: #f3f4f6;
                    -fx-padding: 8;
                """);

        tabelaPets.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Pet, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(cell -> cell.getValue().nomeProperty());
        colunaNome.setStyle("-fx-alignment: CENTER-LEFT; -fx-font-weight: bold;");

        TableColumn<Pet, String> colunaPeso = new TableColumn<>("Peso");
        colunaPeso.setCellValueFactory(cell -> cell.getValue().pesoProperty());
        colunaPeso.setStyle("-fx-alignment: CENTER;");

        TableColumn<Pet, String> colunaRaca = new TableColumn<>("Raça");
        colunaRaca.setCellValueFactory(cell -> cell.getValue().racaProperty());
        colunaRaca.setStyle("-fx-alignment: CENTER;");

        TableColumn<Pet, String> colunaTipo = new TableColumn<>("Tipo");
        colunaTipo.setCellValueFactory(cell -> cell.getValue().tipoProperty());
        colunaTipo.setStyle("-fx-alignment: CENTER;");

        TableColumn<Pet, String> colunaNascimento = new TableColumn<>("Nascimento");
        colunaNascimento.setCellValueFactory(cell -> cell.getValue().dataNascimentoProperty().asString());
        colunaNascimento.setStyle("-fx-alignment: CENTER;");

        TableColumn<Pet, String> colunaDono = new TableColumn<>("Dono");
        colunaDono.setCellValueFactory(cell -> cell.getValue().donoProperty());
        colunaDono.setStyle("-fx-alignment: CENTER;");


        tabelaPets.getColumns().addAll(colunaNome, colunaPeso, colunaRaca, colunaTipo, colunaNascimento, colunaDono);


        Label tituloCaixaTabela = new Label("Pets Cadastrados");
        tituloCaixaTabela.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 16));

        caixaTabela.getChildren().addAll(tituloCaixaTabela, tabelaPets);
        return caixaTabela;
    }

    private void popularTabela() {
        tabelaPets.getItems().addAll(
                new Pet("Thor", "10", "Labrador", "Cão", LocalDate.of(2020, 5, 12), "João"),
                new Pet("Mia", "4", "Siamesa", "Gato", LocalDate.of(2021, 2, 28), "Maria"),
                new Pet("Rex", "12", "Pastor Alemão", "Cão", LocalDate.of(2019, 9, 15), "Carlos"),
                new Pet("Luna", "3.5", "Persa", "Gato", LocalDate.of(2022, 1, 5), "Juliana"),
                new Pet("Bidu", "2", "Poodle", "Cão", LocalDate.of(2023, 3, 18), "Fernanda"),
                new Pet("Zezé", "0.8", "Calopsita", "Ave", LocalDate.of(2021, 11, 7), "Roberto"),
                new Pet("Belinha", "9", "Golden Retriever", "Cão", LocalDate.of(2018, 6, 22), "Tatiane"),
                new Pet("Tom", "4.2", "Maine Coon", "Gato", LocalDate.of(2020, 8, 30), "Lucas"),
                new Pet("Pipoca", "1.1", "Hamster", "Roedor", LocalDate.of(2022, 10, 2), "Aline"),
                new Pet("Nina", "7", "Beagle", "Cão", LocalDate.of(2017, 4, 14), "Bruno")
        );
    }
}