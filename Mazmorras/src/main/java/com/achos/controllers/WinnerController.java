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
     * @throws IOException
     */
    @FXML
    private void switchToContinuar() throws IOException {
        partida.resetear();
        partida.subirNivelPartida();
        partida.subirNivelPersonajes();
        SceneManager.getInstance().loadScene(SceneID.GAME);
    }

    /** 
     * @throws IOException
     */
    @FXML
    private void switchToExit() {
        Platform.exit();
    }
}
