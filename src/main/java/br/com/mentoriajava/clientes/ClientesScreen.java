package br.com.mentoriajava.clientes;
import br.com.mentoriajava.database.ClienteDataSource;
import br.com.mentoriajava.clientes.StatusCivilEnum;
import br.com.mentoriajava.base.Endereco;
import javafx.beans.property.ReadOnlyStringWrapper;
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
    private final ComboBox<StatusCivilEnum> comboStatusCivil = new ComboBox<>();
    private final TableView<Cliente> tabelaClientes = new TableView<>();

    public ClientesScreen() {
        configurarLayoutPrincipal();
        popularTabela();
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
        comboStatusCivil.getItems().addAll(StatusCivilEnum.values());
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
        StatusCivilEnum status = comboStatusCivil.getValue();
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
                status == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos obrigatórios");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos antes de cadastrar o cliente.");
            alerta.showAndWait();
        }

        else {
            Endereco novoEndereco = new Endereco(logradouro, numero, complemento, bairro, pais, estado, cidade, cep);
            Cliente novoCliente = new Cliente(cpf, nome, novoEndereco, nascimento, telefone, email, status);
            ClienteDataSource.getInstancia().adiconarCliente(novoCliente);
            limparCamposFormulario();

            Alert popUp = new Alert(Alert.AlertType.INFORMATION);
            popUp.setTitle("Cliente cadastrado!");
            popUp.setHeaderText(null);
            popUp.setContentText("Cliente cadastrado com sucesso!");
            popUp.showAndWait();
        }
    }

    private void limparCamposFormulario(){
        campoNome.clear();
        campoCpf.clear ();
        campoTelefone.clear();
        campoLogradouro.clear();
        campoNome.clear();
        campoComplemento.clear();
        campoBairro.clear();
        campoPais.clear();
        campoEstado.clear();
        campoCidade.clear();
        campoCEP.clear();
        campoEmail.clear();
        campoDataNascimento.setValue(null);
        comboStatusCivil.setValue(null);
    }

    private VBox construirTabela() {
        VBox caixaTabela = new VBox(10);
        caixaTabela.setStyle("-fx-background-color: #f1f5f9; -fx-border-color: #e2e8f0; -fx-border-radius: 8; -fx-background-radius: 8;");
        caixaTabela.setPadding(new Insets(15));

        configurarTabela();
        adicionarColunasTabela();

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

    private void adicionarColunasTabela() {
        adicionarColuna("Nome", "nome", "CENTER-LEFT", true);
        adicionarColuna("CPF", "cpf", "CENTER-LEFT", true);
        adicionarColuna("Telefone", "telefone", "CENTER-LEFT", true);
        adicionarColunaLogradouro();
        adicionarColunaNumero();
        adicionarColunaComplemento();
        adicionarColunaBairro();
        adicionarColunaPais();
        adicionarColunaEstado();
        adicionarColunaCidade();
        adicionarColunaCep();
        adicionarColuna("E-mail", "email", "CENTER-LEFT", true);
        adicionarColunaStatusCivil();
        adicionarColunaNascimentoFormatada();
        adicionarColunaAcoes();

    }

    private void adicionarColuna(String titulo, String propriedade, String alinhamento, boolean negrito){
        TableColumn<Cliente, String> coluna = new TableColumn<>(titulo);
        coluna.setCellValueFactory(new PropertyValueFactory<>(propriedade));
        coluna.setStyle("-fx-alignment: " + alinhamento + ";" + (negrito ? " -fx-font-weight: bold;" : ""));
        tabelaClientes.getColumns().add(coluna);
    }

    private void adicionarColunaLogradouro(){
        TableColumn<Cliente, String> colunaLogradouro = new TableColumn<>("Logradouto");
        colunaLogradouro.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getEndereco().getLogradouro()));
        colunaLogradouro.setStyle("-fx-alignment: CENTER-LEFT");

        tabelaClientes.getColumns().add(colunaLogradouro);

    }

    private void adicionarColunaNumero(){
        TableColumn<Cliente, String> colunaNumero = new TableColumn<>("Numero");
        colunaNumero.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getEndereco().getNumero()));
        colunaNumero.setStyle("-fx-alignment: CENTER-LEFT");

        tabelaClientes.getColumns().add(colunaNumero);
    }

    private void adicionarColunaComplemento() {
        TableColumn<Cliente, String> colunaComplemento = new TableColumn<>("Complemento");
        colunaComplemento.setCellValueFactory(cellData -> new ReadOnlyStringWrapper((cellData.getValue().getEndereco().getComplemento())));
        colunaComplemento.setStyle("-fx-alignment: CENTER-LEFT");

        tabelaClientes.getColumns().add(colunaComplemento);
    }

    private void adicionarColunaBairro() {
        TableColumn<Cliente, String> colunaBairro = new TableColumn<>("Bairro");
        colunaBairro.setCellValueFactory(cellData -> new ReadOnlyStringWrapper((cellData.getValue().getEndereco().getBairro())));
        colunaBairro.setStyle("-fx-alignment: CENTER-LEFT");

        tabelaClientes.getColumns().add(colunaBairro);
    }

    private void adicionarColunaPais() {
        TableColumn<Cliente, String> colunaPais = new TableColumn<>("País");
        colunaPais.setCellValueFactory(cellData -> new ReadOnlyStringWrapper((cellData.getValue().getEndereco().getPais())));
        colunaPais.setStyle("-fx-alignment: CENTER-LEFT");

        tabelaClientes.getColumns().add(colunaPais);
    }

    private void adicionarColunaEstado() {
        TableColumn<Cliente, String> colunaEstado = new TableColumn<>("Estado");
        colunaEstado.setCellValueFactory(cellData -> new ReadOnlyStringWrapper((cellData.getValue().getEndereco().getEstado())));
        colunaEstado.setStyle("-fx-alignment: CENTER-LEFT");

        tabelaClientes.getColumns().add(colunaEstado);
    }

    private void adicionarColunaCidade() {
        TableColumn<Cliente, String> colunaCidade = new TableColumn<>("Cidade");
        colunaCidade.setCellValueFactory(cellData -> new ReadOnlyStringWrapper((cellData.getValue().getEndereco().getCidade())));
        colunaCidade.setStyle("-fx-alignment: CENTER-LEFT");

        tabelaClientes.getColumns().add(colunaCidade);
    }

    private void adicionarColunaCep() {
        TableColumn<Cliente, String> colunaCep = new TableColumn<>("CEP");
        colunaCep.setCellValueFactory(cellData -> new ReadOnlyStringWrapper((cellData.getValue().getEndereco().getCep())));
        colunaCep.setStyle("-fx-alignment: CENTER-LEFT");

        tabelaClientes.getColumns().add(colunaCep);
    }

    private void adicionarColunaNascimentoFormatada(){
        TableColumn<Cliente, LocalDate> colunaNascimento = new TableColumn<>("Data Nascimento");
        colunaNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        colunaNascimento.setStyle("-fx-alignment: CENTER;");
        colunaNascimento.setCellFactory(column -> new TableCell<>(){
            private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            protected void updateItem(LocalDate date, boolean empty){
                super.updateItem(date, empty);
                setText(empty || date == null ? null : formatter.format(date));
            }
        });
        tabelaClientes.getColumns().add(colunaNascimento);
    }

    private void adicionarColunaAcoes(){
        TableColumn<Cliente, Void> colunaAcao = new TableColumn<>("Ações");
        colunaAcao.setCellFactory(param -> new TableCell<>() {
            private final Button botaoRemover = criarBotaoRemover();

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : botaoRemover);
            }

            private Button criarBotaoRemover(){
                Button botao = new Button();
                ImageView icone = new ImageView(new Image(getClass().getResourceAsStream("/icons/lixeira.png")));
                icone.setFitWidth(16);
                icone.setFitHeight(16);
                botao.setGraphic(icone);
                botao.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
                botao.setOnAction(event -> removerCliente(getIndex()));

                return botao;
            }
        });

        colunaAcao.setStyle("-fx-alignment: CENTER;");
        tabelaClientes.getColumns().add(colunaAcao);
    }

    private void adicionarColunaStatusCivil() {
        TableColumn<Cliente, String> colunaStatusCivil = new TableColumn<>("Status");
        colunaStatusCivil.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getStatusCivil().toString()));
        colunaStatusCivil.setStyle("-fx-alignment: CENTER-LEFT;");
        tabelaClientes.getColumns().add(colunaStatusCivil);
    }

    private void removerCliente(int index) {
        Cliente cliente = tabelaClientes.getItems().get(index);
        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacao.setTitle("Remover Cliente");
        confirmacao.setHeaderText("Deseja realmente remover o cliente?");
        confirmacao.setContentText(cliente.getNome());

        confirmacao.showAndWait().ifPresent(resposta -> {
            if (resposta == ButtonType.OK) {
                ClienteDataSource.getInstancia().removerCliente(cliente);
            }
        });
    }

    private void popularTabela() {
        tabelaClientes.setItems(ClienteDataSource.getInstancia().getListaDeClientes());
    }

}