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
import javafx.stage.Stage;

public class PlaneDeleteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button DeletePlaneButton;

    @FXML
    private Button GoBackButton;

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

                // Видаляємо літак з бд
                DeletePlaneButton.setOnAction(actionEvent -> {
                    DatabaseAction action = new DatabaseAction();
                    action.PlaneDelete(PlaneListView.getSelectionModel().getSelectedItem());

                    // Повертаємось назад в меню
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
            }
        });
    }
}

