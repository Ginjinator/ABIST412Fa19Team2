package Controller;

import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMainScreenUser implements Initializable {


	@FXML
	private VBox vBox;
	@FXML
	private ScrollPane scrollPane;
	@FXML
	private Button changePassword;
	@FXML
	private Button makeAppointment;
	@FXML
	private Button changeAppointment;
	@FXML
	private Button checkStatus;
	@FXML
	private Button editProfile;
	@FXML
	private Button signOutButton;

	public static User user = new User();

	@FXML
	private void setToSignedOut(ActionEvent event) throws IOException {
		ControllerMainEmpty.user = new User();
		Controller.loadScreen("LoginScreen.fxml", event);
	}

	@FXML
	private void setToChangeAppt(ActionEvent event) throws IOException {
		Controller.loadScreen("UserChangeAppointment.fxml", event);
	}


	@FXML
	private void setChangePasswordScreen(ActionEvent event) throws IOException {
		Controller.loadScreen("ChangePasswordScreen.fxml", event);
	}

	@FXML
	private void setMakeAppointmentScreen(ActionEvent event) throws IOException {
		Controller.loadScreen("MainOpenAppointments.fxml", event);
	}

	@FXML
	private void setNotSupported(ActionEvent event) throws IOException {
		Controller.loadScreen("FeatureNotSupportedYet.fxml", event);
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