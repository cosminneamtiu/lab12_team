package isp.lab6.exercise3;

import java.util.Scanner;

public class Exercise3 {

    private static final Scanner scanner = new Scanner(System.in);
    private static LoginSystem loginSystem;
    private static final OnlineStore onlineStore = new OnlineStore();

    public static void main(String[] args) {
        loginSystem = new LoginSystem(onlineStore);
        menu();
        scanner.close();
    }

    private static void menu() {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the Online Store!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        loginSystem.register(username, password);
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        loginSystem.login(username, password);
    }
}
