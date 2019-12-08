package Model;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserData implements Serializable {

    /**
     * @return the usersData
     */
    public static ArrayList<User> getUsersData() {
        return usersData;
    }

    /**
     * @param aUsersData the usersData to set
     */
    public static void setUsersData(ArrayList<User> aUsersData) {
        usersData = aUsersData;
    }
    private static ArrayList<User> usersData = new ArrayList<>();
    String usersDataFileName = "UsersData.ser";

    public UserData() {

        this.read();
        if(usersData.isEmpty()|| usersData == null){
//        this.createTestUsersData();
            this.write();
            this.read();
        }
    }

    private void createTestUsersData() {
        for(int i = 0; i <20; i++){
            getUsersData().add(new User("firstName" + i, "lastName" + i, "username" + i, "password" + i, "phoneNumber" + i));
        }
    }

    public void read(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(usersDataFileName);

            ois = new ObjectInputStream(fis);
            setUsersData((ArrayList<User>) ois.readObject());
            ois.close();
            if(!usersData.isEmpty()){
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
            oos.writeObject(getUsersData());
            oos.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public User searchUsersData(String username){
        for(int i = 0 ; i < getUsersData().size();i++){
            if (getUsersData().get(i).getUsername().equals(username)){
                return getUsersData().get(i);
            }

        }
        return new User();
    }

    public void writeUser(String username, User user){
        for(int i = 0 ; i < getUsersData().size();i++){
            if (getUsersData().get(i).getUsername().equals(username)){
                getUsersData().get(i).setUser(user);
            }

        }
        write();
    }

    public void addUser(User user){
        getUsersData().add(user);
        write();
    }

    // Read User data from Azure database
    protected List<String> connectToDatabase(String... strings) {

        List<String> userLoginQueryResults = new ArrayList<>();

        String databaseURL = " ;" +
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

