package com.achos.controllers;

import java.io.IOException;

import com.achos.SceneID;
import com.achos.SceneManager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class WelcomeController {

    @FXML
    StackPane mainStackPane;

    @FXML
    ImageView background;

    @FXML
    SplitPane mainSplitPane;

    @FXML
    StackPane stackLogo;

    @FXML
    StackPane stackButton;

    @FXML
    ImageView logo;

    @FXML
    Button startButton;

    @FXML
    private void switchToIntroduction() throws IOException {
        SceneManager.getInstance().loadScene(SceneID.INTRODUCTION);
    }

}
