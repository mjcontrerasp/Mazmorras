package com.achos.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.achos.App;

public class TertiaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primaryview");
    }

    // Aquí puedes añadir lógica de juego si hay enemigos o condiciones para ganar o perder

    // Ejemplo de navegación cuando se gane:
    private void mostrarVictoria() throws IOException {
        App.setRoot("victoria");
    }

    // Ejemplo de navegación cuando se pierda:
    private void mostrarGameOver() throws IOException {
        App.setRoot("gameover");
    }
}
