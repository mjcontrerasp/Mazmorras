package com.achos.controllers;

import java.io.IOException;

import com.achos.SceneID;
import com.achos.SceneManager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class IntroductionController {

    @FXML
    StackPane mainStackPane;

    @FXML
    ImageView background;

    @FXML
    VBox mainVBox;

    @FXML
    StackPane stackPersonajes;

    @FXML
    ImageView img_inicio;

    @FXML
    StackPane stackIntro;

    @FXML
    Pane cajaTexto;

    @FXML
    VBox texto;

    @FXML
    Label title;

    @FXML
    Label p1;

    @FXML
    Label p2;

    @FXML
    StackPane stackButton;

    @FXML
    SplitPane splitButton;

    @FXML
    StackPane stackCrear;

    @FXML
    Button crearPersonaje;

    @FXML
    StackPane stackJugar;

    @FXML
    Button jugar;

    @FXML
    Button startButton;

    @FXML
    private void switchToEdit() throws IOException {
        SceneManager.getInstance().loadScene(SceneID.EDITPLAYER);
    }

    @FXML
    private void switchToGame() throws IOException {
        SceneManager.getInstance().loadScene(SceneID.TERTIARY);
    }
}
