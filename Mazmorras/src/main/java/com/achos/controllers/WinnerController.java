package com.achos.controllers;

import java.io.IOException;

import com.achos.SceneID;
import com.achos.SceneManager;
import com.achos.model.Partida;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class WinnerController {

    private Partida partida = Partida.getInstance();
    /** 
     * boton para volver a la pantalla de inicio pero reseteando la partida 
     * @throws IOException excepcion de entrada/salida
     */
    @FXML
    private void switchToContinuar() throws IOException {
        partida.resetear();
        partida.subirNivelPartida();
        Partida.setFuerza(partida.getHeroe().getFuerza());
        Partida.setVelocidad(partida.getHeroe().getVelocidad());
        Partida.setPartidaNueva(false);
        SceneManager.getInstance().loadScene(SceneID.GAME);
    }

    /** 
     * boton para salir del juego
     * @throws IOException  excepcion de entrada/salida
     */
    @FXML
    private void switchToExit() {
        Platform.exit();
    }
}
