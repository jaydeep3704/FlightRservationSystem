module com.example.frs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.frs to javafx.fxml;
    exports com.example.frs;
}