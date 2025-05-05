module com.achos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.achos to javafx.fxml;
    exports com.achos;

    opens com.achos.controllers to javafx.fxml; 
    exports com.achos.controllers;
}