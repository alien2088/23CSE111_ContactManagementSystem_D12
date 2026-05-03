/**
 * User class
 * Represents a person who uses the Contact Management System.
 * Attributes: userId, username, password, email
 * Methods: login(), logout(), validateCredentials()
 */
public class User {
    private int userId;
    private String username;
    private String password;
    private String email;

    // Constructor
    public User(int userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Login method
    public boolean login(String username, String password) {
        if (validateCredentials(username, password)) {
            System.out.println("✔ User '" + username + "' logged in successfully.");
            return true;
        } else {
            System.out.println("✘ Login failed. Invalid credentials.");
            return false;
        }
    }

    // Logout method
    public void logout() {
        System.out.println("✔ User '" + this.username + "' has logged out. Goodbye!\n");
    }

    // Credential validation
    public boolean validateCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Getters and Setters
    public int getUserId()             { return userId; }
    public String getUsername()        { return username; }
    public String getEmail()           { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "User{ID=" + userId + ", Username='" + username + "', Email='" + email + "'}";
    }
}
