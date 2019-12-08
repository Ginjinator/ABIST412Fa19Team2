package Model;

import java.io.Serializable;
import java.time.LocalDate;

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

	public Appointment(String time, LocalDate date, User user, String status) {
		this.time = time;
		this.date = date;
		this.user = user;
		this.status = status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ProfessionalUser getProfUser() {
		return profUser;
	}

	public void setProfUser(ProfessionalUser profUser) {
		this.profUser = profUser;
	}

	public String getStatus() { return status; }

	public void setStatus(String status) { this.status = status; }
}
