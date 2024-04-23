package user;

import java.io.*;
import java.util.*;

public class Main {
			
    private static final String DATA_FILE = "userdata.txt";

    public static void main(String[] args) {
    			
        Scanner input = new Scanner(System.in);
    			
        try {
            
            System.out.println("Create Account.\n");
            System.out.print("Create username: ");
            String username = input.nextLine();
            System.out.print("Create password: ");
            String password = input.nextLine();

            saveCredentials(username, password);
            System.out.println("-----------------------------");
            System.out.println("\nLogin Account.\n");
            boolean isAuthenticated = false;
            int attempts = 0;

            while (!isAuthenticated && attempts < 3) {
                System.out.print("Enter Username: ");
                String inputUsername = input.nextLine();
                System.out.print("Enter Password: ");
                String inputPassword = input.nextLine();

                if (checkCredentials(inputUsername, inputPassword)) {
                			   System.out.println("-----------------------------\n");
                   			System.out.println("Login successful!");
                			   System.out.println("Welcome to your account.");
                    isAuthenticated = true;
                } else {
                    System.out.println("Incorrect username or password.\n");
                			   System.out.println("-----------------------------\n");
                    attempts++;
                }
            }

            if (!isAuthenticated) {
                System.out.println("Login failed after 3 attempts.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            input.close();
        }
    }

    private static void saveCredentials(String username, String password) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(DATA_FILE, true))) {
            out.println(username + ":" + password);
        }
    }

    private static boolean checkCredentials(String username, String password) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(":");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}