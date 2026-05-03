import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        // Pre-load some sample contacts
        contactManager.addContact(new Contact(1, "Alice Johnson", "9876543210", "alice@gmail.com", "Kochi, Kerala", "1998-05-12", "TechCorp"));
        contactManager.addContact(new Contact(2, "Bob Smith", "9123456780", "bob@outlook.com", "Trivandrum, Kerala", "1995-11-23", "InfoSys"));

        System.out.println("=========================================");
        System.out.println("     CONTACT MANAGEMENT SYSTEM           ");
        System.out.println("=========================================");

        // Login
        User currentUser = null;
        while (currentUser == null) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            if (username.equals("admin") && password.equals("admin123")) {
                currentUser = new User(1, username, password, "admin@cms.com");
                System.out.println("\n✔ Login successful! Welcome, " + username + "!\n");
            } else {
                System.out.println("✘ Invalid credentials. Try again.\n");
            }
        }

        boolean running = true;
        while (running) {
            System.out.println("-----------------------------------------");
            System.out.println("           MAIN MENU");
            System.out.println("-----------------------------------------");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addContact(scanner, contactManager);
                    break;
                case "2":
                    contactManager.displayContacts();
                    break;
                case "3":
                    searchContact(scanner, contactManager);
                    break;
                case "4":
                    editContact(scanner, contactManager);
                    break;
                case "5":
                    deleteContact(scanner, contactManager);
                    break;
                case "6":
                    currentUser.logout();
                    running = false;
                    break;
                default:
                    System.out.println("✘ Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    static void addContact(Scanner scanner, ContactManager cm) {
        System.out.println("\n--- ADD CONTACT ---");
        System.out.print("Name        : ");
        String name = scanner.nextLine();
        System.out.print("Phone       : ");
        String phone = scanner.nextLine();
        System.out.print("Email       : ");
        String email = scanner.nextLine();
        System.out.print("Address     : ");
        String address = scanner.nextLine();
        System.out.print("Birthday    : ");
        String birthday = scanner.nextLine();
        System.out.print("Company     : ");
        String company = scanner.nextLine();

        int id = cm.getNextId();
        Contact c = new Contact(id, name, phone, email, address, birthday, company);
        cm.addContact(c);
        System.out.println("✔ Contact added successfully! (ID: " + id + ")\n");
    }

    static void searchContact(Scanner scanner, ContactManager cm) {
        System.out.println("\n--- SEARCH CONTACT ---");
        System.out.print("Enter name or phone to search: ");
        String keyword = scanner.nextLine();
        cm.searchContact(keyword);
    }

    static void editContact(Scanner scanner, ContactManager cm) {
        System.out.println("\n--- EDIT CONTACT ---");
        System.out.print("Enter Contact ID to edit: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("✘ Invalid ID.");
            return;
        }

        Contact c = cm.viewContact(id);
        if (c == null) {
            System.out.println("✘ Contact not found.");
            return;
        }

        System.out.println("Current details: " + c);
        System.out.println("Enter new details (press Enter to keep current):");

        System.out.print("Name [" + c.getName() + "]: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) c.setName(name);

        System.out.print("Phone [" + c.getPhoneNumber() + "]: ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) c.setPhoneNumber(phone);

        System.out.print("Email [" + c.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) c.setEmail(email);

        System.out.print("Address [" + c.getAddress() + "]: ");
        String address = scanner.nextLine();
        if (!address.isEmpty()) c.setAddress(address);

        System.out.print("Birthday [" + c.getBirthday() + "]: ");
        String birthday = scanner.nextLine();
        if (!birthday.isEmpty()) c.setBirthday(birthday);

        System.out.print("Company [" + c.getCompany() + "]: ");
        String company = scanner.nextLine();
        if (!company.isEmpty()) c.setCompany(company);

        cm.updateContact(c);
        System.out.println("✔ Contact updated successfully!\n");
    }

    static void deleteContact(Scanner scanner, ContactManager cm) {
        System.out.println("\n--- DELETE CONTACT ---");
        System.out.print("Enter Contact ID to delete: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("✘ Invalid ID.");
            return;
        }
        cm.deleteContact(id);
    }
}
