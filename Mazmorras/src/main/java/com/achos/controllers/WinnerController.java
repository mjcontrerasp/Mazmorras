package com.achos.controllers;

import java.io.IOException;

import com.achos.App;

import javafx.fxml.FXML;

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
