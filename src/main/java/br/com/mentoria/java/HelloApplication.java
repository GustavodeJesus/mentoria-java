package br.com.mentoria.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        // Criação de um botão
        Button button = new Button("Clique aqui");
        button.setOnAction(event -> button.setText("Olá Mundo!"));

        // Layout raiz
        StackPane root = new StackPane(button);

        // Cena
        Scene scene = new Scene(root, 320, 240);

        // Configuração da janela
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}