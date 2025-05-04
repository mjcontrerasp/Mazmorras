package com.achos.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.achos.App;

public class GameOverController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primaryview");
    }

    @FXML
    private void salirDelJuego() {
        System.exit(0);
    }
}
