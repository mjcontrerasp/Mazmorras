package com.achos.controllers;

import java.io.IOException;

import com.achos.App;

import javafx.fxml.FXML;

public class GameOverController {

    
    /** 
     * @throws IOException
     */
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primaryview");
    }
    /** 
     * @throws IOException
     */
    @FXML
    private void salirDelJuego() {
        System.exit(0);
    }
}
