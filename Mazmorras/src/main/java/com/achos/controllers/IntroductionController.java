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
    private StackPane mainStackPane;

    @FXML
    private ImageView background;

    @FXML
    private VBox mainVBox;

    @FXML
    private StackPane stackPersonajes;

    @FXML
    private ImageView img_inicio;

    @FXML
    private StackPane stackIntro;

    @FXML
    private Pane cajaTexto;

    @FXML
    private VBox texto;

    @FXML
    private Label title;

    @FXML
    private Label p1;

    @FXML
    private Label p2;

    @FXML
    private StackPane stackButton;

    @FXML
    private SplitPane splitButton;

    @FXML
    private StackPane stackCrear;

    @FXML
    private Button crearPersonaje;

    @FXML
    private StackPane stackJugar;

    @FXML
    private Button jugar;

    @FXML
    private Button startButton;

    @FXML
    private void switchToEdit() throws IOException {
        SceneManager.getInstance().loadScene(SceneID.EDITPLAYER);
    }

    @FXML
    private void switchToGame() throws IOException {
        SceneManager.getInstance().loadScene(SceneID.TERTIARY);
    }
}
