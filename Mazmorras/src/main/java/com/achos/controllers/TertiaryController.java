package com.achos.controllers;

import com.achos.model.Mapa;
import com.achos.model.Celda;
import com.achos.enums.TipoCelda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class TertiaryController {

    @FXML
    private GridPane mapa;
    private Mapa mapaModelo;
    private Celda personajeActual;

    @FXML
    private Label manu;

    @FXML
    private Label gloria;

    @FXML
    private Label gabino;

    @FXML
    private void switchToPrimary(ActionEvent event) {
        System.out.println("Cambiando a la escena primaria...");
    }

    @FXML
    private void moverPersonaje(KeyEvent event) {
        if (personajeActual == null) return;

        int[] posicionActual = personajeActual.getPosicicion();
        int nuevaX = posicionActual[0];
        int nuevaY = posicionActual[1];

        switch (event.getCode()) {
            case W:
            case UP:
                nuevaX--;
                break;
            case S:
            case DOWN:
                nuevaX++;
                break;
            case A:
            case LEFT:
                nuevaY--;
                break;
            case D:
            case RIGHT:
                nuevaY++;
                break;
            default:
                return;
        }
        if (nuevaX >= 0 && nuevaX < mapaModelo.getCeldas().size() &&
            nuevaY >= 0 && nuevaY < mapaModelo.getCeldas().get(0).size()) {

            Celda nuevaCelda = mapaModelo.getCeldas().get(nuevaX).get(nuevaY);

            if (nuevaCelda.getTipoCelda() != TipoCelda.PARED && nuevaCelda.getOcupadoPor() == null) {
                nuevaCelda.setOcupadoPor(personajeActual.getOcupadoPor());
                personajeActual.setOcupadoPor(null);
                personajeActual = nuevaCelda;

                inicializarMapa(mapaModelo);
            }
        }
    }

    public void inicializarMapa(Mapa mapaModelo) {
        this.mapaModelo = mapaModelo;
        ArrayList<ArrayList<Celda>> celdas = mapaModelo.getCeldas();

        mapa.getChildren().clear();

        for (int i = 0; i < celdas.size(); i++) {
            for (int j = 0; j < celdas.get(i).size(); j++) {
                Celda celda = celdas.get(i).get(j);
                Rectangle rect = new Rectangle(30, 30);
                if (celda.getTipoCelda() == TipoCelda.PARED) {
                    rect.setFill(Color.GRAY);
                } else if (celda.getOcupadoPor() != null) {
                    rect.setFill(Color.BLUE);
                    personajeActual = celda;
                } else {
                    rect.setFill(Color.WHITE);
                }
                rect.setStroke(Color.BLACK);
                mapa.add(rect, celda.getPosicicion()[1], celda.getPosicicion()[0]);
            }
        }
    }

    @FXML
    public void initialize() {
        System.out.println("Controlador de Tertiary inicializado.");

        manu.setText("Manu");
        gloria.setText("Gloria");
        gabino.setText("Gabino");
    }
}
