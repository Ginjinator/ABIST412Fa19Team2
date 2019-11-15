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

public class ControllerSubScreen implements Initializable{


    @FXML private VBox vBox;
    @FXML private ScrollPane scrollPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        try {
            vBox.getChildren().clear();
            for(int i = 0 ; i < ControllerMainEmpty.user.getUserGroups().size(); i++){
                ControllerMainEmpty.studyGroup = ControllerMainEmpty.user.getUserGroups().get(i);
                vBox.getChildren().add(FXMLLoader.load(View.class.getResource("StudyGroupCard.fxml")));
            }
        } catch (IOException ex) {
            Logger.getLogger(ControllerSubScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }

}
