package Menu.MainMenu;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Airline.Plane;
import Database.DatabaseAction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SummaryPlaneListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label CargoSumLabel;

    @FXML
    private Label FuelSumLabel;

    @FXML
    private Button GoBackButton;

    @FXML
    private Label PassengerSumLabel;

    @FXML
    private Label PlaneCountLabel;

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

        // Додаємо функціональність полям Label
        DatabaseAction action = new DatabaseAction();
        ArrayList<Plane> PlaneList = action.GetPlaneList();

        // додаємо функціональність полям Label
        PlaneCountLabel.setText("" + PlaneList.size());

        int PassengerSum = 0;
        double FuelSum = 0, CargoSum = 0;

        for(int i=0; i<PlaneList.size();i++){
            CargoSum += PlaneList.get(i).getCargoCapacity();
            PassengerSum += PlaneList.get(i).getPassengerCapacity();
            FuelSum += PlaneList.get(i).getFuelConsumption();
        }

        CargoSumLabel.setText("" +  CargoSum);
        PassengerSumLabel.setText("" +  PassengerSum);
        FuelSumLabel.setText("" +  FuelSum);
    }
}

