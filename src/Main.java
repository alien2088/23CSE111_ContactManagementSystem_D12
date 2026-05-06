import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ContactManager contactManager = new ContactManager();

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("       CONTACT MANAGEMENT SYSTEM         ");
        System.out.println("==========================================");

        User currentUser = null;
        User adminUser = new User(1, "admin", "admin123", "admin@cms.com");

        while (currentUser == null) {
            System.out.print("Enter Username : ");
            String username = scanner.nextLine();
            System.out.print("Enter Password : ");
            String password = scanner.nextLine();

            if (adminUser.login(username, password)) {
                currentUser = adminUser;
                System.out.println("\nLogin successful! Welcome, " + username + "!\n");
            } 
            else {
                System.out.println("Invalid credentials. Try again.\n");
            }
        }

        boolean running = true;
        while (running) {
            System.out.println("------------------------------------------");
            System.out.println("                MAIN MENU                ");
            System.out.println("------------------------------------------");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": addContact();                        break;
                case "2": contactManager.displayContacts();    break;
                case "3": searchContact();                     break;
                case "4": editContact();                       break;
                case "5": deleteContact();                     break;
                case "6": currentUser.logout(); running=false; break;
                default : System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    static void addContact() {
        System.out.println("\n--- ADD CONTACT ---");
        System.out.print("Name     : "); String name     = scanner.nextLine();
        System.out.print("Phone    : "); String phone    = scanner.nextLine();
        System.out.print("Email    : "); String email    = scanner.nextLine();
        System.out.print("Address  : "); String address  = scanner.nextLine();
        System.out.print("Birthday : "); String birthday = scanner.nextLine();
        System.out.print("Company  : "); String company  = scanner.nextLine();

        int id = contactManager.getNextId();
        Contact c = new Contact(id, name, phone, email, address, birthday, company);
        contactManager.addContact(c);
        System.out.println("Contact added with ID: " + id + "\n");
    }
    static void searchContact() {
        System.out.println("\n--- SEARCH CONTACT ---");
        System.out.print("Enter name or phone: ");
        String keyword = scanner.nextLine();
        contactManager.searchContact(keyword);
    }

    static void editContact() {
        System.out.println("\n--- EDIT CONTACT ---");
        System.out.print("Enter Contact ID to edit: ");

        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
            return;
        }

        Contact c = contactManager.viewContact(id);
        if (c == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Leave blank to keep current value.\n");

        System.out.print("Name     [" + c.getName()        + "]: "); String name     = scanner.nextLine();
        System.out.print("Phone    [" + c.getPhoneNumber() + "]: "); String phone    = scanner.nextLine();
        System.out.print("Email    [" + c.getEmail()       + "]: "); String email    = scanner.nextLine();
        System.out.print("Address  [" + c.getAddress()     + "]: "); String address  = scanner.nextLine();
        System.out.print("Birthday [" + c.getBirthday()    + "]: "); String birthday = scanner.nextLine();
        System.out.print("Company  [" + c.getCompany()     + "]: "); String company  = scanner.nextLine();

        if (!name.isEmpty())     c.setName(name);
        if (!phone.isEmpty())    c.setPhoneNumber(phone);
        if (!email.isEmpty())    c.setEmail(email);
        if (!address.isEmpty())  c.setAddress(address);
        if (!birthday.isEmpty()) c.setBirthday(birthday);
        if (!company.isEmpty())  c.setCompany(company);

        contactManager.updateContact(c);
        System.out.println();
    }

    static void deleteContact() {
        System.out.println("\n--- DELETE CONTACT ---");
        System.out.print("Enter Contact ID to delete: ");

        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
            return;
        }

        contactManager.deleteContact(id);
        System.out.println();
    }
}
