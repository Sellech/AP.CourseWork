package Menu.MainMenu;

import java.io.IOException;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RangePlaneListController {

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
    private TextField maxTextField;

    @FXML
    private TextField minTextField;

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
        ParameterChoiceBox.getItems().addAll(options);

        // Додаємо функціонал кнопці OutputButton
        OutputButton.setOnAction(actionEvent -> {

            String minStr = minTextField.getText();
            String maxStr = maxTextField.getText();

            // якщо користувач не обрав значення
            if((minStr.equals("") || maxStr.equals(""))||ParameterChoiceBox.getValue().equals("")) {
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
                try{
                    PlaneListView.getItems().clear();

                    DatabaseAction action = new DatabaseAction();
                    ArrayList<Plane> RangePlaneList = action.GetPlaneList();
                    ArrayList<Plane> FinalPlaneList = new ArrayList<>();
                    switch (ParameterChoiceBox.getValue()){

                        case("дальність польоту") -> {
                            int min = Integer.parseInt(minStr);
                            int max = Integer.parseInt(maxStr);

                            for(int i=0;i<RangePlaneList.size(); i++){
                                if(RangePlaneList.get(i).getFlyDistance() < min ||
                                        RangePlaneList.get(i).getFlyDistance() > max) {
                                    FinalPlaneList.add(RangePlaneList.get(i));
                                }
                            }
                        }

                        case("споживання палива") -> {
                            double min = Double.parseDouble(minStr);
                            double max = Double.parseDouble(maxStr);

                            for(int i=0;i<RangePlaneList.size(); i++){
                                if(RangePlaneList.get(i).getFuelConsumption() < min ||
                                        RangePlaneList.get(i).getFuelConsumption() > max) {
                                    FinalPlaneList.add(RangePlaneList.get(i));
                                }
                            }
                        }

                        case("пасажиромісткість") -> {
                            int min = Integer.parseInt(minStr);
                            int max = Integer.parseInt(maxStr);

                            for(int i=0;i<RangePlaneList.size(); i++){
                                if(RangePlaneList.get(i).getPassengerCapacity() < min ||
                                        RangePlaneList.get(i).getPassengerCapacity() > max) {
                                    FinalPlaneList.add(RangePlaneList.get(i));
                                }
                            }
                        }

                        case("вантажомісткість") -> {
                            double min = Double.parseDouble(minStr);
                            double max = Double.parseDouble(maxStr);

                            for(int i=0;i<RangePlaneList.size(); i++){
                                if(RangePlaneList.get(i).getCargoCapacity() < min ||
                                        RangePlaneList.get(i).getCargoCapacity() > max) {
                                    FinalPlaneList.add(RangePlaneList.get(i));
                                }
                            }
                        }

                    }
                    PlaneListView.getItems().addAll(FinalPlaneList);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}