package es.ideas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * JavaFX App
 */
public class MultiLenguajeUI extends Application {

    private static Stage escenario;

    @Override
    public void start(Stage stage) throws IOException {
        MultiLenguajeUI.escenario = stage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("primary.fxml"));
        loader.setResources(ResourceBundle.getBundle
                ("es.ideas.i18n/cadenas",
                        Locale.getDefault()));
        Parent raiz = loader.load();
        PrimaryController pc = loader.getController();
        pc.setMainWindow(this);

        Scene scene = new Scene(raiz, 600, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Multi-Lenguaje");
        stage.show();
    }

    public static Stage getPrimaryStage(){
        return escenario;
    }

    public static void main(String[] args) {
        launch();
    }

}