package com.achos.controllers;

import java.io.IOException;

import com.achos.SceneID;
import com.achos.SceneManager;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class WinnerController {

    
    /** 
     * @throws IOException
     */
    @FXML
    private void switchToContinuar() throws IOException {
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
