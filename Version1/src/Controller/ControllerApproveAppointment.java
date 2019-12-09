package Controller;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

public class ControllerApproveAppointment {
    @FXML private Button approveButton;
    @FXML private Button denyButton;
    @FXML private Button goBackButton;
    @FXML private ListView appointmentsList;
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private Appointment selectedAppointment; //TODO make highlighted appointment in window



    public void initialize() {
        // Get correct professional user
       ProfessionalUserData profUsers = new ProfessionalUserData();
        ProfessionalUser doc; //TODO Make this use the selected professional user
        System.out.println("User: " + ControllerMainEmpty.user);
        //times
        List<String> list = new ArrayList<>();
        doc = profUsers.searchUsersData(ControllerMainEmpty.profUser.getUsername());
        appointments = doc.getAppointments();
        System.out.println("Signed in as: " + doc.getFullName());
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
    private void setApproveAppointment(ActionEvent event) throws IOException {
        ProfessionalUser doc;
        ProfessionalUserData profUsers = new ProfessionalUserData();
        UserData usrData = new UserData();

        doc = profUsers.searchUsersData(ControllerMainEmpty.profUser.getUsername());
        appointments = doc.getAppointments();
        selectedAppointment = appointments.get(appointmentsList.getSelectionModel().getSelectedIndex());
        selectedAppointment.setStatus("Approved");
        User usr = usrData.searchUsersData(selectedAppointment.getUser().getUsername());
        usrData.searchUsersData(ControllerMainEmpty.user.getUsername()).findAppointment(selectedAppointment).setStatus("Approved");
        initialize();
    }

    @FXML
    private void setDenyAppointment(ActionEvent event) throws IOException {
        ProfessionalUser doc;
        ProfessionalUserData profUsers = new ProfessionalUserData();
        UserData usrData = new UserData();

        doc = profUsers.searchUsersData(ControllerMainEmpty.profUser.getUsername());
        appointments = doc.getAppointments();
        selectedAppointment = appointments.get(appointmentsList.getSelectionModel().getSelectedIndex());
        User usr = usrData.searchUsersData(selectedAppointment.getUser().getUsername());
        profUsers.removeAppointment(selectedAppointment, ControllerMainEmpty.profUser);
        usrData.removeAppointment(selectedAppointment, selectedAppointment.getUser());
        usr.deleteAppointment(selectedAppointment);
        selectedAppointment.setStatus("Denied");
        appointments = doc.getAppointments();
        ArrayList<String> list = new ArrayList<>();
        if(appointments.size()!=0)
        for(Appointment a: appointments){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
            String formattedString = a.getDate().format(formatter);
            list.add(a.getProfUser().getFullName() +" " + formattedString +" " + a.getTime());

            System.out.println(a.getUser().getFullName());
        }
        else {
            list.clear();
        }
        ObservableList obList = FXCollections.observableList(list);
        System.out.println("Observable list:" + obList);
        this.appointmentsList.setItems(obList);
        initialize();
    }

    @FXML
    private void setMainScreen(ActionEvent event) throws IOException {
        Controller.loadScreen("MainScreenProfUser.fxml", event);
    }
}
