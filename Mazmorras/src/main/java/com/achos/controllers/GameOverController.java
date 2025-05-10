package com.achos.controllers;

import java.io.IOException;

import com.achos.SceneID;
import com.achos.SceneManager;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class GameOverController {

    
    /** 
     * @throws IOException
     */
    @FXML
    private void switchToWelcome() throws IOException {

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
