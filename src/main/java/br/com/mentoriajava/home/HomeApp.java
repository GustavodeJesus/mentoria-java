package br.com.mentoriajava.home;

import br.com.mentoriajava.clientes.ClientesScreen;
import br.com.mentoriajava.cupons.CuponsScreen;
import br.com.mentoriajava.exemplo.PetScreen;
import br.com.mentoriajava.formaspagamento.FormaPagamentoScreen;
import br.com.mentoriajava.pedido.PedidosScreen;
import br.com.mentoriajava.produtos.ProdutosScreen;
import br.com.mentoriajava.vendedores.VendedoresScreen;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeApp extends Application {

    private final BorderPane root = new BorderPane();
    private final VBox sidebar = new VBox(10);
    private final ToggleGroup toggleGroup = new ToggleGroup();

    @Override
    public void start(Stage primaryStage) {
        root.setLeft(createSidebar());
        root.setCenter(new StackPane());

        Scene scene = new Scene(root, 1200, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mentoria Java - PDV");
        primaryStage.show();
    }

    private VBox createSidebar() {
        sidebar.setPadding(new Insets(20));
        sidebar.setStyle("-fx-background-color: #F8FAFC;");

        // Criação dos botões
        ToggleButton btnClientes = createSidebarItem("Clientes", "icons/clientes.png", new ClientesScreen());
        ToggleButton btnCupons = createSidebarItem("Cupons", "icons/cupons.png", new CuponsScreen());
        ToggleButton btnFormaPagamento = createSidebarItem("Forma de Pagamento", "icons/formapagamento.png", new FormaPagamentoScreen());
        ToggleButton btnPedidos = createSidebarItem("Pedido", "icons/pedidos.png", new PedidosScreen());
        ToggleButton btnVendedores = createSidebarItem("Vendedores", "icons/vendedores.png", new VendedoresScreen());
        ToggleButton btnProdutos = createSidebarItem("Produtos", "icons/produtos.png", new ProdutosScreen());
        ToggleButton btnExemplo = createSidebarItem("Exemplo", "icons/info.png", new PetScreen());

        ToggleButton[] buttons = {
                btnClientes, btnCupons, btnFormaPagamento, btnPedidos, btnVendedores, btnProdutos, btnExemplo
        };

        // Listener de seleção
        toggleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            for (ToggleButton btn : buttons) {
                if (btn.equals(newToggle)) {
                    btn.setStyle("-fx-background-color: #e0f0ff; -fx-padding: 10;");
                } else {
                    btn.setStyle("-fx-background-color: transparent; -fx-padding: 10;");
                }
            }
        });

        VBox buttonContainer = new VBox(10);
        buttonContainer.getChildren().addAll(buttons);

        VBox.setVgrow(buttonContainer, javafx.scene.layout.Priority.ALWAYS);

        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #F8FAFC;");
        layout.getChildren().addAll(buttonContainer, createLogoutButton());

        return layout;
    }

    private ToggleButton createSidebarItem(String label, String iconPath, Region contentScreen) {
        ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/" + iconPath)));
        icon.setFitWidth(20);
        icon.setFitHeight(20);

        ToggleButton button = new ToggleButton(label, icon);
        button.setToggleGroup(toggleGroup);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setAlignment(Pos.CENTER_LEFT);
        button.setGraphicTextGap(10);
        button.setStyle("-fx-background-color: transparent; -fx-padding: 10;");

        button.setOnAction(event -> {
            root.setCenter(contentScreen);
            button.setStyle("-fx-background-color: #e0f0ff; -fx-padding: 10;");
        });

        return button;
    }

    private Button createLogoutButton() {
        Button logout = new Button("Sair");
        logout.setMaxWidth(Double.MAX_VALUE);
        logout.setStyle("-fx-background-color: #ef4444; -fx-text-fill: white; -fx-padding: 10;");
        logout.setOnAction(e -> System.exit(0));
        return logout;
    }

    public static void main(String[] args) {
        launch();
    }
}
