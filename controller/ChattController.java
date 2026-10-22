package controller;
import model.User;
import model.Message;

import java.util.ArrayList;


public class ChattController {

    private ArrayList<User> users;
    private ArrayList<Message> messages;
    private User currentUser;

    public ChattController() {
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.currentUser = null;

        users = User.getDefaultUsers();

        this.users.add(new User("1", "Admin", "123"));
    }
    public boolean login(String userName, String userPassword){
        for(User u : users){
            if(u.getUserName().equals(userName) && u.getUserPassword().equals(userPassword)){
                currentUser = u;
                return true;
            }
        }
        return false;
    }

    public String getCurrentUserName(){
        return currentUser.getUserName();
    }

    public ArrayList<Message> getAllMessages() {
        return messages;
    }

    public void writeMessage(String content) {

        if (currentUser != null) {
            String newId = String.valueOf(messages.size() +1 );

            Message newMessage = new Message(newId, content, currentUser);
            messages.add(newMessage);
        }

    }

    public boolean deleteMessage(String messageId) {

        if (currentUser == null) {
            return false;
        }    

        for (int i = 0; i < messages.size(); i ++) {
            Message m = messages.get(i);

            if (m.getMessageId().equals(messageId)) {
                if (m.getAuthor().getUserName().equals(currentUser.getUserName())) {
                    messages.remove(i);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
