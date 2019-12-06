package Model;

import java.io.*;
import java.util.ArrayList;

public class ProfessionalUserData {
    /**
     * @return the professionalUserData
     */
    public static ArrayList<ProfessionalUser> getProfessionalUserData() {
        return professionalUserData;
    }

    /**
     * @param aUsersData the professionalUserData to set
     */
    public static void setProfessionalUserData(ArrayList<ProfessionalUser> aUsersData) {
        professionalUserData = aUsersData;
    }
    private static ArrayList<ProfessionalUser> professionalUserData = new ArrayList<>();
    String usersDataFileName = "UsersData.ser";

    public ProfessionalUserData() {

        this.read();
        if(professionalUserData.isEmpty()|| professionalUserData == null){
//        this.createTestUsersData();
            this.write();
            this.read();
        }
    }

    private void createTestUsersData() {
        for(int i = 0; i <20; i++){
            getProfessionalUserData().add(new ProfessionalUser("firstName" + i, "lastName" + i, "username" + i, "password" + i));
        }
    }

    public void read(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(usersDataFileName);

            ois = new ObjectInputStream(fis);
            setProfessionalUserData((ArrayList<ProfessionalUser>) ois.readObject());
            ois.close();
            if(!professionalUserData.isEmpty()){
                System.out.println("There's users");
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public void write(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(usersDataFileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(getProfessionalUserData());
            oos.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ProfessionalUser searchUsersData(String username){
        for(int i = 0; i < getProfessionalUserData().size(); i++){
            if (getProfessionalUserData().get(i).getUsername().equals(username)){
                return getProfessionalUserData().get(i);
            }

        }
        return new ProfessionalUser();
    }

    public void writeUser(String username, ProfessionalUser professionalUser){
        for(int i = 0; i < getProfessionalUserData().size(); i++){
            if (getProfessionalUserData().get(i).getUsername().equals(username)){
                getProfessionalUserData().get(i).setProfessionalUser(professionalUser);
            }

        }
        write();
    }

    public void addUser(ProfessionalUser professionalUser){
        getProfessionalUserData().add(professionalUser);
        write();
    }

    public static ArrayList<String> getProfessionalUserDataNames() {
        ArrayList<String> names = new ArrayList<>();
        for (ProfessionalUser i : getProfessionalUserData()) {
            names.add(i.getFirstName() + " " + i.getLastName());
        }
        return names;
    }


}
