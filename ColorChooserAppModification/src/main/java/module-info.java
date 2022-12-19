module com.example.colorchooserappmodification {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.colorchooserappmodification to javafx.fxml;
    exports com.example.colorchooserappmodification;
}