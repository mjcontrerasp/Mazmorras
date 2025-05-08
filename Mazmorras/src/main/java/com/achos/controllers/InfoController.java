package com.achos.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

public class InfoController {

    @FXML private ProgressBar vidapablo;
    @FXML private ProgressBar vidagabi;
    @FXML private ProgressBar vidagloria;
    @FXML private ProgressBar vidamanu;

    private final double MAX_VIDA = 10.0;

    public void setVidaPablo(double vida) {
        vidapablo.setProgress(clamp(vida / MAX_VIDA));
    }

    public void setVidaGabi(double vida) {
        vidagabi.setProgress(clamp(vida / MAX_VIDA));
    }

    public void setVidaGloria(double vida) {
        vidagloria.setProgress(clamp(vida / MAX_VIDA));
    }

    public void setVidaManu(double vida) {
        vidamanu.setProgress(clamp(vida / MAX_VIDA));
    }

    private double clamp(double value) {
        return Math.max(0, Math.min(1, value));
    }
}
