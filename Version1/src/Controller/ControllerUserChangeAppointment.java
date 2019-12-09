package Controller;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerUserChangeAppointment {
	@FXML
	private Button approveButton;
	@FXML private Button denyButton;
	@FXML private Button goBackButton;
	@FXML private ListView appointmentsList;
	private ArrayList<Appointment> appointments = new ArrayList<>();
	private Appointment selectedAppointment; //TODO make highlighted appointment in window



	public void initialize() {
		// Get correct professional user

		User usr;
		System.out.println("User: " + ControllerMainEmpty.user);
		//times
		List<String> list = new ArrayList<>();
		usr = ControllerMainEmpty.user;
		appointments = usr.getAppointments();
		System.out.println("Signed in as: " + usr.getFullName());
		System.out.println(list);
		for(Appointment a: appointments){
			list.add(a.getUser().getFullName());
			System.out.println(a.getUser().getFullName());
		}
		System.out.println(list);
		ObservableList obList = FXCollections.observableList(list);
		System.out.println("Observable list:" + obList);
		this.appointmentsList.setItems(obList);
		this.appointmentsList.setVisible(true);
		System.out.println("List View Items: " + appointmentsList.getItems());




	}

	@FXML
	private void setDeleteAppointment(ActionEvent event) throws IOException {
		User usr;
		usr = ControllerMainEmpty.user;
		appointments = usr.getAppointments();
		selectedAppointment = appointments.get(appointmentsList.getSelectionModel().getSelectedIndex());
		ProfessionalUser docUsr = selectedAppointment.getProfUser();
		ProfessionalUserData profUsrData = new ProfessionalUserData();
		UserData usrData = new UserData();

		profUsrData.removeAppointment( selectedAppointment,profUsrData.searchUsersData(docUsr.getUsername()));
		usrData.removeAppointment(selectedAppointment, usrData.searchUsersData(ControllerMainEmpty.user.getUsername()));
		usrData.searchUsersData(ControllerMainEmpty.user.getUsername()).deleteAppointment(selectedAppointment);


	}

	@FXML
	private void setChangeAppointment(ActionEvent event) throws IOException {
		ProfessionalUser doc;
		doc = ControllerMainEmpty.profUser;
		appointments = doc.getAppointments();
		selectedAppointment = appointments.get(appointmentsList.getSelectionModel().getSelectedIndex());
		ProfessionalUserData profUsers = new ProfessionalUserData();
		profUsers.removeAppointment(appointmentsList.getSelectionModel().getSelectedIndex(), doc);
		selectedAppointment.setStatus("Denied");
		appointments = doc.getAppointments();
		ArrayList<String> list = new ArrayList<>();
		if(appointments.size()!=0)
			for(Appointment a: appointments){
				list.add(a.getUser().getFullName());
				System.out.println(a.getUser().getFullName());
			}
		else {
			list.clear();
		}
		ObservableList obList = FXCollections.observableList(list);
		System.out.println("Observable list:" + obList);
		this.appointmentsList.setItems(obList);
	}

	@FXML
	private void setMainScreen(ActionEvent event) throws IOException {
		Controller.loadScreen("MainScreenUser.fxml", event);
	}


}
