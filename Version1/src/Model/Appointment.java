package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Appointment implements Serializable {
	private String time = "";
	private LocalDate date;
	private User user;

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


}
