package es.ideas;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class PrimaryController implements Initializable {

    @FXML
    private ChoiceBox<String> cbSemana;
    @FXML
    private ToggleButton tbUsa;
    @FXML
    private ToggleButton tbFra;
    @FXML
    private ToggleButton tbUK;
    @FXML
    private ToggleButton tbEsp;
    @FXML
    private ToggleButton tbIta;
    private MultiLenguajeUI principal;
    public void setMainWindow(MultiLenguajeUI main){
        this.principal= main;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Inicialización del ComboBox con los días de la semana
        //También tiene que traducirse
        String dias_semana[] = {rb.getString("lunes"), rb.getString
                ("martes"), rb.getString("miércoles"),
                rb.getString("jueves"), rb.getString("viernes"),
                rb.getString("sábado"), rb.getString("domingo")};
        cbSemana.setItems(FXCollections.observableArrayList(dias_semana));
        ToggleGroup tGroup = new ToggleGroup();
        tGroup.getToggles().addAll(tbEsp,tbIta,tbUK,tbUsa,tbFra);

        tGroup.selectedToggleProperty().addListener((obs,oldValue,newValue)
                ->{
            if (newValue != null ){
                ToggleButton tButton = (ToggleButton) newValue.
                        getToggleGroup()
                        .getSelectedToggle();
                //Se comprueba el valor del Texto del ToggleButton
                switch (tButton.getText()){
                    case "Italiano":
                        Locale.setDefault(Locale.ITALIAN);

                        break;
                    case "Inglés USA":
                        Locale.setDefault(Locale.US);

                        break;
                    case "Francés":
                        Locale.setDefault(Locale.FRENCH);

                        break;
                    case "Inglés UK":
                        Locale.setDefault(Locale.UK);

                        break;
                    default:
                        Locale.setDefault(new Locale("es"));

                }
                try{
                    Parent pane = cargadorFXML().load();
                    MultiLenguajeUI.getPrimaryStage().getScene().setRoot
                            (pane);
                }catch(IOException ieo){
                }
                MultiLenguajeUI.getPrimaryStage().show();
            }

        });
    }

    private FXMLLoader cargadorFXML(){
        FXMLLoader loader = new FXMLLoader();
        loader.setResources(ResourceBundle.getBundle(
                "es.ideas.i18n/cadenas",
                Locale.getDefault()));
        loader.setLocation(getClass().getResource("primary.fxml"));
        return loader;
    }

}
