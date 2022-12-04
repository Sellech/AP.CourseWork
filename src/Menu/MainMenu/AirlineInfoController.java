package Menu.MainMenu;

        import java.net.URL;
        import java.util.ResourceBundle;
        import java.util.ArrayList;
        import Airline.Plane;
        import Database.DatabaseAction;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.stage.Stage;

public class AirlineInfoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label AirlineNameLabel;

    @FXML
    private Label CargoPlaneCountLabel;

    @FXML
    private Button GoBackButton;

    @FXML
    private Label PassengerPlaneCountLabel;

    @FXML
    private Label PlaneCountLabel;

    @FXML
    private Label UniversalPlaneCountLabel;

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

        AirlineNameLabel.setText(action.GetAirlineName());
        PlaneCountLabel.setText("" + PlaneList.size());

        int CargoPlaneCounter = 0, PassengerPlaneCounter = 0, UniversalPlaneCounter = 0;

        for(int i=0; i<PlaneList.size();i++){

            if((PlaneList.get(i).getCargoCapacity() > 0)
                    &&(PlaneList.get(i).getPassengerCapacity() == 0))
                CargoPlaneCounter++;

            else if ((PlaneList.get(i).getPassengerCapacity() > 0)
                    &&(PlaneList.get(i).getCargoCapacity() == 0))
                PassengerPlaneCounter++;

            else
                UniversalPlaneCounter++;
        }
        CargoPlaneCountLabel.setText("" + CargoPlaneCounter);
        PassengerPlaneCountLabel.setText("" + PassengerPlaneCounter);
        UniversalPlaneCountLabel.setText("" + UniversalPlaneCounter);
    }
}
