package view;
import java.util.Scanner;
import controller.ChattController;
import model.Message;

public class ConsoleUI {

    private Scanner scanner = new Scanner(System.in);
    private ChattController controller = new ChattController();

    public boolean handleLogin(){
        System.out.println("Enter username: ");
        String userName = scanner.nextLine();
        System.out.println("Enter password: ");
        String userPassword = scanner.nextLine();

        if(controller.login(userName, userPassword)){
            System.out.println("Welcomne, " + controller.getCurrentUserName());
            return true;
        }
        System.out.println("Wrong username or password");
        return false;
    }

    public void start(){
        boolean running = true;

        while (running){
            System.out.println("\n=== ChatterBox ===");
            System.out.println("1. Login");
            System.out.println("2. Continue as guest");
            System.out.println("3. End");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            if(choice.equals("1")){
                if(handleLogin()){
                    boolean quit = userMenu();
                    if(quit){
                        System.out.println("Program ended");
                        running = false;
                    }
                }
            }
            else if(choice.equals("2")){
                System.out.println("\n--- Chatt history ---");
                    for (Message m : controller.getAllMessages()) {
                        System.out.println(m.toString());
                        System.out.println("-------------");
                }
            }
            else if(choice.equals("3")){
                System.out.println("Program ended");
                running = false;
            }
            else{
                System.out.println("Invalid, try again");
            }
        }
    }

    public boolean userMenu(){
        boolean running = true;

        while(running){
            System.out.println("\n=== User Menu ===");
            System.out.println("1. Write new message");
            System.out.println("2. Message menu");
            System.out.println("3. End");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            if(choice.equals("1")){
                System.out.println("Write your message: ");
                String text = scanner.nextLine();
                controller.writeMessage(text);
                System.out.println("Message send");
            }
            else if(choice.equals("2")){
                boolean quit = messageMenu();
                if(quit){
                    return true;   
                }
            }
            else if(choice.equals("3")){
                return true;       
            }
            else{
                System.out.println("Invalid, try again");
            }
        }
        return false;
    }

    public boolean messageMenu(){
        boolean running = true;

        while(running){
            System.out.println("\n=== Message Menu ===");
            System.out.println("1. View all messages");
            System.out.println("2. View your messages");
            System.out.println("3. Delete a message");
            System.out.println("4. Return");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            if(choice.equals("1")){
                System.out.println("\n--- Chatt history ---");
                for (Message m : controller.getAllMessages()) {
                    System.out.println(m.toString());
                    System.out.println("-------------");
                }
            }
            else if(choice.equals("2")){
                System.out.println("\n--- Your Messages ---");
                boolean hasMessage = false;

                for (Message m : controller.getAllMessages()) {
                    if (m.getAuthor().getUserName().equals(controller.getCurrentUserName())) {
                        System.out.println(m.toString());
                        System.out.println("---------------");
                        hasMessage = true;
                    }
                }
                if (!hasMessage) {
                    System.out.println("You dont have any messages");
                }
            
            }
            else if(choice.equals("3")){
                System.out.print("Enter ID for the message to delete: ");
                String idToDelete = scanner.nextLine();
                boolean deleted = controller.deleteMessage(idToDelete);
                if(deleted) {
                    System.out.println("Message deleted successfully!");
                } else {
                    System.out.println("Could not delete message");
                }
            }
            else if(choice.equals("4")){
                running = false;
            }
            else {
            System.out.println("Invalid, try again");
            }
        } 
        return false;
    }
}