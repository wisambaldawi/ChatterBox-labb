package controller;
import model.User;

import java.util.ArrayList;

import model.Message;

public class ChattController {

    private ArrayList<User> users;
    private ArrayList<Message> messages;
    private User currentUser;

    public ChattController() {
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.currentUser = null;

        this.users.add(new User("1", "Admin", "123"));
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

    public void handleLogin(String username, String password) {

    }
}
