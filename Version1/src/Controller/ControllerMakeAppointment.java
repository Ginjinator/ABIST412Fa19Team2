package Controller;

import Model.ProfessionalUserData;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerMakeAppointment {

	@FXML
	private ChoiceBox doctor;
	@FXML
	private DatePicker datePicker;
	@FXML
	private ChoiceBox choice;
	@FXML
	Button button;

	@FXML
	private void setDate(ActionEvent event) throws IOException {

	}


	public void initialize() {
		//times
		List<String> list = new ArrayList<String>();
		list.add("08:00");
		list.add("08:30");
		list.add("09:00");
		list.add("09:30");
		list.add("10:00");
		list.add("10:30");
		list.add("11:00");
		list.add("11:30");
		//start pm times
		list.add("12:00");
		list.add("12:30");
		list.add("13:00");
		list.add("13:30");
		list.add("14:00");
		list.add("14:30");
		list.add("15:00");
		list.add("15:30");
		list.add("16:00");
		list.add("16:30");
		list.add("17:00");
		list.add("17:30");
		list.add("18:00");
		list.add("18:30");
		list.add("19:00");
		list.add("19:30"); //7:30 pm
		ObservableList obList = FXCollections.observableList(list);
		this.choice.setItems(obList);
		this.choice.getSelectionModel().selectFirst();
		//doctors
		List<String> doctors = ProfessionalUserData.getProfessionalUserDataNames();
		obList = FXCollections.observableList(doctors);
		this.doctor.setItems(obList);
		this.doctor.getSelectionModel().selectFirst();

	}

	@FXML
	private void setAppointmentButton(ActionEvent event) throws IOException {
		String time = this.choice.getSelectionModel().getSelectedItem().toString();
		LocalDate date = datePicker.getValue();
		String doctor = this.doctor.getSelectionModel().getSelectedItem().toString();
		Controller.loadScreen("MainScreenUser.fxml", event);
	}
}
