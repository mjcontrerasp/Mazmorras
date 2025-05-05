package com.achos.controllers;

import java.io.IOException;

import com.achos.SceneID;
import com.achos.SceneManager;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
       SceneManager.getInstance().loadScene(SceneID.SECONDARY); 
    }

    @FXML
    private void switchToTertiary() throws IOException {
        SceneManager.getInstance().loadScene(SceneID.TERTIARY);   
    }
}
