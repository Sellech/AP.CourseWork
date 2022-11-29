package Menu.StartMenu;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StartMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AirlineNameField;

    @FXML
    private Button CreateAirlineButton;

    @FXML
    private Button ExitButton;

    @FXML
    private Button HelpButton;

    @FXML
    private Button InfoButton;

    @FXML
    void initialize() throws Exception {

        // Додаємо функціонал кнопці Exit
        ExitButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) ExitButton.getScene().getWindow();
            stage.close();
        });

        // Додаємо функціонал кнопці Info
        InfoButton.setOnAction(actionEvent -> {
            try{
                Parent root = FXMLLoader.load(getClass().getResource("Info.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setTitle("Program Information");
                stage.getIcons().add(new Image(getClass().getResourceAsStream("QuestionMark.png")));
                stage.setWidth(346);
                stage.setHeight(200);

                stage.setScene(scene);
                stage.show();
            }
            catch(java.io.IOException e){
                e.printStackTrace();
            }
        });

        // Додаємо функціонал кнопці Help
        HelpButton.setOnAction(actionEvent -> {
            try{
                Parent root = FXMLLoader.load(getClass().getResource("Help.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setTitle("Help");
                stage.getIcons().add(new Image(getClass().getResourceAsStream("QuestionMark.png")));
                stage.setWidth(346);
                stage.setHeight(200);
                stage.setScene(scene);
                stage.show();
            }
            catch(java.io.IOException e){
                e.printStackTrace();
            }
        });



        // Додаємо функціонал кнопці Create Airline
        CreateAirlineButton.setOnAction(actionEvent -> {

            String AirlineName = AirlineNameField.getText();
            if(AirlineName.equals("")){ // Якщо користувач нічого не ввів
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

            }
        });
    }

}

