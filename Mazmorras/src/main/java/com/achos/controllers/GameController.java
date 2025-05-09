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
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameController implements Observer {
    @FXML
    private VBox infoBox;

    @FXML
    private AnchorPane juego;

    @FXML
    private SplitPane pantalla;

    private final int tileSize = 32;

    // Usamos las rutas relativas para las imágenes
    private final String URL_SUELO = "/com/achos/images/suelo.png";
    private final String URL_PARED = "/com/achos/images/paredes.png";
    private final String URL_TECLAS = "/com/achos/images/teclas-removebg-preview.png";

    private Partida partida = Partida.getInstance(); // Obtener la partida actual

    // Constructor
    @FXML
    public void initialize() {

        partida.subscribe(this);
        generarMapa(); // Generar el mapa al iniciar la pantalla
        generarInfoPersonajes();

        juego.setOnMouseClicked(e -> juego.requestFocus());
        juego.setOnKeyPressed(e -> System.out.println("Holiiii"));
        juego.setOnKeyPressed(e -> teclaToMovimiento(e));
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
        gridPane.setVgap(0); // Espacio vertical entre celdas
        // Rellenar grid panel
        for (int fila = 0; fila < celdas.size(); fila++) { // Recorrer las filas
            for (int columna = 0; columna < celdas.get(fila).size(); columna++) { // Recorrer las filas y columnas
                StackPane stackPane = crearCeldaVisual(celdas.get(fila).get(columna)); // Crear la celda visual
                gridPane.add(stackPane, columna, fila); // Añadir la celda al GridPane
            }
        }

        juego.getChildren().add(gridPane); // Añadir el GridPane al juego
    }

    /**
     * Crea una celda visual a partir de la celda del mapa
     * 
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
            fondo.setImage(new Image(getClass().getResource(URL_PARED).toExternalForm())); 
        } else if (celda.getTipoCelda() == TipoCelda.SUELO) { // Si es un suelo
            fondo.setImage(new Image(getClass().getResource(URL_SUELO).toExternalForm())); 
        }
        stackPane.getChildren().add(fondo); // Añadir el fondo al StackPane

        Personaje p = celda.getOcupadoPor(); // Obtener el personaje que ocupa la celda
        // Si hay un personaje en la celda, añadir su imagen
        if (p != null) {
            ImageView personajeView = new ImageView(); // Crear un ImageView para el personaje
            personajeView.setFitWidth(tileSize); // Establecer el ancho del personaje
            personajeView.setFitHeight(tileSize); // Establecer la altura del personaje
            personajeView.setImage(new Image(getClass().getResource(obtenerImagenPersonaje(p)).toExternalForm())); // Usamos la ruta relativa
            stackPane.getChildren().add(personajeView); // Añadir el personaje al StackPane
        }

        return stackPane; // Devolver el StackPane con la celda
    }

    /**
     * Devuelve la URL de la imagen del personaje
     * 
     * @param p
     * @return
     */
    private String obtenerImagenPersonaje(Personaje p) {
        if (p instanceof Heroe) { 
            return "/com/achos/images/pablo-cenital.png";
        } else if (p instanceof Enemigo) { 
            switch (p.getTipoPersonaje()) { 
                case GABINO:
                    return "/com/achos/images/gabino-cenital.png";
                case MANU:
                    return "/com/achos/images/manu-cenital.png";
                case GLORIA:
                    return "/com/achos/images/gloria-cenital.png";
                default:
                    return null;
            }
        }
        return null; // Si no es un personaje conocido
    }

    /**
     * Mueve el personaje a la celda correspondiente
     * 
     * @param tecla
     */
    public void teclaToMovimiento(KeyEvent tecla) {
        int[] movimiento;
        KeyCode teclaTocodigo = tecla.getCode();
        switch (teclaTocodigo) {
            case A:
            case LEFT:
                movimiento = new int[] { 0, -1 }; 
                System.out.println("Izquierda");
                break;
            case W:
            case UP:
                movimiento = new int[] { -1, 0 };
                System.out.println("Arriba");
                break;
            case S:
             case DOWN:
                movimiento = new int[] { 1, 0 };
                System.out.println("Abajo");
                break;
            case D:
             case RIGHT:
                movimiento = new int[] { 0, 1 };
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
     * refresca los cambios
     */
    @Override
    public void onChange() {
        generarMapa();
        generarInfoPersonajes();
    }

    /**
     * Genera la información de los personajes en la interfaz
     */
    private void generarInfoPersonajes() {
        infoBox.getChildren().clear();

        for (Personaje p : partida.getPersonajes()) {
            VBox personajeBox = new VBox(5);
            // Nombre del personaje
            Label nombre = new Label(p.getTipoPersonaje().name());

            // Imagenes de los personajes
            ImageView img = new ImageView(new Image(getClass().getResource(obtenerImagenPersonaje(p)).toExternalForm()));
            img.setFitWidth(35);
            img.setFitHeight(35);

            Label vida = new Label("Vida: " + p.getVida());

            if (p.getVida() <= 0) {
                personajeBox.setOpacity(0.3); // ponerlo en gris si muere
            }

            personajeBox.getChildren().addAll(nombre, img, vida);
            infoBox.getChildren().add(personajeBox);
        }
        
        ImageView footerImage = new ImageView(new Image(getClass().getResource(URL_TECLAS).toExternalForm()));
        footerImage.setFitWidth(500); 
        footerImage.setPreserveRatio(true);

        infoBox.getChildren().add(footerImage);
    }
}
