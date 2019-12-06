package Controller;

import Model.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable{

    @FXML private Button loginButton;
    @FXML private Button signupButton;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    //######################LOGIN SCREEN###########################

    @FXML
    private void setToSignUpScreen(ActionEvent event) throws IOException {
        Controller.loadScreen("SignUpScreen.fxml", event);
    }

    @FXML
    private void authenticate(ActionEvent event) throws IOException {
        Model.UserData userData = new UserData();
//        Model.StudyGroupData studyGroupData = new StudyGroupData();

        if (!userData.searchUsersData(usernameField.getText()).getUsername().isEmpty() && userData.searchUsersData(usernameField.getText()).getUsername().equals(usernameField.getText()) && userData.searchUsersData(usernameField.getText()).getPassword().equals(passwordField.getText())){
            //Checks if user is blank, then checks if username and password match to database
            Controller.loadScreen("MainScreenUser.fxml", event);
            ControllerMainEmpty.user = userData.searchUsersData(usernameField.getText());

        }else{
            usernameField.setBackground(new Background(new BackgroundFill( Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            passwordField.setBackground(new Background(new BackgroundFill( Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

