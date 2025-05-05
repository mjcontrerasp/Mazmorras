package com.achos.controllers;

import com.achos.enums.TipoCelda;
import com.achos.model.Celda;
import com.achos.model.Enemigo;
import com.achos.model.Heroe;
import com.achos.model.Mapa;
import com.achos.model.Partida;
import com.achos.model.Personaje;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class TertiaryController {

    @FXML
    private AnchorPane juego;

    private final int tileSize = 50;

    private final String URL_SUELO = "/com/achos/images/suelo.png";
    private final String URL_PARED = "/com/achos/images/paredes.png";

    private final String URL_PABLO = "/com/achos/images/pablo-cenital.png";
    private final String URL_GABINO = "/com/achos/images/gabino-cenital.png";
    private final String URL_MANU = "/com/achos/images/manu-cenital.png";
    private final String URL_GLORIA = "/com/achos/images/gloria-cenital.png";

    @FXML
    public void initialize() {
        generarMapa();
    }

    private void generarMapa() {
        Partida partida = Partida.getInstance();
        Mapa mapa = partida.getMapa();
        ArrayList<ArrayList<Celda>> celdas = mapa.getCeldas();

        
        juego.getChildren().clear();

        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(0);
        gridPane.setVgap(0);

        for (int y = 0; y < celdas.size(); y++) {
            for (int x = 0; x < celdas.get(y).size(); x++) {
                Celda celda = celdas.get(y).get(x);
                StackPane stackPane = crearCeldaVisual(celda);
                gridPane.add(stackPane, x, y);
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
}