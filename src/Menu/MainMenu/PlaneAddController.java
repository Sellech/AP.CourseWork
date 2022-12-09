package Menu.MainMenu;

import java.net.URL;
import java.util.ResourceBundle;

import Airline.Plane;
import Database.DatabaseAction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PlaneAddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField CargoCapacityTextField;

    @FXML
    private Button CreatePlaneButton;

    @FXML
    private TextField FlyDistanceTextField;

    @FXML
    private TextField FuelConsumptionTextField;

    @FXML
    private Button GoBackButton;

    @FXML
    private TextField NameTextField;

    @FXML
    private TextField PassengerCapacityTextField;

    @FXML
    private TextField SideNumberTextField;

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

        // Додаємо функціонал кнопці CreatePlaneButton
        CreatePlaneButton.setOnAction(actionEvent -> {
            String PlaneName = NameTextField.getText(),
                    SideNumber = SideNumberTextField.getText(),
                    FlyDistanceStr = FlyDistanceTextField.getText(),
                    FuelConsumptionStr = FuelConsumptionTextField.getText(),
                    CargoCapacityStr = CargoCapacityTextField.getText(),
                    PassengerCapacityStr = PassengerCapacityTextField.getText();

            if (    ((((PlaneName.equals("") || SideNumber.equals(""))
                || FlyDistanceStr.equals("")) || FuelConsumptionStr.equals(""))
                    || CargoCapacityStr.equals("")) || PassengerCapacityStr.equals(""))
            {
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
                catch(java.io.IOException e){
                    e.printStackTrace();
                }
            }
            else{
                int FlyDistance = Integer.parseInt(FlyDistanceStr),
                        PassengerCapacity = Integer.parseInt(PassengerCapacityStr);

                double FuelConsumption = Double.parseDouble(FuelConsumptionStr),
                        CargoCapacity = Double.parseDouble(CargoCapacityStr);

                Plane plane = new Plane(PlaneName, SideNumber, FlyDistance,
                        FuelConsumption, PassengerCapacity, CargoCapacity, "00.00.0000");

                DatabaseAction action = new DatabaseAction();
                // Перевірка на наявність повторення бортового номера
                if (action.SideNumberDuplicateCheck(plane.getSideNumber())) {
                    action.PlaneAdd(plane);
                }
                else{
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
                    catch(java.io.IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}

