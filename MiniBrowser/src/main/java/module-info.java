module com.example.minibrowser {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.example.minibrowser to javafx.fxml;
    exports com.example.minibrowser;
}