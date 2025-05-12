package com.achos;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private static SceneManager instance;
    private Stage stage;
    private final Map<SceneID, String> sceneMap = new HashMap<>();
    /**
     * Mapeo de los ID de las escenas a sus rutas FXML
     * @param sceneID
     */
    private SceneManager() {
        sceneMap.put(SceneID.WELCOME, "/com/achos/views/welcome.fxml");
        sceneMap.put(SceneID.INTRODUCTION, "/com/achos/views/introduction.fxml");
        sceneMap.put(SceneID.EDITPLAYER, "/com/achos/views/editplayer.fxml");
        sceneMap.put(SceneID.GAME, "/com/achos/views/game.fxml");
        sceneMap.put(SceneID.VICTORY, "/com/achos/views/victoria.fxml");
        sceneMap.put(SceneID.GAMEOVER, "/com/achos/views/gameover.fxml");
    }
    /**
     * Establecer el escenario actual
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    /**
     * Obtener la instancia del SceneManager
     * @return
     */
    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }
    /**
     * Obtener el escenario actual
     * @return
     */
    public void init(Stage stage) {
        this.stage = stage;
    }
    /**
     * Cargar una escena a partir de su ID
     * @param sceneID
     * @throws IOException
     */
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