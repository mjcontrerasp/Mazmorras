package com.achos.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.achos.App;

public class WinnerController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primaryview");
    }

    @FXML
    private void terminarJuego() {
        System.exit(0);
    }
}
