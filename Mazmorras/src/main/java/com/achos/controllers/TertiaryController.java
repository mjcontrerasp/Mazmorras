package com.achos.controllers;

import java.util.ArrayList;

import com.achos.enums.TipoCelda;
import com.achos.interfaces.Observer;
import com.achos.model.Celda;
import com.achos.model.Enemigo;
import com.achos.model.Heroe;
import com.achos.model.Partida;
import com.achos.model.Personaje;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

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

    private static Partida partida = Partida.getInstance(); // Obtener la partida actual

    // Constructor
    @FXML
    public void initialize() { 
        generarMapa(); // Generar el mapa al iniciar la pantalla
        
        pantalla.setOnKeyPressed(tecla -> teclaToMovimiento(tecla)); // Asignar el evento de teclado al juego

    }
    /**
     * Genera el mapa a partir de la partida
     */
    private void generarMapa() {
        ArrayList<ArrayList<Celda>> celdas = partida.getMapa().getCeldas(); // Obtener las celdas del mapa

        juego.getChildren().clear(); // Limpiar el juego antes de añadir el nuevo mapa

        // Rellenar grid panel
        GridPane gridPane = new GridPane(); // Crear un GridPane para el mapa
        gridPane.setHgap(0); // Espacio horizontal entre celdas
        gridPane.setVgap(0);  // Espacio vertical entre celdas
        // Rellenar grid panel
        for (int fila = 0; fila < celdas.size(); fila++) { // Recorrer las filas
            for (int columna = 0; columna < celdas.get(fila).size(); columna++) { // Recorrer las filas y columnas
                StackPane stackPane = crearCeldaVisual(celdas.get(fila).get(columna));  // Crear la celda visual
                gridPane.add(stackPane, columna, fila); // Añadir la celda al GridPane
            }
        }

        juego.getChildren().add(gridPane); // Añadir el GridPane al juego
    }
    /**
     * Crea una celda visual a partir de la celda del mapa
     * @param celda
     * @return
     */
    private StackPane crearCeldaVisual(Celda celda) {
        StackPane stackPane = new StackPane(); // Crear un StackPane para la celda
        stackPane.setPrefSize(tileSize, tileSize); // Establecer el tamaño preferido
        stackPane.setAlignment(Pos.CENTER); // Centrar el contenido

        ImageView fondo = new ImageView(); // Crear un ImageView para el fondo
        fondo.setFitWidth(tileSize); // Establecer el ancho del fondo
        fondo.setFitHeight(tileSize); // Establecer la altura del fondo

        if (celda.getTipoCelda() == TipoCelda.PARED) { // Si es una pared
            fondo.setImage(new Image(getClass().getResourceAsStream(URL_PARED))); // Establecer la imagen de la pared
        } else if (celda.getTipoCelda() == TipoCelda.SUELO) { // Si es un suelo
            fondo.setImage(new Image(getClass().getResourceAsStream(URL_SUELO))); // Establecer la imagen del suelo
        }
        stackPane.getChildren().add(fondo); // Añadir el fondo al StackPane

        Personaje p = celda.getOcupadoPor(); // Obtener el personaje que ocupa la celda
        // Si hay un personaje en la celda, añadir su imagen
        if (p != null) {
            ImageView personajeView = new ImageView(); // Crear un ImageView para el personaje
            personajeView.setFitWidth(tileSize);    // Establecer el ancho del personaje
            personajeView.setFitHeight(tileSize);   // Establecer la altura del personaje
            personajeView.setImage(new Image(getClass().getResourceAsStream(obtenerImagenPersonaje(p)))); // Establecer la imagen del personaje
            stackPane.getChildren().add(personajeView); // Añadir el personaje al StackPane
        }

        return stackPane; // Devolver el StackPane con la celda
    }
    /**
     * Devuelve la URL de la imagen del personaje
     * @param p
     * @return
     */
    private String obtenerImagenPersonaje(Personaje p) {
        if (p instanceof Heroe) { // Si es un heroe
            return URL_PABLO; 
        } else if (p instanceof Enemigo) { // Si es un enemigo 
            switch (p.getTipoPersonaje()) { // Comprobamos el tipo de personaje
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
        return null; // Si no es un personaje conocido
    }
    /**
     * Mueve el personaje a la celda correspondiente
     * @param tecla
     */
    public void teclaToMovimiento(KeyEvent tecla) {
        int[] movimiento;
        KeyCode teclaTocodigo = tecla.getCode();
        switch (teclaTocodigo) {
            case A:
                movimiento = new int[] { 0, -1 }; // Cambia el personaje a la izquierda
                System.out.println("Izquierda");
                break;
            case W:
                movimiento = new int[] { -1, 0 };// Cambia el personaje a la derecha
                System.out.println("Arriba");
                break;
            case S:
                movimiento = new int[] { 1, 0 };// Cambia el personaje a la izquierda
                System.out.println("Abajo");
                break;
            case D:
                movimiento = new int[] { 0, 1 };// Cambia el personaje a la derecha
                System.out.println("Derecha"); 
                break;

            default:
                movimiento = new int[] { 0, 0 }; // No se mueve
                System.out.println("Movimiento erroneo");
                break;
        }
        partida.moverPersonajes(movimiento);
    }
    /**
     * Cambia la escena a la pantalla de inicio
     */
    @Override
    public void onChange() {
        generarMapa(); 
    }
}