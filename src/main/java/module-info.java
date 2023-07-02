module imhoff.dbclientappv1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    opens imhoff.dbclientappv1 to javafx.fxml;
    exports imhoff.dbclientappv1;
    exports controller;
    opens controller to javafx.fxml;
}