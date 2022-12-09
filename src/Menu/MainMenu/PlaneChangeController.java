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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PlaneChangeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField CargoCapacityTextField;

    @FXML
    private TextField DiagnosticTextField;
    @FXML
    private Button ChangePlaneButton;

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
    private ListView<Plane> PlaneListView;

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

        // Додаємо функціонал ListView
        DatabaseAction action = new DatabaseAction();
        PlaneListView.getItems().addAll(action.GetPlaneList());

        PlaneListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Plane>() {
            @Override
            public void changed(ObservableValue<? extends Plane> observableValue, Plane plane, Plane t1) {

                // Додаємо функціонал кнопці ChangePlaneButton
                ChangePlaneButton.setOnAction(actionEvent -> {
                    String PlaneName = NameTextField.getText(),
                            SideNumber = SideNumberTextField.getText(),
                            FlyDistanceStr = FlyDistanceTextField.getText(),
                            FuelConsumptionStr = FuelConsumptionTextField.getText(),
                            CargoCapacityStr = CargoCapacityTextField.getText(),
                            PassengerCapacityStr = PassengerCapacityTextField.getText(),
                            LastDiagnosticDate = DiagnosticTextField.getText();


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

                        Plane ChosenPlane = new Plane(PlaneName, SideNumber, FlyDistance,
                                FuelConsumption, PassengerCapacity, CargoCapacity, LastDiagnosticDate);
                        Plane RemovablePlane = PlaneListView.getSelectionModel().getSelectedItem();

                        DatabaseAction action = new DatabaseAction();
                        // Перевірка на наявність повторення бортового номера
                        if (action.SideNumberDuplicateCheck(ChosenPlane.getSideNumber())) {
                            action.PlaneChange(RemovablePlane, ChosenPlane);

                            // Повертаємось назад в меню1
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
        });
    }
}

