package br.com.mentoriajava.vendedores;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class VendedoresScreen extends StackPane {
    public VendedoresScreen() {
        setPadding(new Insets(20));
        Label title = new Label("Tela de Vendedores");
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: #1f2937;");
        getChildren().add(title);
    }
}