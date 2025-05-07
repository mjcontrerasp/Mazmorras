package com.achos;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.achos.controllers.TertiaryController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private static SceneManager instance;
    private Stage stage;
    private final Map<SceneID, String> sceneMap = new HashMap<>();

    private SceneManager() {
        sceneMap.put(SceneID.WELCOME, "/com/achos/views/welcome.fxml");
        sceneMap.put(SceneID.EDITPLAYER, "/com/achos/views/editplayer.fxml");
        sceneMap.put(SceneID.TERTIARY, "/com/achos/views/tertiary.fxml");
        sceneMap.put(SceneID.VICTORY, "/com/achos/views/victoria.fxml");
        sceneMap.put(SceneID.GAMEOVER, "/com/achos/views/gameover.fxml");
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public void init(Stage stage) {
        this.stage = stage;
    }

    public void loadScene(SceneID sceneID) throws IOException {
        String fxmlPath = sceneMap.get(sceneID);
        if (fxmlPath == null) {
            throw new IllegalArgumentException("No se encontró la escena para el ID: " + sceneID);
        }
        System.out.println("Intentando cargar: " + fxmlPath);
        if (getClass().getResource(fxmlPath) == null) {
            throw new IOException("No se pudo encontrar el archivo FXML en la ruta: " + fxmlPath);
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();

    }

}