package br.com.mentoriajava.cupons;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class CuponsScreen extends StackPane {
    public CuponsScreen() {
        setPadding(new Insets(20));
        Label title = new Label("Tela de Cupons");
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: #1f2937;");
        getChildren().add(title);
    }
}