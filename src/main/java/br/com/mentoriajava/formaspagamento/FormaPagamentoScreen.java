package br.com.mentoriajava.formaspagamento;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class FormaPagamentoScreen extends StackPane {
    public FormaPagamentoScreen() {
        setPadding(new Insets(20));
        Label title = new Label("Tela de Forma de Pagamento");
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: #1f2937;");
        getChildren().add(title);
    }
}