package br.com.mentoriajava.produtos;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class ProdutosScreen extends StackPane {
    public ProdutosScreen() {
        setPadding(new Insets(20));
        Label title = new Label("Tela de Produtos");
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: #1f2937;");
        getChildren().add(title);
    }
}