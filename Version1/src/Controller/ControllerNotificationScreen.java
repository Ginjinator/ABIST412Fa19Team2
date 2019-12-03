package Controller;

import Model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerNotificationScreen implements Initializable {

    @FXML private Button confirmButton;
    @FXML private Button cancelButton;
    @FXML private TextField emailField;
    @FXML private TextField phoneNumField;
    @FXML private CheckBox emailYesBox;
    @FXML private CheckBox phoneYesBox;
    @FXML private CheckBox noNotifyBox;

    @FXML
    private void setToMainMenu(ActionEvent event) throws IOException{
        // If user is professional
        if(true){
            Controller.loadScreen("MainScreenProfUser.fxml", event);
        } else {
            Controller.loadScreen("MainScreenUser.fxml", event);
        }
    }

    @FXML
    private void setNotifySettings(ActionEvent event) throws IOException{

    }

    @Override
    public void initialize (URL location, ResourceBundle resources){

    }

}
