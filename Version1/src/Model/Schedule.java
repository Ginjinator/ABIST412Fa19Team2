package Model;

import java.io.Serializable;
import java.util.Date;

/**
 * Used to save a users available time and vacation/time off
 */
public class Schedule implements Serializable {

    // Work hours
    private String timeAvailable;
    // Lunch and after hours
    private String timeUnavailable;
    private Date [] datesOff;

    public Schedule(String timeAvailable, String timeUnavailable, Date [] datesOff) {
        this.timeAvailable = timeAvailable;
        this.timeUnavailable = timeUnavailable;
        this.datesOff = datesOff;
    }

    public Schedule() {
        this.timeAvailable = "";
        this.timeUnavailable = "";
        this.datesOff = null;
    }

    public String getTimeAvailable() {
        return timeAvailable;
    }

    public void setTimeAvailable(String timeAvailable) {
        this.timeAvailable = timeAvailable;
    }

    public String getTimeUnavailable() {
        return timeUnavailable;
    }

    public void setTimeUnavailable(String timeUnavailable) {
        this.timeUnavailable = timeUnavailable;
    }

    public Date[] getDatesOff() {
        return datesOff;
    }

    public void setDatesOff(Date[] datesOff) {
        this.datesOff = datesOff;
    }

}