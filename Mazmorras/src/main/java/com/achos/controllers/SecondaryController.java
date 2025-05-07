package com.achos.controllers;

import java.io.IOException;

import com.achos.SceneID;
import com.achos.SceneManager;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML
    private Label atri1;
    @FXML
    private Label atri2;
    @FXML
    private Label atri3;

    @FXML
    private TextField vida;
    @FXML
    private TextField daño;
    @FXML
    private TextField velocidad;
    
    @FXML
    public void initialize() {
        vida.setText("5");
        daño.setText("5");
        velocidad.setText("5");

        atri1.setText("5");
        atri2.setText("5");
        atri3.setText("5");
    }
    /**
     * Este método se encarga de actualizar los atributos de vida, daño y velocidad
     * en función de los valores introducidos por el usuario en los campos de texto.
     * 
     * @throws NumberFormatException si el valor introducido no es un número válido.
     */
    @FXML
    public void actualizarAtributos() {
        try {
            int valorVida = Integer.parseInt(vida.getText());
            int valorDaño = Integer.parseInt(daño.getText());
            int valorVelocidad = Integer.parseInt(velocidad.getText());

            if (valorVida >= 1 && valorVida <= 10) {
                atri1.setText(String.valueOf(valorVida));
            } else {
                atri1.setText("Valor fuera de rango");
            }

            if (valorDaño >= 1 && valorDaño <= 10) {
                atri2.setText(String.valueOf(valorDaño));
            } else {
                atri2.setText("Valor fuera de rango");
            }

            if (valorVelocidad >= 1 && valorVelocidad <= 10) {
                atri3.setText(String.valueOf(valorVelocidad));
            } else {
                atri3.setText("Valor fuera de rango");
            }
        } catch (NumberFormatException e) {
            atri1.setText("Valor inválido");
            atri2.setText("Valor inválido");
            atri3.setText("Valor inválido");
        }
    }
    /**
     * Este método se encarga de cambiar a la vista de juego.
     * 
     * @throws IOException si ocurre un error al cargar la vista.
     */
    @FXML
    public void switchToGame() throws IOException {
        SceneManager.getInstance().loadScene(SceneID.GAME);
    }
}
