package model;
public class User {
    private String userID;
    private String userName;
    private String userPassword;

    public User(String id, String name, String password){
        setUserID(id);
        setUserName(name);
        setUserPassword(password);
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


