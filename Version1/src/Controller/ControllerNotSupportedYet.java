package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ControllerNotSupportedYet {
	@FXML
	private Button mainMenu;

	@FXML
	private void setMainMenu(ActionEvent event) throws IOException {
		Controller.loadScreen("MainScreenUser.fxml", event);
	}
}
