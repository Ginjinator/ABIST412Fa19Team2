package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfessionalUser implements Serializable {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    // private Schedule schedule;
    private ScheduleData schedule = new ScheduleData();
    private  ArrayList<Appointment> appointments = new ArrayList<>();
    //private ArrayList<ProfessionalUserGroup> professionalGroup;

    /*public User(String firstName, String lastName, String username, String password, ArrayList<StudyGroup> userGroups, Schedule schedule){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userGroups = userGroups;
        this.schedule = schedule
    }
     */

    /*
    public ProfessionalUser(String firstName, String lastName, String username, String password, Schedule schedule){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.schedule = schedule;
    }
*/

    public ProfessionalUser(String firstName, String lastName, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public ProfessionalUser(){
        this.firstName = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
    }

    public void setProfessionalUser(ProfessionalUser professionalUser){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.schedule = schedule;
        //this.userGroups = user.getUserGroups();
    }


    public ScheduleData getScheduleData() {
        return schedule;
    }
    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);

        System.out.println("I added an appointment with "+ appointment.getUser().getFullName());
        System.out.println(appointments);

    }

    public ArrayList<Appointment> getAppointments() {
        return this.appointments;
    }

    public void deleteAppointment(int Index) {
        this.appointments.remove(Index);


    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
    public Schedule getSchedule(){
        return schedule;
    }

    public void setSchedule(Schedule schedule){
        this.schedule = schedule;
    }
*/

    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }

    public Boolean isProfessional(){ return true; }
}
