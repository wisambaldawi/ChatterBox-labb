package model;
import java.util.ArrayList;

public class User {
    private String userID;
    private String userName;
    private String userPassword;

    public User(String id, String name, String password){
        setUserID(id);
        setUserName(name);
        setUserPassword(password);
    }

    public static ArrayList<User> getDefaultUsers(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("U001", "ViggoViborg", "1234"));
        users.add(new User("U002", "WisamBaldawi", "4321"));
        users.add(new User("U003", "KevinThor", "5678"));
        users.add(new User("U004", "MuhammadHumayoun", "8765"));
        return users;
    }


    public String getUserID(){
        return userID;
    }
    public void setUserID(String id){
        this.userID = id;
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String name){
        this.userName = name;
    }

    public String getUserPassword(){
        return userPassword;
    }
    public void setUserPassword(String password){
        this.userPassword = password;
    }

    @Override
    public String toString() {
        return "User{id=" + userID + ", name=" + userName + ", password=" + userPassword +"}";
    }
}


