package com.achos.controllers;

import java.io.IOException;

import com.achos.SceneID;
import com.achos.SceneManager;
import com.achos.enums.TipoPersonaje;
import com.achos.model.Heroe;
import com.achos.model.Partida;
import com.achos.model.Personaje;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EditPlayerController {

    @FXML
    private VBox mainVBox;

    @FXML
    private Label titulo;

    @FXML
    private SplitPane mainSplitPane;

    @FXML
    private ImageView pablo;

    @FXML
    private VBox VBox2;

    @FXML
    private Label atributos;

    @FXML
    private VBox VBox3;

    @FXML
    private HBox HBox1;

    @FXML
    private ImageView vida;

    @FXML
    private Slider sliderVida;

    @FXML
    private Label labelVida;

    @FXML
    private HBox HBox2;

    @FXML
    private ImageView fuerza;

    @FXML
    private Slider sliderFuerza;

    @FXML
    private Label labelFuerza;

    @FXML
    private HBox HBox3;

    @FXML
    private ImageView velocidad;

    @FXML
    private Slider sliderVelocidad;

    @FXML
    private Label labelVelocidad;

    @FXML
    private Label descripcion;

    @FXML
    private Button jugar;

    @FXML
    public void initialize() {

        // valores iniciales de los sliders
        sliderFuerza.setValue(5);
        sliderVelocidad.setValue(5);

        // listener para reflejar los cambios del slider en el label
        sliderFuerza.valueProperty().addListener((observable, oldValue, newValue) -> {
            int fuerza = newValue.intValue(); // Convertir a entero

            int velocidad = (int) sliderVelocidad.getValue();

            if (fuerza + velocidad > 15) {
                sliderVelocidad.setValue(15 - fuerza); // limitar la velocidad
            }

            labelFuerza.setText(String.valueOf(fuerza));
        });

        sliderVelocidad.valueProperty().addListener((observable, oldValue, newValue) -> {
            int velocidad = newValue.intValue();

            int fuerza = (int) sliderFuerza.getValue();

            if (velocidad + fuerza > 15) {
                sliderFuerza.setValue(15 - velocidad); // limitar la fuerza
            }

            labelVelocidad.setText(String.valueOf(velocidad));
        });

    }


    public void setHeroe(){
        Partida partida = Partida.getInstance();

        int velocidad = (int) sliderVelocidad.getValue();
        int fuerza = (int) sliderFuerza.getValue();

        Heroe pablo = null;
        for (Personaje p : partida.getPersonajes()) {
            if (p instanceof Heroe) {
                pablo = (Heroe) p;
            }
        }



        partida.getPersonajes().remove(pablo);
        System.out.println(partida.getPersonajes().toString());
        
        partida.getPersonajes().add(new Heroe("Pablo", velocidad, fuerza, TipoPersonaje.PABLO)); 

        partida.personajesToSpawn();
        
        System.out.println(partida.getPersonajes().toString());

        partida.buscarHeroe();
        System.out.println(partida.getHeroe().toString());


    }

    // Buscar a Pablo
// Personaje pablo = null;
// for (Personaje p : treeSet) {
//     if (p.getNombre().equals("Pablo")) {
//         pablo = p;
//     }
// }

// if (pablo != null) {
//     treeSet.remove(pablo); 

//     
//     pablo.setVelocidad(10); 
//     pablo.setFuerza(9);      

//     treeSet.add(pablo); 

////// o  personajes.add(new Heroe("Pablo", newvelocidad, newfuerza, TipoPersonaje.PABLO))
// }


    @FXML
    private void switchToGame() throws IOException {
        setHeroe();
        SceneManager.getInstance().loadScene(SceneID.TERTIARY);
    }
}
