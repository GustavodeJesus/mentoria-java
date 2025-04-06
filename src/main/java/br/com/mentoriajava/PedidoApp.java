package br.com.mentoriajava;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class PedidoApp extends Application {

    private Cliente cliente;

    @Override
    public void start(Stage stage) {

        TextField cpfTextField = new TextField();
        cpfTextField.setPromptText("Digite seu cpf aqui!");

        TextField nomeTextField = new TextField();
        nomeTextField.setPromptText("Digite seu nome aqui!");

        TextField logradouroTextField = new TextField();
        logradouroTextField.setPromptText("Digite seu logradouro aqui!");

        TextField numeroTextField = new TextField();
        numeroTextField.setPromptText("Digite seu numero aqui!");

        TextField complementoTextField = new TextField();
        complementoTextField.setPromptText("Digite seu complemento aqui!");

        TextField bairroTextField = new TextField();
        bairroTextField.setPromptText("Digite seu bairro aqui!");

        TextField paisTextField = new TextField();
        paisTextField.setPromptText("Digite seu país aqui!");

        TextField estadoTextField = new TextField();
        estadoTextField.setPromptText("Digite seu estado aqui!");

        TextField cidadeTextField = new TextField();
        cidadeTextField.setPromptText("Digite sea cidade aqui!");

        TextField cepTextField = new TextField();
        cepTextField.setPromptText("Digite seu CEP aqui!");

        DatePicker dataNascimentoDatePicker = new DatePicker();
        dataNascimentoDatePicker.setPromptText("Data de nascimento");

        TextField telefoneTextField = new TextField();
        telefoneTextField.setPromptText("Digite seu telefone aqui!");

        TextField emailTextField = new TextField();
        emailTextField.setPromptText("Digite seu email aqui!");

//        TextField statusCivilTextField = new TextField();
//        nomeTextField.setPromptText("Digite seu nome aqui!");

        Label dadosCadastrados = new Label();

        // Criação de um botão
        Button button = new Button("Enviar");
        button.setOnAction(event -> {
//           Cliente cliente = new Cliente();
//           cliente.setCpf(cpfTextField.getText());
//           cliente.setNome(nomeTextField.getText());
//           Endereco endereco = new Endereco();
//           endereco.setLogradouro(logradouroTextField.getText());
//           endereco.setNumero(numeroTextField.getText());
//           endereco.setComplemento(complementoTextField.getText());
//           endereco.setBairro(bairroTextField.getText());
//           endereco.setPais(paisTextField.getText());
//           endereco.setEstado(estadoTextField.getText());
//           endereco.setCidade(cidadeTextField.getText());
//           endereco.setCep(cepTextField.getText());
//           cliente.setEndereco(endereco);
//           cliente.setDataNascimento(dataNascimentoDatePicker.getValue());
//           cliente.setTelefone(telefoneTextField.getText());
//           cliente.setEmail(emailTextField.getText());
//           cliente.setStatusCivil(StatusCivilEnum.SOLTEIRO);
//           cliente.setNumeroPedidos(0);

            Endereco endereco1 = new Endereco(
                    logradouroTextField.getText(),
                    numeroTextField.getText(),
                    complementoTextField.getText(),
                    bairroTextField.getText(),
                    paisTextField.getText(),
                    estadoTextField.getText(),
                    cidadeTextField.getText(),
                    cepTextField.getText()
            );
            Cliente cliente1 = new Cliente(
                    cpfTextField.getText(),
                    nomeTextField.getText(),
                    endereco1,
                    dataNascimentoDatePicker.getValue(),
                    telefoneTextField.getText(),
                    emailTextField.getText(),
                    StatusCivilEnum.SOLTEIRO,
                    0
            );

            dadosCadastrados.setText(
                    cliente1.getCpf() + "\n" +
                            cliente1.getNome() + "\n" +
                            cliente1.getEndereco().getLogradouro() + "\n" +
                            cliente1.getEndereco().getNumero() + "\n" +
                            cliente1.getEndereco().getComplemento() + "\n" +
                            cliente1.getEndereco().getBairro() + "\n" +
                            cliente1.getEndereco().getPais() + "\n" +
                            cliente1.getEndereco().getEstado() + "\n" +
                            cliente1.getEndereco().getCidade() + "\n" +
                            cliente1.getEndereco().getCep()+ "\n" +
                            cliente1.getDataNascimento().toString()+ "\n" +
                            cliente1.getTelefone()+ "\n" +
                            cliente1.getEmail()+ "\n" +
                            cliente1.getStatusCivil().name()+ "\n" +
                            cliente1.getNumeroPedidos()
            );
            button.setText("Enviado");
        });

        VBox formularioVBox = new VBox();

        formularioVBox.getChildren().addAll(
                cpfTextField,
                nomeTextField,
                logradouroTextField,
                numeroTextField,
                complementoTextField,
                bairroTextField,
                paisTextField,
                estadoTextField,
                cidadeTextField,
                cepTextField,
                dataNascimentoDatePicker,
                telefoneTextField,
                emailTextField,
                dadosCadastrados,
                button
        );

        // Layout raiz
        StackPane root = new StackPane(formularioVBox);

        Rectangle2D screensBounds = Screen.getPrimary().getVisualBounds();
        double width = screensBounds.getWidth() * 0.7;
        double height = screensBounds.getHeight() * 0.8;

        // Cena
        Scene scene = new Scene(
                root,
                width,
                height
        );

        // Configuração da janela
        stage.setTitle("Invoicex.app");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}