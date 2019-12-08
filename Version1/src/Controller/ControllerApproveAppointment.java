package Controller;

import Model.Appointment;
import Model.ProfessionalUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.io.IOException;

public class ControllerApproveAppointment {
    @FXML private Button approveButton;
    @FXML private Button denyButton;
    @FXML private Button goBackButton;
    @FXML private ListView appointmentsList;
    private ArrayList<Appointment> appointments;
    private Appointment selectedAppointment; //TODO make highlighted appointment in window


    @FXML
    public void intialize() throws IOException {
        // Get correct professional user
        ProfessionalUser doc = new ProfessionalUser(); //TODO Make this use the selected professional user

        appointments = doc.getAppointments();

    }

    @FXML
    private void setApproveAppointment(ActionEvent event) throws IOException {
        selectedAppointment.setStatus("Approved");
    }

    @FXML
    private void setDenyAppointment(ActionEvent event) throws IOException {
        selectedAppointment.setStatus("Denied");
    }

    @FXML
    private void setMainScreen(ActionEvent event) throws IOException {
        Controller.loadScreen("MainScreenProfUser.fxml", event);
    }
}
