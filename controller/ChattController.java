package controller;

import model.User;
import model.Message;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ChattController {

    private ArrayList<User> users;
    private ArrayList<Message> messages;
    private User currentUser;
    private final String CSV_FILE = "Messages.csv";

    public ChattController() {
        this.users = User.getDefaultUsers();
        
        this.users.add(new User("1", "Admin", "123"));

        this.messages = new ArrayList<>();
        this.currentUser = null;

        loadMessagesFromCSV();
    }

    public boolean login(String userName, String userPassword) {
        for (User u : users) {
            if (u.getUserName().equals(userName) && u.getUserPassword().equals(userPassword)) {
                currentUser = u;
                return true;
            }
        }
        return false;
    }

    public String getCurrentUserName() {
        return currentUser != null ? currentUser.getUserName() : "Guest";
    }

    public ArrayList<Message> getAllMessages() {
        return messages;
    }

    public void writeMessage(String content) {
        if (currentUser != null) {
            String newId = String.valueOf(messages.size() + 1);

            Message newMessage = new Message(newId, content, currentUser);
            messages.add(newMessage);

            saveMessagesToCSV();
        }
    }

    public boolean deleteMessage(String messageId) {
        if (currentUser == null) {
            return false;
        }

        for (int i = 0; i < messages.size(); i++) {
            Message m = messages.get(i);

            if (m.getMessageId().equals(messageId)) {
                if (m.getAuthor().getUserName().equals(currentUser.getUserName())) {
                    messages.remove(i);
                    saveMessagesToCSV(); 
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private void loadMessagesFromCSV() {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";");
                if (parts.length >= 4) {
                    String id = parts[0];
                    String authorName = parts[1];
                    String time = parts[2];
                    String text = parts[3];

                    User author = findUserByName(authorName);
                    if (author == null) {
                        author = new User("0", authorName, ""); 
                    }

                    
                    Message m = new Message(id, text, author);
                    messages.add(m);
                }
            }
        } catch (IOException e) {
            
        }
    }

    private void saveMessagesToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {
            for (Message m : messages) {
                String line = m.getMessageId() + ";" + 
                              m.getAuthor().getUserName() + ";" + 
                              m.getTimestamp() + ";" + 
                              m.getContent();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Fel vid sparande till CSV-fil: " + e.getMessage());
        }
    }

    private User findUserByName(String name) {
        for (User u : users) {
            if (u.getUserName().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }
}