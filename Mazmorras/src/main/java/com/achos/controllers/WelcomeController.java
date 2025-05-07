package com.achos.controllers;

import java.io.IOException;

import com.achos.SceneID;
import com.achos.SceneManager;

import javafx.fxml.FXML;

public class WelcomeController {

    @FXML
    private void switchToSecondary() throws IOException {
        SceneManager.getInstance().loadScene(SceneID.EDITPLAYER);
    }

    @FXML
    private void switchToTertiary() throws IOException {
        SceneManager.getInstance().loadScene(SceneID.TERTIARY);
    }
}
