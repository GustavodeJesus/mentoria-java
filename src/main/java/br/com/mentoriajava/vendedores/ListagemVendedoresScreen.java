package br.com.mentoriajava.vendedores;

import br.com.mentoriajava.database.VendedorDataSource;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ListagemVendedoresScreen extends VBox {

    private final TableView<Vendedor> tabelaVendedores = new TableView<>();

    private void configurarLayoutPrincipal() {
        setSpacing(20);
        setPadding(new Insets(20));
        setStyle("-fx-background-color: #ffffff;");

        Label titulo = new Label("Cadastro de Pets");
        titulo.setFont(Font.font("System", javafx.scene.text.FontWeight.BOLD, 20));
        titulo.setStyle("-fx-text-fill: #1f2937;");

       //TODO: Integrar na proxima task
//        VBox secaoTabela = construirTabela();
//        getChildren().addAll(titulo, secaoTabela);
    }
}