package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMainScreenProfUser implements Initializable{


    @FXML private VBox vBox;
    @FXML private ScrollPane scrollPane;

    @FXML
    private void setChangePasswordScreen(ActionEvent event) throws IOException {
        Controller.loadScreen("ChangePasswordScreen.fxml", event);
    }

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
            Logger.getLogger(ControllerMainScreenUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }

}