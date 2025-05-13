package com.achos;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;
    @SuppressWarnings("exports")
    /**
     * @param stage stage primario que obtiene titulo iconos y la primera escena.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("PATATAZOS");
        stage.getIcons().add(new Image(App.class.getResource("/com/achos/images/logoJuego.png").toExternalForm()));
        SceneManager sm = SceneManager.getInstance();
        sm.setStage(stage);
        sm.loadScene(SceneID.WELCOME);

        stage.show();
    }
    /**
     * da la ruta al archivo fxml
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    /**
     *  carga el archivo fxml
     * @param fxml nombre del archivo fxml
     * @return devuelve la escena
     * @throws IOException excepcion de entrada/salida
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/achos/views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }
    /**
     * main principal que lanza la aplicacion
     * @param args argumentos de la aplicacion
     */
    public static void main(String[] args) {
        launch();
    }

}