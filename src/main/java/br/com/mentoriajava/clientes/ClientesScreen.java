package br.com.mentoriajava.clientes;
import br.com.mentoriajava.database.ClienteDataSource;
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
import javax.swing.tree.DefaultTreeCellEditor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClientesScreen extends VBox {

    private final TextField campoNome = new TextField();
    private final TextField campoCpf = new TextField();
    private final TextField campoTelefone = new TextField();
    private final TextField campoLogradouro = new TextField();
    private final TextField campoNumero = new TextField();
    private final TextField campoComplemento = new TextField();
    private final TextField campoBairro = new TextField();
    private final TextField campoPais = new TextField();
    private final TextField campoEstado = new TextField();
    private final TextField campoCidade = new TextField();
    private final TextField campoCEP = new TextField();
    private final DatePicker campoDataNascimento = new DatePicker();
    private final TextField campoEmail = new TextField();
    private final ComboBox<String> comboStatusCivil = new ComboBox<>();
    private final TableView<Cliente> tabelaClientes = new TableView<>();

    public ClientesScreen() {
        configurarLayoutPrincipal();
    }

    private void configurarLayoutPrincipal() {
        setSpacing(20);
        setPadding(new Insets(20));
        setStyle("-fx-background-color: #ffffff;");

        Label titulo = new Label("Cadastro de Clientes");
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

        campoNome.setPromptText("Nome do Cliente");
        campoNome.setPrefWidth(200);
        campoCpf.setPromptText("CPF");
        campoTelefone.setPromptText("Telefone");
        campoLogradouro.setPromptText("Logradouro");
        campoNumero.setPromptText("Numero");
        campoComplemento.setPromptText("Complemento");
        campoBairro.setPromptText("Bairro");
        campoPais.setPromptText("Pais");
        campoEstado.setPromptText("Estado");
        campoCidade.setPromptText("Cidade");
        campoCEP.setPromptText("CEP");
        campoEmail.setPromptText("E-mail");
        campoDataNascimento.setPromptText("Data de Nascimento");
        campoDataNascimento.setConverter(criarConversorData());
        comboStatusCivil.getItems().addAll("Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viúvo(a)");
        comboStatusCivil.setPromptText("Status Civil");

        grid.add(new Label("Nome:*"), 0, 0);
        grid.add(campoNome, 1, 0);
        grid.add(new Label("CPF:*"), 2, 0);
        grid.add(campoCpf, 3, 0);
        grid.add(new Label("Telefone:*"), 4, 0);
        grid.add(campoTelefone, 5, 0);

        grid.add(new Label("Logradouro:*"), 0, 1);
        grid.add(campoLogradouro, 1, 1);
        grid.add(new Label("Numero:*"), 2, 1);
        grid.add(campoNumero, 3, 1);
        grid.add(new Label("Complemento:*"), 4, 1);
        grid.add(campoComplemento, 5, 1);

        grid.add(new Label("Bairro:*"), 0, 2);
        grid.add(campoBairro, 1, 2);
        grid.add(new Label("Pais:*"), 2, 2);
        grid.add(campoPais, 3, 2);
        grid.add(new Label("Estado:*"), 4, 2);
        grid.add(campoEstado, 5, 2);

        grid.add(new Label("Cidade:*"), 0, 3);
        grid.add(campoCidade, 1, 3);
        grid.add(new Label("CEP:*"), 2, 3);
        grid.add(campoCEP, 3, 3);
        grid.add(new Label("E-mail:*"), 4, 3);
        grid.add(campoEmail, 5, 3);

        grid.add(new Label("Data de Nascimento:*"), 0, 5);
        grid.add(campoDataNascimento, 1, 5);
        grid.add(new Label("Status Civil:*"), 2, 5);
        grid.add(comboStatusCivil, 3, 5);

        grid.add(new Label("* indica campos obrigatórios"), 0, 7);

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

    private Button criarBotaoCadastrar() {
        Button botaoCadastrar = new Button("Cadastrar Cliente");
        botaoCadastrar.setStyle("-fx-background-color: #3b82f6; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-weight: bold; -fx-background-radius: 6;");
        botaoCadastrar.setOnAction(event -> cadastrarCliente());
        return botaoCadastrar;
    }

    private void cadastrarCliente() {
        String nome = campoNome.getText();
        String cpf = campoCpf.getText();
        String telefone = campoTelefone.getText();
        String logradouro = campoLogradouro.getText();
        String numero = campoNumero.getText();
        String complemento = campoComplemento.getText();
        String bairro = campoBairro.getText();
        String pais = campoPais.getText();
        String estado = campoEstado.getText();
        String cidade = campoCidade.getText();
        String cep = campoCEP.getText();
        String email = campoEmail.getText();
        String status = comboStatusCivil.getValue();
        LocalDate nascimento = campoDataNascimento.getValue();

        if (nome.isEmpty() ||
                cpf.isEmpty() ||
                telefone.isEmpty() ||
                logradouro == null ||
                numero == null ||
                complemento == null ||
                bairro == null ||
                pais == null ||
                estado == null ||
                cidade == null ||
                cep == null ||
                nascimento == null ||
                email.isEmpty() ||
                status.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos obrigatórios");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos antes de cadastrar o cliente.");
            alerta.showAndWait();
            return;
        }

    }

    private VBox construirTabela() {
        VBox caixaTabela = new VBox(10);
        caixaTabela.setStyle("-fx-background-color: #f1f5f9; -fx-border-color: #e2e8f0; -fx-border-radius: 8; -fx-background-radius: 8;");
        caixaTabela.setPadding(new Insets(15));

        configurarTabela();

        Label titulo = new Label("Clientes Cadastrados");
        titulo.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 16));

        caixaTabela.getChildren().addAll(titulo, tabelaClientes);
        return caixaTabela;
    }

    private void configurarTabela() {
        tabelaClientes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabelaClientes.setStyle("""
                    -fx-background-color: white;
                    -fx-border-color: #e5e7eb;
                    -fx-border-radius: 8;
                    -fx-table-cell-border-color: #f3f4f6;
                    -fx-padding: 8;
                """);
        tabelaClientes.skinProperty().addListener((obs, oldSkin, newSkin) -> {
            tabelaClientes.lookupAll(".column-header-background").forEach(header ->
                    header.setStyle("-fx-background-color: #e0f2fe;")
            );
        });
    }
}