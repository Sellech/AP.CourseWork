package Menu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AirlineInfoButton;

    @FXML
    private Button ExitButton;

    @FXML
    private Button PlaneAddButton;

    @FXML
    private Button PlaneChangeButton;

    @FXML
    private Button PlaneDeleteButton;

    @FXML
    private Button PlaneInfoButton;

    @FXML
    private Button PlaneListButton;

    @FXML
    private Button RangePlaneListButton;

    @FXML
    private Button SortPlaneListButton;

    @FXML
    private Button SummaryPlaneListButton;

    @FXML
    void initialize() {

        // Додаємо функціонал кнопці Exit
        ExitButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) ExitButton.getScene().getWindow();
            stage.close();
        });

        // Додаємо функціонал кнопці PlaneListButton
        PlaneListButton.setOnAction(actionEvent -> {
            try{
                Parent root = FXMLLoader.load(getClass().getResource("MainMenu/PlaneList.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) PlaneListButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            catch(java.io.IOException e){
                e.printStackTrace();
            }
        });

        // Додаємо функціонал кнопці AirlineInfoButton
        AirlineInfoButton.setOnAction(actionEvent -> {
            try{
                Parent root = FXMLLoader.load(getClass().getResource("MainMenu/AirlineInfo.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) PlaneListButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            catch(java.io.IOException e){
                e.printStackTrace();
            }
        });

        // Додаємо функціонал кнопці PlaneAddButton
        PlaneAddButton.setOnAction(actionEvent -> {
            try{
                Parent root = FXMLLoader.load(getClass().getResource("MainMenu/PlaneAdd.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) PlaneListButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            catch(java.io.IOException e){
                e.printStackTrace();
            }
        });

        // Додаємо функціонал кнопці PlaneChangeButton
        PlaneChangeButton.setOnAction(actionEvent -> {
            try{
                Parent root = FXMLLoader.load(getClass().getResource("MainMenu/PlaneChange.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) PlaneChangeButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            catch(java.io.IOException e){
                e.printStackTrace();
            }
        });

        // Додаємо функціонал кнопці PlaneInfoButton
        PlaneInfoButton.setOnAction(actionEvent -> {
            try{
                Parent root = FXMLLoader.load(getClass().getResource("MainMenu/PlaneInfo.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) PlaneChangeButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            catch(java.io.IOException e){
                e.printStackTrace();
            }
        });

        // Додаємо функціонал кнопці PlaneDeleteButton
        PlaneDeleteButton.setOnAction(actionEvent -> {
            try{
                Parent root = FXMLLoader.load(getClass().getResource("MainMenu/PlaneDelete.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) PlaneChangeButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            catch(java.io.IOException e){
                e.printStackTrace();
            }
        });

        // Додаємо функціонал кнопці RangePlaneListButton
        RangePlaneListButton.setOnAction(actionEvent -> {
            try{
                Parent root = FXMLLoader.load(getClass().getResource("MainMenu/RangePlaneList.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) PlaneChangeButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            catch(java.io.IOException e){
                e.printStackTrace();
            }
        });


    }
}

