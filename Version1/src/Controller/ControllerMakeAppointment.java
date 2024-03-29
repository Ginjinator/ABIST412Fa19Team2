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
		List<String> list = new ArrayList<>();
		list.add("08:00"); // 8:00 AM
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
		Model.ProfessionalUserData profUser = new Model.ProfessionalUserData();
		List<String> doctors = profUser.getProfessionalUserDataNames();
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
		Model.UserData usrData = new Model.UserData();

		ArrayList<Appointment> appointmentsForDoctor = profUser.getProfessionalUser(doctor).getAppointments();
		ArrayList<Schedule> unAvailableSchedule = profUser.getProfessionalUser(doctor).getScheduleData().getUnavailableSchedule();
		ArrayList<Schedule> unavailableDays = profUser.getProfessionalUser(doctor).getScheduleData().getOffDays();

		for (Appointment i : appointmentsForDoctor) {
			if (((i.getDate().compareTo(date)) == 0) && (i.getTime().equals(time) && i.getUser().getUsername().equals(ControllerMainEmpty.user.getUsername())))
				matchFound = true;

			if (!matchFound) { //checks if match hasn't been found, since there is no point in executing the code since it will show an error anyway if match found

				for (Schedule u : unAvailableSchedule) {
					if ((i.getDate().compareTo(u.getUnavailableDate()) == 0) && (i.getTime().equals(u.getTimeUnavailable())))
						matchFound = true;
				}

				for (Schedule off : unavailableDays) {
					if ((i.getDate().compareTo(off.getUnavailableDate()) == 0))
						matchFound = true;
				}
			}
		}

		if (!matchFound) {
			Appointment appointment = new Appointment(time, date, ControllerMainEmpty.user, "Awaiting Approval");
			appointment.setProfUser(profUser.getProfessionalUser(doctor));
			appointment.setUser(ControllerMainEmpty.user);
			System.out.println("Appointment made for username " + ControllerMainEmpty.user.getUsername() + " with " + appointment.getProfUser().getFullName());
			//profUser.getProfessionalUser(doctor).addAppointment(appointment);
			profUser.addAppointment(doctor, appointment);
			usrData.addAppointment(appointment, ControllerMainEmpty.user);
			System.out.println("added an appointment:" + profUser.getProfessionalUser(doctor).getAppointments());
			Controller.loadScreen("MainScreenUser.fxml", event);
		}

		if (matchFound) {
			Alert a = new Alert(Alert.AlertType.NONE);
			a.setContentText("You have selected an existing appointment or an unavailable day or time. Please try again.");
			a.setAlertType(Alert.AlertType.ERROR);
			a.show();

		}
	}

	@FXML
	private void setMainMenu(ActionEvent event) throws IOException {
		Controller.loadScreen("MainScreenUser.fxml", event);
	}
}
