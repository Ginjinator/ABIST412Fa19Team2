package Controller;

import View.View;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerMainScreen implements Initializable{


    @FXML private VBox vBox;
    @FXML private ScrollPane scrollPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        try {
//            vBox.getChildren().clear();
            for(int i = 0; i < ControllerMainEmpty.studyGroupData.getStudyGroupData().size(); i++){
                ControllerMainEmpty.studyGroup = ControllerMainEmpty.studyGroupData.getStudyGroupData().get(i);
                vBox.getChildren().add(FXMLLoader.load(View.class.getResource("StudyGroupCard.fxml")));
            }
        } catch (IOException ex) {
            Logger.getLogger(ControllerMainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }

}