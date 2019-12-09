package Controller;

import Model.Appointment;
import Model.ProfessionalUser;
import Model.ProfessionalUserData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
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

        ProfessionalUser doc; //TODO Make this use the selected professional user
        System.out.println("User: " + ControllerMainEmpty.user);
        //times
        List<String> list = new ArrayList<>();
        doc = ControllerMainEmpty.profUser;
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
