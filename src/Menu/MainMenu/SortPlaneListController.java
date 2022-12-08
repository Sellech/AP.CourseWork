package Menu.MainMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

import Airline.Comparator.*;
import Airline.Plane;
import Database.DatabaseAction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SortPlaneListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button GoBackButton;

    @FXML
    private Button OutputButton;

    @FXML
    private ChoiceBox<String> ParameterChoiceBox;

    @FXML
    private ListView<Plane> PlaneListView;

    @FXML
    private ChoiceBox<String> UpDownChoiceBox;

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

        // Додаємо функціонал ParameterChoiceBox
        String[] options = {"дальність польоту", "споживання палива", "пасажиромісткість", "вантажомісткість"};
        String[] sortOptions = {"спадання", "зростання"};

        ParameterChoiceBox.getItems().addAll(options);
        UpDownChoiceBox.getItems().addAll(sortOptions);

        // Додаємо функціонал кнопці OutputButton
        OutputButton.setOnAction(actionEvent -> {
            String parameter = ParameterChoiceBox.getValue();
            String type = UpDownChoiceBox.getValue();

            if(parameter.equals("") || type.equals("")) {
                try{
                    Parent root = FXMLLoader.load(getClass().getResource("Error.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setTitle("Error");
                    stage.getIcons().add(new Image(getClass().getResourceAsStream("Error.png")));
                    stage.setWidth(215);
                    stage.setHeight(140);
                    stage.setScene(scene);
                    stage.show();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            else {      // Якщо користувач увів все правильно
                PlaneListView.getItems().clear();

                DatabaseAction action = new DatabaseAction();
                ArrayList<Plane> SortedPlaneList = action.GetPlaneList();

                Comparator comparator;

                // для порядку спадання
                if (type.equals("спадання")){

                    switch (ParameterChoiceBox.getValue()){
                        case ("дальність польоту") -> {
                            comparator = new FlyDistanceComparator_DESC();
                            SortedPlaneList.sort(comparator);
                        }
                        case ("споживання палива") -> {
                            comparator = new FuelConsumptionComparator_DESC();
                            SortedPlaneList.sort(comparator);
                        }
                        case ("пасажиромісткість") -> {
                            comparator = new PassengerCapacityComparator_DESC();
                            SortedPlaneList.sort(comparator);
                        }
                        case ("вантажомісткість") -> {
                            comparator = new CargoCapacityComparator_DESC();
                            SortedPlaneList.sort(comparator);
                        }
                    }
                }
                // для порядку зростання
                else {
                    switch (ParameterChoiceBox.getValue()){
                        case ("дальність польоту") -> {
                            comparator = new FlyDistanceComparator_ASC();
                            SortedPlaneList.sort(comparator);
                        }
                        case ("споживання палива") -> {
                            comparator = new FuelConsumptionComparator_ASC();
                            SortedPlaneList.sort(comparator);
                        }
                        case ("пасажиромісткість") -> {
                            comparator = new PassengerCapacityComparator_ASC();
                            SortedPlaneList.sort(comparator);
                        }
                        case ("вантажомісткість") -> {
                            comparator = new CargoCapacityComparator_ASC();
                            SortedPlaneList.sort(comparator);
                        }
                    }
                }


                PlaneListView.getItems().addAll(SortedPlaneList);
            }
        });
    }
}
