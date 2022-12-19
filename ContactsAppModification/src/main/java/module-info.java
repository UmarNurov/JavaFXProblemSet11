module com.example.contactsappmodification {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.contactsappmodification to javafx.fxml;
    exports com.example.contactsappmodification;
}