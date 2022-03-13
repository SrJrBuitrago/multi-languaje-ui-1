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
    // El método start crea un objeto loader de la clase FXMLLoader para cargar
    // los recursos de la vista (primary.fxml) y los recursos de
    // internacionalización (Resource Bundle 'cadenas').Asignamos el controlador
    // creando un objeto de la clase PrimaryController (pc) y le asignamos el
    // controlador mediante el método getController() de la clase FXMLLoader.
    //Indicamos con pc.setMainWindow(this) que esta va a ser la ventana
    // principal. Creamos una Escena y le pasamos como parámetro el parent
    // (raiz), un ancho y un alto. Con el método setScene setteamos nuestra
    // escena al escenario que hemos creado arriba, decimos mediante el método
    //setResizable(false) que nuestro escenario no es expandible, le damos un
    // título usando el método setTitle y mostramos el escenario usando el
    // método show()
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
        stage.setTitle("Multi-Lenguaje-UI");
        stage.show();
    }

    public static Stage getPrimaryStage(){
        return escenario;
    }

    public static void main(String[] args) {
        launch();
    }

}