package com.achos.controllers;

import java.io.IOException;

import com.achos.App;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML
    private TextField vida, daño, velocidad, agilidad, percepcion;

    @FXML
    private Label atri1, atri2, atri3, atri4, atri5;

    @FXML
    public void initialize() {
        atri1.setText("5");
        atri2.setText("5");
        atri3.setText("5");
        atri4.setText("5");
        atri5.setText("5");
    }

    @FXML
    private void switchToPrimary() throws IOException {

        TextField[] textFields = { vida, daño, velocidad, agilidad, percepcion };
        Label[] labels = { atri1, atri2, atri3, atri4, atri5 };

        for (int i = 0; i < textFields.length; i++) {
            String text = textFields[i].getText();
            labels[i].setText(validar(text) ? text : "5");
        }

        App.setRoot("tertiaryview");
    }

    private boolean validar(String texto) {
        try {
            int n = Integer.parseInt(texto);
            return n >= 1 && n <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
