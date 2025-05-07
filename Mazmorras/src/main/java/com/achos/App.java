package com.achos;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws Exception {
        SplitPane root = FXMLLoader.load(getClass().getResource("/com/achos/views/game.fxml"));
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("PATATAZOS");
        stage.getIcons().add(new Image(App.class.getResource("/com/achos/images/logo.png").toExternalForm()));
        stage.setScene(scene);
        SceneManager sm = SceneManager.getInstance();
        sm.setStage(stage);  
        sm.loadScene(SceneID.PRIMARY); 
    
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/achos/views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }
    

    public static void main(String[] args) {
        launch();
    }

}