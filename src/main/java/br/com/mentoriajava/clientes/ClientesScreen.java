package br.com.mentoriajava.clientes;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class ClientesScreen extends StackPane {

    public ClientesScreen() {
        setPadding(new Insets(20));
        Label title = new Label("Tela de Clientes");
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: #1f2937;");
        getChildren().add(title);
    }
}