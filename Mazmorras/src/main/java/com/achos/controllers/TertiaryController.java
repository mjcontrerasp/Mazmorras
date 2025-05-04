package com.achos.controllers;

import java.io.IOException;

import com.achos.App;

import javafx.fxml.FXML;

public class TertiaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primaryview");
    }

    @FXML
    private void mostrarVictoria() throws IOException {
        App.setRoot("victoria");
    }

    @FXML
    private void mostrarGameOver() throws IOException {
        App.setRoot("gameover");
    }
}
