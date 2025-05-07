package com.achos.controllers;

import java.io.IOException;

import com.achos.SceneID;
import com.achos.SceneManager;

import javafx.fxml.FXML;

public class WelcomeController {

    @FXML
    private void switchToIntroduction() throws IOException {
        SceneManager.getInstance().loadScene(SceneID.INTRODUCTION);
    }

}
