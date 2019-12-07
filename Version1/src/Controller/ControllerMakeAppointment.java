package Controller;

import Model.Appointment;
import Model.ProfessionalUserData;
import Model.Schedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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
		System.out.println("User: " + ControllerMainEmpty.user);
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
		int doctor = this.doctor.getSelectionModel().getSelectedIndex();
		boolean matchFound = false;

		Schedule sched = new Schedule();
		Model.ProfessionalUserData profUser = new Model.ProfessionalUserData();

		ArrayList<Appointment> appointmentsForDoctor = profUser.getProfessionalUser(doctor).getAppointments();

		for (Appointment i : appointmentsForDoctor) {
			if ((i.getDate().equals(date)) && (i.getTime().equals(time) && i.getUser().getUsername().equals(ControllerMainEmpty.user.getUsername())))
				matchFound = true;
		}

		if (!matchFound) {
			Appointment appointment = new Appointment(time, date, ControllerMainEmpty.user);
			System.out.println("Appointment made for username " + ControllerMainEmpty.user.getUsername());
			profUser.getProfessionalUser(doctor).addAppointment(appointment);
			Controller.loadScreen("MainScreenUser.fxml", event);
		}

		if (matchFound) {
			Alert a = new Alert(Alert.AlertType.NONE);
			a.setContentText("You have selected an existing appointment. Please try again.");
			a.setAlertType(Alert.AlertType.ERROR);
			a.show();

		}
	}
}
