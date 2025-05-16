package br.com.mentoriajava.vendedores;

import br.com.mentoriajava.database.VendedorDataSource;
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

public class VendedoresScreen extends VBox {

    private final TextField campoNome = new TextField();
    private final TextField campoCpf = new TextField();
    private final TextField campoTelefone = new TextField();
    private final TextField campoEndereco = new TextField();
    private final DatePicker campoDataNascimento = new DatePicker();
    private final TextField campoEmail = new TextField();
    private final ComboBox<String> comboStatusCivil = new ComboBox<>();
    private final TableView<Vendedor> tabelaVendedores = new TableView<>();
    private final TextField campoSetor = new TextField();
    private final TextField campoCodigoVendedor = new TextField();

    public VendedoresScreen() {
        configurarLayoutPrincipal();
        /*popularTabela();*/
    }

    private void configurarLayoutPrincipal() {
        setSpacing(20);
        setPadding(new Insets(20));
        setStyle("-fx-background-color: #ffffff;");

        Label titulo = new Label("Cadastro de Vendedores");
        titulo.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 20));
        titulo.setStyle("-fx-text-fill: #1f2937;");

        VBox secaoFormulario = construirFormulario();
        VBox secaoTabela = construirTabela();

        getChildren().addAll(titulo, secaoFormulario, secaoTabela);
    }


    private VBox construirFormulario() {
        VBox containerFormulario = new VBox(10);
        containerFormulario.setPadding(new Insets(20));
        containerFormulario.setStyle("-fx-background-color: #f9fafb; -fx-border-color: #e5e7eb; -fx-border-radius: 8; -fx-background-radius: 8;");

        GridPane grid = configurarGridFormulario();

        return containerFormulario;
    }

    private GridPane configurarGridFormulario() {
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER_LEFT);

        return grid;
    }

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

    private void cadastrarCliente() {
        String nome = campoNome.getText();
        String cpf = campoCpf.getText();
        String telefone = campoTelefone.getText();
        String endereco = campoEndereco.getText();
        String email = campoEmail.getText();
        String status = comboStatusCivil.getValue();
        LocalDate nascimento = campoDataNascimento.getValue();

        if (nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || endereco == null || nascimento == null || email.isEmpty() || status.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos obrigatórios");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos antes de cadastrar o Vendedor.");
            alerta.showAndWait();
            return;
        }

    }

    private VBox construirTabela() {
        VBox caixaTabela = new VBox(10);
        caixaTabela.setStyle("-fx-background-color: #f1f5f9; -fx-border-color: #e2e8f0; -fx-border-radius: 8; -fx-background-radius: 8;");
        caixaTabela.setPadding(new Insets(15));

        configurarTabela();

        Label titulo = new Label("Vendedores Cadastrados");
        titulo.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 16));

        caixaTabela.getChildren().addAll(titulo, tabelaVendedores);
        return caixaTabela;
    }

    private void configurarTabela() {
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
}