package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ControllerCheckAppointment {

	@FXML
	private TextArea appointmentArea;
	@FXML
	private TextArea statusArea;
	@FXML
	private Button back;

	@FXML
	private void setLastScreen(ActionEvent event) throws IOException {
		Controller.loadScreen("MainScreenUser.fxml", event);
	}

	@FXML
	private void setArea(ActionEvent event) throws IOException {

	}
}
