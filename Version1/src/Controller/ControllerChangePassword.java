package Controller;

import Model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
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

public class ControllerChangePassword implements Initializable {

	private User user = new User();
	@FXML
	private TextField oldPassword;
	@FXML
	private TextField newPassword;
	@FXML
	private PasswordField confirmPassword;
	@FXML
	private Button submitButton;
	@FXML
	private Button cancelButton;

	@FXML
	private void setToMainMenu(ActionEvent event) throws IOException {
		if (user.isProfessional()) {
			Controller.loadScreen("MainScreenProfUser.fxml", event);
		} else {
			Controller.loadScreen("MainScreenUser.fxml", event);
		}
	}

	@FXML
	private void submitNewPassword(ActionEvent event) throws IOException {

		if (!user.getPassword().isEmpty() || !oldPassword.getText().equals(user.getPassword())) {
			if (newPassword.getText().equals(confirmPassword.getText())) {
				user.setPassword(newPassword.getText());
			} else {
				newPassword.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
				confirmPassword.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		} else {
			oldPassword.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
