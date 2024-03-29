package Model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Random;

/*
	An appointment is created in the ControllerMakeAppointment class. These are added to the ProfessionalUser class
	and normal user class. Both user classes have methods to retrieve their appointments via arraylist. Appointments contain
	what user has the appointment, what professional user has the appointment, and the time and date.
 */

public class Appointment implements Serializable {
	private String time = "";
	private LocalDate date;
	private User user;
	private ProfessionalUser profUser;
	private String status = "";
	private BigInteger appointmentID;


	public Appointment(){

	}

	public Appointment(String time, LocalDate date, User user, String status) {
		this.time = time;
		this.date = date;
		this.user = user;
		this.status = status;
		this.appointmentID = new BigInteger(256, new Random());
	}

	public BigInteger getAppointmentID(){
		return this.appointmentID;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ProfessionalUser getProfUser() {
		return this.profUser;
	}

	public void setProfUser(ProfessionalUser profUser) {
		this.profUser = profUser;
	}

	public String getStatus() { return this.status; }

	public void setStatus(String status) { this.status = status; }
}
