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
    private StackPane mainStackPane;

    @FXML
    private ImageView background;

    @FXML
    private SplitPane mainSplitPane;

    @FXML
    private StackPane stackLogo;

    @FXML
    private StackPane stackButton;

    @FXML
    private ImageView logo;

    @FXML
    private Button startButton;
    /**
     * boton para empezar el juego
     * @throws IOException excepcion de entrada/salida
     */
    @FXML
    private void switchToIntroduction() throws IOException {
        SceneManager.getInstance().loadScene(SceneID.INTRODUCTION);
    }

}
