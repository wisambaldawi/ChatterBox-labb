package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private String messageId;
    private String content;
    private User author;
    private String timestamp;

    public Message (String messageId, String content, User author) {
        this.messageId = messageId;
        this.content = content;
        this.author = author;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.timestamp = now.format(formatter);
    }

    public Message (String messageId, String content, User author, String timestamp) {
        this.messageId = messageId;
        this.content = content;
        this.author = author;
        this.timestamp = timestamp;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return author.getUserName() + " [" + timestamp + "] (ID: " + messageId + ")\n" + content;
    }
}
