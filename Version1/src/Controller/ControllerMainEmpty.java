package Controller;

import Model.User;
import View.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerMainEmpty implements Initializable{

    @FXML private Button homeButtton;
    @FXML private Button subButton;
    @FXML private Button detailedButton;
    @FXML private Button formButton;
    @FXML private Label currentScreen;
    @FXML private  BorderPane borderPane;

    private static BorderPane borderPane2;

    public static User user = new User();
    public static Boolean isStudyDetailNext = false;

    @FXML//SGC = StudyGroupCard
    private void loadScreenSGC(ActionEvent event) throws IOException {
        borderPane.setCenter(FXMLLoader.load(View.class.getResource("StudyGroupCard.fxml")));
    }

    @FXML//SGD = StudyGroupSearch
    private void loadScreenSGS(ActionEvent event) throws IOException {
        Controller.loadScreen("StudyGroupSearch.fxml",event);
    }

    @FXML//Home Screen
    private void loadScreenHome() throws IOException {
        borderPane.setCenter(FXMLLoader.load(View.class.getResource("MainScreen.fxml")));
        currentScreen.setText("Main Screen");
    }

    @FXML//Home Screen
    public  void loadScreenSGD() throws IOException {
        borderPane.setCenter(FXMLLoader.load(View.class.getResource("StudyGroupDetailedView.fxml")));
        currentScreen.setText("Study Group Details");
    }



    @FXML//Home Screen
    private void loadScreenHome(ActionEvent event) throws IOException {
        borderPane.setCenter(FXMLLoader.load(View.class.getResource("MainScreen.fxml")));
        currentScreen.setText("Main Screen");
    }

    @FXML//SS = SubScreen/Subscription screen
    private void loadScreenSS(ActionEvent event) throws IOException {
//        Controller.loadScreen("MainScreenEmpty.fxml",event);
        borderPane.setCenter(FXMLLoader.load(View.class.getResource("SubScreen.fxml")));
        currentScreen.setText("Favorites");
    }

    @FXML
    private void loadScreenSGD(ActionEvent event) throws IOException {
        borderPane.setCenter(FXMLLoader.load(View.class.getResource("StudyGroupDetailedView.fxml")));
        currentScreen.setText("Study Group Details");
    }

    @FXML//SGD = StudyGroupForm
    private void loadScreenSGF(ActionEvent event) throws IOException {
        borderPane.setCenter(FXMLLoader.load(View.class.getResource("StudyGroupForm.fxml")));
        currentScreen.setText("Create Study Group");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentScreen.setText("Main Screen");
        try {
            //Make a better code instead of edge case
            if(!isStudyDetailNext){
                loadScreenHome();
            }else{

                isStudyDetailNext = false;
//                loadScreenSGD();
            }

        } catch (IOException ex) {
            Logger.getLogger(ControllerMainEmpty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
