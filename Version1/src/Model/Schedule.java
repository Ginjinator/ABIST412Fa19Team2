package Model;

import java.io.Serializable;
import java.time.LocalDate;
/*
This is an object used in the "ScheduleDate" class. The "ScheduleData" class stores this object in TWO arraylists: unAvailableSchedule
and offDays. In offDays, only the date parameter is used because offDays include the whole day and the make appointment controller only
checks for the date in the offDays arraylist. In the unAvailableSchedule arraylist, the make appointment controller checks BOTH DATE AND TIME.

Schedule includes the ability to add only a time and date to itself. See parameters. The "Appointment" class is similar but a lot more detailed.
 */


/**
 * Used to save a users available time and vacation/time off
 */

public class Schedule implements Serializable {

    // Work hours
    //   private String timeAvailable;
    // Lunch and after hours
    private String timeUnavailable;
    //private ArrayList<LocalDate> datesOff;
    private LocalDate unavailableDate;


    /*
	public Schedule(String timeAvailable, String timeUnavailable, ArrayList<LocalDate> datesOff) {
		this.timeAvailable = timeAvailable;
		this.timeUnavailable = timeUnavailable;
		this.datesOff = datesOff;

	}
*/
    public Schedule() {

        this.timeUnavailable = "";
        this.unavailableDate = null;

    }


    public void setUnavailableDate(LocalDate date) {
        unavailableDate = date;
    }

    public LocalDate getUnavailableDate() {
        return unavailableDate;
    }

    public String getTimeUnavailable() {
        return timeUnavailable;
    }

    public void setTimeUnavailable(String timeUnavailable) {
        this.timeUnavailable = timeUnavailable;
    }


/*
	public void setDatesOff(ArrayList<LocalDate> datesOff) {
        this.datesOff = datesOff;
    }
*/

}