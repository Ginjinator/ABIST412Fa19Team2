package Model;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessionalUserData implements Serializable {
    private String usersDataFileName = "ProfessionalUsersData.ser";
    private static ArrayList<ProfessionalUser> professionalUserData = new ArrayList<>();
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

    public ProfessionalUser getProfessionalUser(int index) {
        return getProfessionalUserData().get(index);
    }




    // Read User data from Azure database
    protected List<String> connectToDatabase(String... strings) {

        List<String> userLoginQueryResults = new ArrayList<>();

        String databaseURL = "jdbc:jtds:sqlserver:ist412team2.database.windows.net:1433/IST412Team2SchedulerDatabase;" +
                "DatabaseName = IST412Team2SchedulerDatabase;" +
                "user = ist412admin;" +
                "password = Pennstate1234;" +
                "encrypt = true; trustServerCertificate = false;" +
                "hostNameInCertificate = *.database.windows.net;" +
                "loginTimeout = 60;";

        try {
            // Create the connection the database
            Connection databaseConnection = DriverManager.getConnection(databaseURL);
            Statement statement = databaseConnection.createStatement();
            String selectSQL = "SELECT * FROM UserLogin";
            ResultSet resultSet = statement.executeQuery(selectSQL);

            while (resultSet.next()) {
                String UserID = resultSet.getString("UserID");
                String FirstName = resultSet.getString("FirstName");
                String LastName = resultSet.getString("LastName");
                String Email = resultSet.getString("Email");
                String Username = resultSet.getString("Username");
                String UserPassword = resultSet.getString("UserPassword");
                String ConfirmPassword = resultSet.getString("ConfirmPassword");

                // Add new user information to database
                userLoginQueryResults.add(UserID);
                userLoginQueryResults.add(FirstName);
                userLoginQueryResults.add(LastName);
                userLoginQueryResults.add(Email);
                userLoginQueryResults.add(Username);
                userLoginQueryResults.add(UserPassword);
                userLoginQueryResults.add(ConfirmPassword);
            }
            databaseConnection.close();
            statement.close();
            resultSet.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return userLoginQueryResults;
    }
}