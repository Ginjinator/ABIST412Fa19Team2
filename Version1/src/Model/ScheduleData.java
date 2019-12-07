package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/*
	This class contains the unavailable schedule for a professional user.
	A schedule is a specified unavailable date and time.
	unavailableSchedule includes specific dates and times.
	offDays includes WHOLE days off.
	Both are arraylists of schedule.

 */

public class ScheduleData implements Serializable {

	private ArrayList<Schedule> unavailableSchedule = new ArrayList<>();
	private ArrayList<Schedule> offDays = new ArrayList<>();

	public ScheduleData() {

	}

	public void addUnavailableDay(LocalDate date, String time) {
		Schedule unavailable = new Schedule();
		unavailable.setTimeUnavailable(time);
		unavailable.setUnavailableDate(date);
		this.unavailableSchedule.add(unavailable);

	}

	public void addOffDay(LocalDate date) {
		Schedule unavailable = new Schedule();
		unavailable.setUnavailableDate(date);
		this.offDays.add(unavailable);
	}

	public ArrayList<Schedule> getOffDays() {
		return this.offDays;
	}

	public ArrayList<Schedule> getUnavailableSchedule() {
		return this.unavailableSchedule;
	}


}
