package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/*
	This class contains the unavailable schedule for a professional user.
	A schedule is a specified unavailable date and/or time. Time isn't necessary when only fetching date.
	unavailableSchedule includes specific dates and times.
	offDays includes WHOLE days off.
	Both are arraylists of schedule.

 */

public class ScheduleData implements Serializable {

	private ArrayList<Schedule> unavailableSchedule = new ArrayList<>();
	private ArrayList<Schedule> offDays = new ArrayList<>();

	public ScheduleData() {

	}

	/*
	 An unavailable day includes both a day and SPECIFIC time, such as a lunch time on March 4, 2020 or whatever.
	 When making for an appointment, it verifies that the person
	 did not schedule it on an off day AND an unavailable day/time.
	 So if a dialog for scheduling lunch during a day is created, it would use this function to add a lunch time.
	 */

	public void addUnavailableDay(LocalDate date, String time) {
		Schedule unavailable = new Schedule();
		unavailable.setTimeUnavailable(time);
		unavailable.setUnavailableDate(date);
		this.unavailableSchedule.add(unavailable);

	}

	/*
	 Off days include just the whole day, meaning they're not available for the WHOLE day, hence
	 the lacking of a time parameter. When making for an appointment, it verifies that the person
	 did not schedule it on an off day AND an unavailable day.
	 So, if a doctor is scheduling vacation and won't be in for the WHOLE day, they would use this function.
	 */
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
