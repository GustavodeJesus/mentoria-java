package br.com.mentoriajava.vendedores;

import br.com.mentoriajava.base.Endereco;
import br.com.mentoriajava.clientes.StatusCivilEnum;
import br.com.mentoriajava.database.VendedorDataSource;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private final TextField campoLogradouro = new TextField();
    private final TextField campoNumero = new TextField();
    private final TextField campoComplemento = new TextField();
    private final TextField campoBairro = new TextField();
    private final TextField campoPais = new TextField();
    private final TextField campoEstado = new TextField();
    private final TextField campoCidade = new TextField();
    private final TextField campoCep = new TextField();
    private final DatePicker campoDataNascimento = new DatePicker();
    private final TextField campoEmail = new TextField();
    private final ComboBox<StatusCivilEnum> comboStatusCivil = new ComboBox<>();
    private final TableView<Vendedor> tabelaVendedores = new TableView<>();
    private final TextField campoSetor = new TextField();
    private final TextField campoCodigoVendedor = new TextField();
    private final ComboBox<StatusVendedorEnum> comboStatusVendedor = new ComboBox<>();

    public VendedoresScreen() {
        configurarLayoutPrincipal();
        /*popularTabela();*/
    }

    private void configurarLayoutPrincipal() {
        setSpacing(20);
        setPadding(new Insets(20));
        setStyle("-fx-background-color: #ffffff;");

        Label titulo = new Label("Cadastrar Vendedor");
        titulo.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 20));
        titulo.setStyle("-fx-text-fill: #1f2937;");

        VBox secaoFormulario = construirFormulario();

        getChildren().addAll(titulo, secaoFormulario);
    }


    private VBox construirFormulario() {
        VBox containerFormulario = new VBox(10);
        containerFormulario.setPadding(new Insets(20));
        containerFormulario.setStyle("-fx-background-color: #f9fafb; -fx-border-color: #e5e7eb; -fx-border-radius: 8; -fx-background-radius: 8;");

        GridPane grid = configurarGridFormulario();
        Button botaoCadastrar = criarBotaoCadastrar();

        HBox boxBotao = new HBox(botaoCadastrar);
        boxBotao.setAlignment(Pos.CENTER_RIGHT);
        boxBotao.setPadding(new Insets(5));

        containerFormulario.getChildren().addAll(grid, boxBotao);
        return containerFormulario;
    }

    private GridPane configurarGridFormulario() {
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER_LEFT);

        campoNome.setPromptText("Nome do Vendedor");
        campoNome.setPrefWidth(250);
        campoCpf.setPromptText("CPF");
        campoTelefone.setPromptText("Telefone");
        campoLogradouro.setPromptText("Logradouro");
        campoNumero.setPromptText("Numero");
        campoComplemento.setPromptText("Complemento");
        campoBairro.setPromptText("Bairro");
        campoPais.setPromptText("País");
        campoEstado.setPromptText("Estado");
        campoCidade.setPromptText("Cidade");
        campoCep.setPromptText("Cep");
        campoEmail.setPromptText("E-mail");
        campoDataNascimento.setPromptText("Data de Nascimento");
        campoDataNascimento.setConverter(criarConversorData());
        comboStatusCivil.getItems().addAll(StatusCivilEnum.values());
        comboStatusCivil.setPromptText("Status Civil");
        campoSetor.setPromptText("Setor");
        campoCodigoVendedor.setPromptText("Código do Vendedor");
        comboStatusVendedor.getItems().addAll(StatusVendedorEnum.values());
        comboStatusVendedor.setPromptText("Status do Vendedor");

        grid.add(new Label("Nome:"), 0, 0);
        grid.add(campoNome, 1, 0);

        grid.add(new Label("CPF:"), 2, 0);
        grid.add(campoCpf, 3, 0);

        grid.add(new Label("Telefone:"), 4, 0);
        grid.add(campoTelefone, 5, 0);

        grid.add(new Label("E-mail:"), 0, 1);
        grid.add(campoEmail, 1, 1);

        grid.add(new Label("Data de Nascimento:"), 2, 1);
        grid.add(campoDataNascimento, 3, 1);

        grid.add(new Label("Setor:"), 4, 1);
        grid.add(campoSetor, 5, 1);

        grid.add(new Label("Cod. do Vendedor:"), 0, 2);
        grid.add(campoCodigoVendedor, 1, 2);

        grid.add(new Label("Status Civil:"), 2, 2);
        grid.add(comboStatusCivil, 3, 2);

        grid.add(new Label("Status"), 4, 2);
        grid.add(comboStatusVendedor, 5, 2);

        grid.add(new Label("Logradouro:"), 0, 3);
        grid.add(campoLogradouro, 1, 3);

        grid.add(new Label("Numero:"), 2, 3);
        grid.add(campoNumero, 3, 3);

        grid.add(new Label("Complemento:"), 4, 3);
        grid.add(campoComplemento, 5, 3);

        grid.add(new Label("Bairro:"), 0, 4);
        grid.add(campoBairro, 1, 4);

        grid.add(new Label("País:"), 2, 4);
        grid.add(campoPais, 3, 4);

        grid.add(new Label("Estado:"), 4, 4);
        grid.add(campoEstado, 5, 4);

        grid.add(new Label("Cidade:"), 0, 5);
        grid.add(campoCidade, 1, 5);

        grid.add(new Label("Cep:"), 2, 5);
        grid.add(campoCep, 3, 5);

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
        Button botaoCadastrar = new Button("Cadastrar Vendedor");
        botaoCadastrar.setStyle("-fx-background-color: #3b82f6; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-weight: bold; -fx-background-radius: 6;");
        botaoCadastrar.setOnAction(event -> cadastrarVendedor());
        return botaoCadastrar;
    }

    private void cadastrarVendedor() {
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
        String cep = campoCep.getText();
        String email = campoEmail.getText();
        StatusCivilEnum statusCivil = comboStatusCivil.getValue();
        StatusVendedorEnum status = comboStatusVendedor.getValue();
        LocalDate nascimento = campoDataNascimento.getValue();
        String setor = campoSetor.getText();
        String codigoVendedor = campoCodigoVendedor.getText();

        if (nome.isEmpty() ||
                cpf.isEmpty() ||
                telefone.isEmpty() ||
                nascimento == null ||
                email.isEmpty() ||
                status == null ||
                statusCivil == null ||
                logradouro.isEmpty() ||
                numero == null ||
                complemento.isEmpty() ||
                bairro.isEmpty() ||
                pais.isEmpty() ||
                estado.isEmpty() ||
                cidade.isEmpty() ||
                cep.isEmpty() ||
                setor.isEmpty() ||
                codigoVendedor.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos obrigatórios");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos antes de cadastrar o Vendedor.");
            alerta.showAndWait();
            return;
        }

        Endereco novoEndereco = new Endereco(
                logradouro,
                numero,
                complemento,
                bairro,
                pais,
                estado,
                cidade,
                cep);

        Vendedor novoVendedor = new Vendedor(
                cpf,
                nome,
                novoEndereco,
                nascimento,
                telefone,
                email,
                statusCivil,
                setor,
                codigoVendedor);

        VendedorDataSource.getInstancia().adicionarVendedor(novoVendedor);
    }
}