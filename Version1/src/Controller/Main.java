package Controller;

import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Controller.loadScreen("LoginScreen.fxml", stage);
    }

    public static void main(String[] args) {
        DateDialog s = new DateDialog("test");
        s.setVisible(true);
        launch(args);
    }

}