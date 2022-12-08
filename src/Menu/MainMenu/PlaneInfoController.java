package Menu.MainMenu;

import java.net.URL;
import java.util.ResourceBundle;

import Airline.Plane;
import Database.DatabaseAction;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlaneInfoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button GoBackButton;

    @FXML
    private Text PlaneInfoText;

    @FXML
    private ListView<Plane> PlaneListView;

    @FXML
    void initialize() {

        // Додаємо функціонал кнопці назад
        GoBackButton.setOnAction(actionEvent -> {
            try{
                Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) GoBackButton.getScene().getWindow();

                stage.setScene(scene);
                stage.show();
            }
            catch(java.io.IOException e){
                e.printStackTrace();
            }
        });

        // Додаємо функціонал ListView
        DatabaseAction action = new DatabaseAction();
        PlaneListView.getItems().addAll(action.GetPlaneList());

        PlaneListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Plane>() {
            @Override
            public void changed(ObservableValue<? extends Plane> observableValue, Plane plane, Plane t1) {

                Plane interestedPlane = PlaneListView.getSelectionModel().getSelectedItem();
                PlaneInfoText.setText(interestedPlane.detailInformation());

            }
        });
    }
}
