package Controller;

import Model.User;
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

public class ControllerSignUp implements Initializable{
    @FXML private TextField tfFirstName;
    @FXML private TextField tfLastName;
    @FXML private TextField tfPSUEmail;
    @FXML private PasswordField pfSUPassword;
    @FXML private PasswordField pfSUPasswordConfirmation;
    @FXML private Button submitButton;

    //######################SIGNUP SCREEN###########################


    @FXML
    private void submitSignUp(ActionEvent event) throws IOException {
        //Special Character Verification & Screen Swap
        if(!Controller.hasSpecialChars(tfFirstName.getText()) && !Controller.hasSpecialChars(tfLastName.getText()) && !Controller.hasSpecialChars(tfPSUEmail.getText()) && !Controller.hasSpecialChars(pfSUPassword.getText())){

            //User creation and added to Database
            User user = new User(tfFirstName.getText(),tfLastName.getText(),tfPSUEmail.getText(),pfSUPassword.getText());
            Model.UserData userData = new Model.UserData();
            userData.addUser(user);

            //Screen Swap
            Controller.loadScreen("LoginScreen.fxml", event);
        }else{//Error FeedBack
            if(Controller.hasSpecialChars(tfFirstName.getText())){
                tfFirstName.setBackground(new Background(new BackgroundFill( Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            if(Controller.hasSpecialChars(tfLastName.getText())){
                tfLastName.setBackground(new Background(new BackgroundFill( Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            if(Controller.hasSpecialChars(tfPSUEmail.getText())){
                tfPSUEmail.setBackground(new Background(new BackgroundFill( Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            if(Controller.hasSpecialChars(pfSUPassword.getText())){
                pfSUPassword.setBackground(new Background(new BackgroundFill( Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }

            if(!pfSUPassword.getText().equals(pfSUPasswordConfirmation.getText())){
                pfSUPassword.setBackground(new Background(new BackgroundFill( Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                pfSUPasswordConfirmation.setBackground(new Background(new BackgroundFill( Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        }
    }

//    //######################All Main SCREEN###########################
//
//    @FXML
//    private void setToMainScreen(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(View.class.getResource("MainScreenEmpty.fxml"));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
