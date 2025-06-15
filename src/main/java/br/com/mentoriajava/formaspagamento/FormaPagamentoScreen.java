package br.com.mentoriajava.formaspagamento;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class FormaPagamentoScreen extends VBox {

    public FormaPagamentoScreen() {
        configurarLayoutPrincipal();
    }

    private void configurarLayoutPrincipal() {
        setSpacing(20);
        setPadding(new Insets(20));
        setStyle("-fx-background-color:#ffffff;");

        Label titulo = new Label("Cadastro de Forma de Pagamento");
        titulo.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 20));
        titulo.setStyle("-fx-text-fill: #1f2937;");

        getChildren().addAll(titulo);

    }

}
