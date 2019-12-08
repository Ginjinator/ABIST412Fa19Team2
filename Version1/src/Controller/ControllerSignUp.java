package Controller;
import Model.UserData;
import Model.ProfessionalUser;
import Model.ProfessionalUserData;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerSignUp {
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField usernameField;
	@FXML
	private TextField phoneNumField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private PasswordField passwordConfirmationField;
	@FXML
	private Button submitButton;
	@FXML
	private ChoiceBox professionalUser;
	//######################SIGNUP SCREEN###########################

	@FXML
	private void submitSignUp(ActionEvent event) throws IOException {
		//Special Character Verification & Screen Swap

		if (!Controller.hasSpecialChars(firstNameField.getText()) && !Controller.hasSpecialChars(lastNameField.getText()) && !Controller.hasSpecialChars(usernameField.getText()) && !Controller.hasSpecialChars(passwordField.getText()) && !Controller.hasSpecialChars(phoneNumField.getText())) {
			int selectedIndex = professionalUser.getSelectionModel().getSelectedIndex();
			if (selectedIndex == 0) {
				//User creation and added to Database
				User user = new User(firstNameField.getText(), lastNameField.getText(), usernameField.getText(), passwordField.getText(), phoneNumField.getText());
				Model.UserData userData = new Model.UserData();
				userData.read();
				userData.addUser(user);
				userData.write();

				System.out.println("Added a regular user");
			}

			if (selectedIndex == 1) {
				//PROFESSIONAL creation and added to Database
				ProfessionalUser user = new ProfessionalUser(firstNameField.getText(), lastNameField.getText(), usernameField.getText(), passwordField.getText());
				Model.ProfessionalUserData profUserData = new Model.ProfessionalUserData();
				profUserData.addUser(user);
				System.out.println("Added a professional user");

			}
			//Screen Swap
			Controller.loadScreen("LoginScreen.fxml", event);
		} else {//Error FeedBack
			if (Controller.hasSpecialChars(firstNameField.getText())) {
				firstNameField.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
			}
			if (Controller.hasSpecialChars(lastNameField.getText())) {
				lastNameField.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
			}
			if (Controller.hasSpecialChars(usernameField.getText())) {
				usernameField.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
			}
			if (Controller.hasSpecialChars(passwordField.getText())) {
				passwordField.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
			}

			if (!passwordField.getText().equals(passwordConfirmationField.getText())) {
				passwordField.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
				passwordConfirmationField.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		}
	}

//    //######################All Main SCREEN###########################
//
//    @FXML
//    private void setToMainScreen(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(View.class.getResource("MainScreenEmpty.fxml"));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }

	public void initialize() {
		List<String> list = new ArrayList<String>();
		list.add("User");
		list.add("Doctor");
		ObservableList obList = FXCollections.observableList(list);
		this.professionalUser.setItems(obList);
		this.professionalUser.getSelectionModel().selectFirst();
	}

}
