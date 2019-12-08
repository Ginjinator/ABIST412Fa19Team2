package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ControllerApproveAppointment {
    @FXML private Button approveButton;
    @FXML private Button denyButton;
    @FXML private Button goBackButton;
    @FXML private ListView appointmentsList;

    @FXML
    public void intialize() throws IOException {

    }

    @FXML
    private void setApproveAppointment(ActionEvent event) throws IOException {
        //approve appointment
    }

    @FXML
    private void setDenyAppointment(ActionEvent event) throws IOException {

    }

    @FXML
    private void setMainScreen(ActionEvent event) throws IOException {
        Controller.loadScreen("MainScreenProfUser.fxml", event);
    }
}
