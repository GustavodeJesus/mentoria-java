package br.com.mentoriajava.pedido;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class PedidosScreen extends StackPane {
    public PedidosScreen() {
        setPadding(new Insets(20));
        Label title = new Label("Tela de Pedidos");
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: #1f2937;");
        getChildren().add(title);
    }
}