package com.achos.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.achos.App;

public class PrimaryController {

    @FXML
    private Button primaryButton;

    @FXML
    private Button secondaryButton1;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
