package com.achos.controllers;

import java.io.IOException;

import com.achos.SceneID;
import com.achos.SceneManager;
import com.achos.model.Partida;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class GameOverController {

    /**
     * @throws IOException
     */
    @FXML
    private void switchToWelcome() throws IOException {
        Partida.getInstance().resetearNivelPartida();
        Partida.getInstance().resetear();
        SceneManager.getInstance().loadScene(SceneID.WELCOME);
    }

    /**
     * @throws IOException
     */
    @FXML
    private void switchToExit() {
        Platform.exit();
    }
}
