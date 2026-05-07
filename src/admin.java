import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Admin extends User {

    private int    adminId;
    private String role;

    private static final String USERS_FILE = "users.txt";

    public Admin(int adminId, String username, String password, String email, String role) {
        super(adminId, username, password, email);   // calls User's constructor
        this.adminId = adminId;
        this.role    = role;
    }
    public int    getAdminId() { return adminId; }
    public String getRole()    { return role; }

   
    public void addUser(String username, String password, String email) {
        if (userExists(username)) {
            System.out.println("Username '" + username + "' already exists.");
            return;
        }
        int newId = getNextUserId();
        try (FileWriter fw = new FileWriter(USERS_FILE, true)) {
            fw.write(newId + "," + username + "," + password + "," + email + "\n");
            System.out.println("User '" + username + "' added successfully! (ID: " + newId + ")");
        } catch (IOException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

    public void removeUser(String username) {
        ArrayList<String> lines = loadUserLines();
        boolean found = false;

        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",", 4);
            if (parts.length >= 2 && parts[1].trim().equals(username)) {
                lines.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            saveUserLines(lines);
            System.out.println("User '" + username + "' removed successfully.");
        } else {
            System.out.println("User '" + username + "' not found.");
        }
    }

    public void viewAllUsers() {
        ArrayList<String> lines = loadUserLines();

        System.out.println("\n========== REGISTERED USERS (" + lines.size() + ") ==========");

        System.out.println("+------------------------------------------+");
        System.out.printf ("| ID       : %-30d |\n", adminId);
        System.out.printf ("| Username : %-30s |\n", getUsername());
        System.out.printf ("| Email    : %-30s |\n", getEmail());
        System.out.printf ("| Role     : %-30s |\n", "ADMIN");
        System.out.println("+------------------------------------------+");

        if (lines.isEmpty()) {
            System.out.println("No regular users registered yet.");
            return;
        }

        for (String line : lines) {
            String[] parts = line.split(",", 4);
            if (parts.length >= 4) {
                System.out.println("+------------------------------------------+");
                System.out.printf ("| ID       : %-30s |\n", parts[0].trim());
                System.out.printf ("| Username : %-30s |\n", parts[1].trim());
                System.out.printf ("| Email    : %-30s |\n", parts[3].trim());
                System.out.printf ("| Role     : %-30s |\n", "USER");
                System.out.println("+------------------------------------------+");
            }
        }
    }

    public void viewAllLogs() {
        System.out.println("\n========== ACTIVITY LOG ==========");
        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            int count = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(count + ". " + line);
                count++;
            }
            if (count == 1) System.out.println("No log entries found.");
        } catch (IOException e) {
            System.out.println("No log file found yet.");
        }
        System.out.println("===================================\n");
    }

    public void resetAllContacts() {
        try (FileWriter fw = new FileWriter("contacts.txt", false)) {
            fw.write("");   // overwrite with empty content
            System.out.println("All contacts have been deleted. contacts.txt is now empty.");
        } catch (IOException e) {
            System.out.println("Error resetting contacts: " + e.getMessage());
        }
    }

    public void viewStats() {
        int contactCount = 0;
        int userCount    = 0;
        int logCount     = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("contacts.txt"))) {
            while (br.readLine() != null) contactCount++;
        } catch (IOException e) { contactCount = 0; }

        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE))) {
            while (br.readLine() != null) userCount++;
        } catch (IOException e) { userCount = 0; }

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            while (br.readLine() != null) logCount++;
        } catch (IOException e) { logCount = 0; }

        System.out.println("\n========== SYSTEM STATISTICS ==========");
        System.out.printf ("| Total Contacts   : %-20d |\n", contactCount);
        System.out.printf ("| Registered Users : %-20d |\n", userCount + 1); // +1 for admin
        System.out.printf ("| Log Entries      : %-20d |\n", logCount);
        System.out.println("========================================\n");
    }

    private boolean userExists(String username) {
        for (String line : loadUserLines()) {
            String[] parts = line.split(",", 4);
            if (parts.length >= 2 && parts[1].trim().equals(username)) return true;
        }
        return false;
    }

    private int getNextUserId() {
        ArrayList<String> lines = loadUserLines();
        int maxId = 1;  // start from 2 (1 is reserved for admin)
        for (String line : lines) {
            String[] parts = line.split(",", 4);
            try {
                int id = Integer.parseInt(parts[0].trim());
                if (id > maxId) maxId = id;
            } catch (NumberFormatException e) { }
        }
        return maxId + 1;
    }

    private ArrayList<String> loadUserLines() {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) lines.add(line);
            }
        } catch (IOException e) { /* file doesn't exist yet */ }
        return lines;
    }

    private void saveUserLines(ArrayList<String> lines) {
        try (FileWriter fw = new FileWriter(USERS_FILE, false)) {
            for (String line : lines) fw.write(line + "\n");
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    public boolean validateUserLogin(String username, String password) {
        for (String line : loadUserLines()) {
            String[] parts = line.split(",", 4);
            if (parts.length >= 3 &&
                parts[1].trim().equals(username) &&
                parts[2].trim().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Admin{ID=" + adminId + ", Username='" + getUsername() +
               "', Role='" + role + "'}";
    }
}
