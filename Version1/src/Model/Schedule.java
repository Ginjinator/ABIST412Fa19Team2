package Model;

import java.io.Serializable;
import java.time.LocalDate;



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