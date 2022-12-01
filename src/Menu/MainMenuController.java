package Menu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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



    }
}

