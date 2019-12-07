package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Appointment implements Serializable {
	private String time = "";
	private LocalDate date;
	private User user;
	private ProfessionalUser profUser;

	public Appointment(String time, LocalDate date, User user) {
		this.time = time;
		this.date = date;
		this.user = user;
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
}
