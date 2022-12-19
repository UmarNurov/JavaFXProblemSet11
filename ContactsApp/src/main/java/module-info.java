module com.example.contactsapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.contactsapp to javafx.fxml;
    exports com.example.contactsapp;
}