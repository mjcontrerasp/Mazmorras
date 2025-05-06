package com.achos.controllers;

import com.achos.enums.TipoCelda;
import com.achos.interfaces.Observer;
import com.achos.model.Celda;
import com.achos.model.Enemigo;
import com.achos.model.Heroe;
import com.achos.model.Mapa;
import com.achos.model.Partida;
import com.achos.model.Personaje;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class TertiaryController implements Observer {

    @FXML
    private AnchorPane juego;

    @FXML
    private SplitPane pantalla;

    private final int tileSize = 50;

    private final String URL_SUELO = "/com/achos/images/suelo.png";
    private final String URL_PARED = "/com/achos/images/paredes.png";

    private final String URL_PABLO = "/com/achos/images/pablo-cenital.png";
    private final String URL_GABINO = "/com/achos/images/gabino-cenital.png";
    private final String URL_MANU = "/com/achos/images/manu-cenital.png";
    private final String URL_GLORIA = "/com/achos/images/gloria-cenital.png";

    private static Partida partida = Partida.getInstance();

    @FXML
    public void initialize() {
        generarMapa();
        
        pantalla.setOnKeyPressed(tecla -> teclaToMovimiento(tecla));

    }

    private void generarMapa() {
        ArrayList<ArrayList<Celda>> celdas = partida.getMapa().getCeldas();

        juego.getChildren().clear();

        // Rellenar grid panel
        GridPane gridPane = new GridPane();
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        // Rellenar grid panel
        for (int fila = 0; fila < celdas.size(); fila++) {
            for (int columna = 0; columna < celdas.get(fila).size(); columna++) {
                StackPane stackPane = crearCeldaVisual(celdas.get(fila).get(columna));
                gridPane.add(stackPane, columna, fila);
            }
        }

        juego.getChildren().add(gridPane);
    }

    private StackPane crearCeldaVisual(Celda celda) {
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(tileSize, tileSize);
        stackPane.setAlignment(Pos.CENTER);

        ImageView fondo = new ImageView();
        fondo.setFitWidth(tileSize);
        fondo.setFitHeight(tileSize);

        if (celda.getTipoCelda() == TipoCelda.PARED) {
            fondo.setImage(new Image(getClass().getResourceAsStream(URL_PARED)));
        } else if (celda.getTipoCelda() == TipoCelda.SUELO) {
            fondo.setImage(new Image(getClass().getResourceAsStream(URL_SUELO)));
        }
        stackPane.getChildren().add(fondo);

        Personaje p = celda.getOcupadoPor();
        if (p != null) {
            ImageView personajeView = new ImageView();
            personajeView.setFitWidth(tileSize);
            personajeView.setFitHeight(tileSize);
            personajeView.setImage(new Image(getClass().getResourceAsStream(obtenerImagenPersonaje(p))));
            stackPane.getChildren().add(personajeView);
        }

        return stackPane;
    }

    private String obtenerImagenPersonaje(Personaje p) {
        if (p instanceof Heroe) {
            return URL_PABLO;
        } else if (p instanceof Enemigo) {
            switch (p.getTipoPersonaje()) {
                case GABINO:
                    return URL_GABINO;
                case MANU:
                    return URL_MANU;
                case GLORIA:
                    return URL_GLORIA;
                default:
                    return null;
            }
        }
        return null;
    }

    public void teclaToMovimiento(KeyEvent tecla) {
        int[] movimiento;
        KeyCode teclaTocodigo = tecla.getCode();
        switch (teclaTocodigo) {
            case A:
                movimiento = new int[] { 0, -1 };
                System.out.println("Izquierda");
                break;
            case W:
                movimiento = new int[] { -1, 0 };
                System.out.println("Arriba");
                break;
            case S:
                movimiento = new int[] { 1, 0 };
                System.out.println("Abajo");
                break;
            case D:
                movimiento = new int[] { 0, 1 };
                System.out.println("Derecha");
                break;

            default:
                movimiento = new int[] { 0, 0 };
                System.out.println("Movimiento erroneo");
                break;
        }
        partida.moverPersonajes(movimiento);
    }

    @Override
    public void onChange() {
        generarMapa();
    }
}