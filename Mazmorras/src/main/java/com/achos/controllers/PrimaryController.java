package com.achos.controllers;

import java.io.IOException;

import com.achos.SceneID;
import com.achos.SceneManager;

import javafx.fxml.FXML;

public class PrimaryController {
    /**
     * 
     * @throws IOException
     */
    @FXML
    private void switchToSecondary() throws IOException {
       SceneManager.getInstance().loadScene(SceneID.SECONDARY); 
    }
    /**
     * 
     * @throws IOException
     */
    @FXML
    private void switchToTertiary() throws IOException {
        SceneManager.getInstance().loadScene(SceneID.GAME);   
    }
}
