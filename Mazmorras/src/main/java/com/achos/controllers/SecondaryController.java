package com.achos.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import com.achos.App;

public class SecondaryController {

    @FXML private TextField vida;
    @FXML private TextField daño;
    @FXML private TextField velocidad;
    @FXML private TextField agilidad;
    @FXML private TextField percepcion;

    @FXML private Label atri1;
    @FXML private Label atri2;
    @FXML private Label atri3;
    @FXML private Label atri4;
    @FXML private Label atri5;

    @FXML
    private void switchToPrimary() throws IOException {
        int v = parseInputOrDefault(vida.getText(), 5);
        int d = parseInputOrDefault(daño.getText(), 5);
        int vel = parseInputOrDefault(velocidad.getText(), 5);
        int agi = parseInputOrDefault(agilidad.getText(), 5);
        int per = parseInputOrDefault(percepcion.getText(), 5);

        atri1.setText(String.valueOf(v));
        atri2.setText(String.valueOf(d));
        atri3.setText(String.valueOf(vel));
        atri4.setText(String.valueOf(agi));
        atri5.setText(String.valueOf(per));

        App.setRoot("primary");
    }

    private int parseInputOrDefault(String input, int defaultValue) {
        try {
            int value = Integer.parseInt(input);
            if (value >= 0 && value <= 10) {
                return value;
            }
        } catch (NumberFormatException e) {

        }
        return defaultValue;
    }
}
