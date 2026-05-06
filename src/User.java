public class User {

    private int userId;
    private String username;
    private String password;
    private String email;

    public User(int userId, String username,
                String password, String email) {

        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public boolean login(String username, String password) {

        if (validateCredentials(username, password)) {
            System.out.println("User " + username + " logged in successfully.");
            return true;
        }

        System.out.println("Invalid username or password.");
        return false;
    }

    public void logout() {

        System.out.println("User " + this.username + " logged out successfully.\n");
    }

    public boolean validateCredentials(String username,String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {

        return "User ID: " + userId +
               ", Username: " + username +
               ", Email: " + email;
    }
}
