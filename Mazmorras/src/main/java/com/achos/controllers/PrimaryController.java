package com.achos.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.achos.App;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondaryview"); 
    }

    @FXML
    private void switchToTertiary() throws IOException {
        App.setRoot("tertiaryview");   
    }
}
