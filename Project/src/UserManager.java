
import java.io.*;
import java.util.*;

public class UserManager {
	
    private Map<String, String> users = new HashMap<>();
    private final String USERS_FILE = "usersAccount.txt";

    public UserManager() {
        loadUsers();
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                users.put(details[0], details[1]);
            }
        } catch (IOException e) {
            System.out.println("No existing user file found, a new one will be created.");
        }
    }

    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, password);
        saveUsers();
        return true;
    }

    private void saveUsers() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean loginUser(String username, String password) {
        return password.equals(users.get(username));
    }
}
