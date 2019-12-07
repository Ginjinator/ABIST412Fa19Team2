package Controller;

import Model.ProfessionalUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMainScreenProfUser implements Initializable {


	@FXML
	private VBox vBox;
	@FXML
	private ScrollPane scrollPane;
	@FXML
	private Button seeRequests;
	@FXML
	private Button cancelAppointments;
	@FXML
	private Button editProfile;
	@FXML
	private Button changePassword;
	@FXML
	private Button changeAvailability;
	@FXML
	private Button signOutButton;


	@FXML
	private void setToSignedOut(ActionEvent event) throws IOException {
		ControllerMainEmpty.profUser = new ProfessionalUser();
		Controller.loadScreen("ControllerLogin.fxml", event);

	}

	@FXML
	private void setChangePasswordScreen(ActionEvent event) throws IOException {
		Controller.loadScreen("ChangePasswordScreen.fxml", event);
	}

	@FXML
	private void setNotSupportedYet(ActionEvent event) throws IOException {
		Controller.loadScreen("FeatureNotSupportedYet.fxml", event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}