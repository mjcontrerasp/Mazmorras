package com.achos.controllers;

import java.io.IOException;

import com.achos.SceneID;
import com.achos.SceneManager;
import com.achos.model.Partida;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class GameOverController {

    /**
     * boton para volver a la pantalla de inicio
     *
     * @throws IOException excepcion de entrada/salida
     */
    @FXML
    private void switchToWelcome() throws IOException {
        Partida.getInstance().resetearNivelPartida();
        Partida.getInstance().resetear();
        Partida.setPartidaNueva(true);
        SceneManager.getInstance().loadScene(SceneID.WELCOME);
    }

    /**
     * boton para salir del juego
     * @throws IOException excepcion de entrada/salida
     */
    @FXML
    private void switchToExit() {
        Platform.exit();
    }
}
