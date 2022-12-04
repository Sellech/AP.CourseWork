package Menu;

import Airline.Airline;
import Database.DatabaseAction;
import javafx.application.*;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.event.*;

public class Menu extends Application {

    public void runMenu () {
        launch();
    }

    @Override
    public void init() throws Exception {
        System.out.println("Application init!");
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("StartMenu/StartMenu.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Airline App v. 1.0");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        DatabaseAction action = new DatabaseAction();
        action.DeleteAirline();
        System.out.println("Application stop!");
        super.stop();
    }
}
