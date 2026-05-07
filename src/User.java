import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;

    public User(int userId, String username, String password, String email) {
        this.userId   = userId;
        this.username = username;
        this.password = password;
        this.email    = email;
    }

    public boolean validateCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public boolean login(String username, String password) {
        if (validateCredentials(username, password)) {
            writeLog("LOGIN  - User '" + username + "' logged in.");
            return true;
        }
        return false;
    }
    public void logout() {
        writeLog("LOGOUT - User '" + username + "' logged out.");
        System.out.println("Goodbye, " + username + "! Your session has been logged.");
    }
    private void writeLog(String action) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        try (FileWriter fw = new FileWriter("log.txt", true)) {
            fw.write("[" + timestamp + "] " + action + "\n");
        } catch (IOException e) {
            System.out.println("Warning: Could not write to log file.");
        }
    }

    public int    getUserId()   { return userId; }
    public String getUsername() { return username; }
    public String getEmail()    { return email; }
}
