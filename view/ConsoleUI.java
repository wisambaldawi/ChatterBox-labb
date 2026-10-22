package view;
import java.util.Scanner;

public class ConsoleUI {

    private Scanner scanner = new Scanner(System.in);

    public void start(){
        boolean running = true;

        while (running){
            System.out.println("\n=== ChatterBox ===");
            System.out.println("1. Login");
            System.out.println("2. Continue as guest");
            System.out.println("3. End");
            System.out.print("Chose: ");

            String choice = scanner.nextLine();

            if(choice.equals("1")){
                //handleLogin();
            }
            else if(choice.equals("2")){
                //viewAllMessages();
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

    public void userMenu(){
        boolean running = true;

        while(running){
            System.out.println("\n=== User Menu ===");
            System.out.println("1. Write new message");
            System.out.println("2. Message menu");
            System.out.println("3. End");
            System.out.print("Chose: ");

            String choice = scanner.nextLine();

            if(choice.equals("1")){
                //writeMessage();
            }
            else if(choice.equals("2")){
                messageMenu();
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

    public void messageMenu(){
        boolean running = true;

        while(running){
            System.out.println("\n=== Message Menu ===");
            System.out.println("1. View all messages");
            System.out.println("2. View your messages");
            System.out.println("3. Return");
            System.out.print("Chose: ");

            String choice = scanner.nextLine();

            if(choice.equals("1")){
                //viewAllMessages();
            }
            else if(choice.equals("2")){
                //viewYourMessges
            }
            else if(choice.equals("3")){
                running = false;
                userMenu();
            }
            else{
                System.out.println("Invalid, try again");
            }
        }
    }
}