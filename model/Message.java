package model;
public class Message {
    private String messageId;
    private String content;
    private User author;
    //add date

    public Message (String messageId, String content, User author) {
        this.messageId = messageId;
        this.content = content;
        this.author = author;
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

    @Override
    public String toString() {
        return author.getUserName() + " (ID: " + messageId + ")\n" + content;
    }
}
//read data csv
//write data csv