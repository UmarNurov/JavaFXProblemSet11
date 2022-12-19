module com.example.painterapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.painterapp to javafx.fxml;
    exports com.example.painterapp;
}