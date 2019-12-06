package Model;

import java.io.Serializable;

public class User implements Serializable{

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phoneNumber;

    //private ArrayList<StudyGroup> userGroups;

    /*public User(String firstName, String lastName, String username, String password, String phoneNumber, ArrayList<StudyGroup> userGroups){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        //this.userGroups = userGroups;
    }
     */

    public User(String firstName, String lastName, String username, String password, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        //this.userGroups = new ArrayList<>();
    }

    public User(){
        this.firstName = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
        this.phoneNumber = "";

        //this.userGroups = new ArrayList<>();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    //public void setUserGroups(ArrayList<StudyGroup> userGroups) {
        //this.userGroups = userGroups;
    //}

    public void setUser(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.username = user.getPhoneNumber();
        //this.userGroups = user.getUserGroups();
    }



    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber(){ return phoneNumber; }

    /*public ArrayList<StudyGroup> getUserGroups() {
        return userGroups;
    }
    */

    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }

    public Boolean isProfessional(){ return false; }

    /*
    public ArrayList<StudyGroup> addtoGroup(StudyGroup studyGroup){
        userGroups.add(studyGroup);
        return userGroups;
    }

    public ArrayList<StudyGroup> removeFromGroup(StudyGroup studyGroup){
        int index = searchStudyGroup(studyGroup);
        if((userGroups.size() > 0) && (index >= 0)){
            userGroups.remove(index);
        }
        return userGroups;
    }

    public int searchStudyGroup(StudyGroup studyGroup){
        for(int i = 0;i < userGroups.size();i++){
            if(userGroups.get(i).equals(studyGroup)){
                return i;
            }
        }
        return -1;
    }
    */



}

