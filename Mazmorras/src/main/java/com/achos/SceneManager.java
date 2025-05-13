package com.achos;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Clase SceneManager
 * Esta clase se encarga de gestionar las escenas de la aplicación. Permite cargar diferentes escenas
 */
public class SceneManager {

    private static SceneManager instance;
    private Stage stage;
    private final Map<SceneID, String> sceneMap = new HashMap<>();
    /**
     * Constructor privado para evitar la creación de instancias externas
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
     * Devuelve el escenario actual
     * @return de tipo Stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    /**
     * Devuelve el escenario actual
     * @return de tipo Stage
     */
    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }
    /**
     * Devuelve el escenario actual
     * @return de tipo Stage
     */
    public void init(Stage stage) {
        this.stage = stage;
    }
    /**
     * Cargar una escena a partir de su ID
     * @param sceneID ID de la escena a cargar
     * @throws IOException excepción de entrada/salida
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