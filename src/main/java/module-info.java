module br.com.mentoria.java {
    requires javafx.controls;
    requires javafx.fxml;

    exports br.com.mentoria.java;
    opens br.com.mentoria.java to javafx.fxml;
}