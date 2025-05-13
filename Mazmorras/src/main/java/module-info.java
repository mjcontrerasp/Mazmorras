/**
 * este modulo es el principal de la aplicacion
 * contiene la clase principal y el controlador de la aplicacion
 * @author Manu, Gloria, Gabino
 */
module com.achos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.achos to javafx.fxml;
    exports com.achos;

    opens com.achos.controllers to javafx.fxml; 
    exports com.achos.controllers;
}