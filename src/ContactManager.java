import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ContactManager {

    private static final String FILE_NAME = "contacts.txt";

    private ArrayList<Contact> loadFromFile() {
        ArrayList<Contact> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 7);
                if (parts.length == 7) {
                    Contact c = new Contact(
                            Integer.parseInt(parts[0].trim()),
                            parts[1].trim(), parts[2].trim(), parts[3].trim(),
                            parts[4].trim(), parts[5].trim(), parts[6].trim()
                    );
                    list.add(c);
                }
            }
        } catch (IOException e) {
          
        }

        return list;
    }

    private void saveToFile(ArrayList<Contact> list) {
        try (FileWriter fw = new FileWriter(FILE_NAME, false)) {
            for (Contact c : list) {
                fw.write(c.toFileString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    public int getNextId() {
        ArrayList<Contact> list = loadFromFile();
        int maxId = 0;
        for (Contact c : list) {
            if (c.getContactId() > maxId) maxId = c.getContactId();
        }
        return maxId + 1;
    }

    public void addContact(Contact contact) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {  
            fw.write(contact.toFileString() + "\n");
            System.out.println("Contact saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error adding contact: " + e.getMessage());
        }
    }

    public void displayContacts() {
        ArrayList<Contact> list = loadFromFile();

        if (list.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("\n========== ALL CONTACTS (" + list.size() + ") ==========");
        for (Contact c : list) {
            c.display();
        }
    }

    public void searchContact(String keyword) {
        ArrayList<Contact> list = loadFromFile();
        boolean found = false;

        System.out.println("\n--- Search Results for: \"" + keyword + "\" ---");
        for (Contact c : list) {
            if (c.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    c.getPhoneNumber().contains(keyword)) {
                c.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contact found matching \"" + keyword + "\".");
        }
    }

    public Contact viewContact(int contactId) {
        ArrayList<Contact> list = loadFromFile();
        for (Contact c : list) {
            if (c.getContactId() == contactId) return c;
        }
        return null;
    }

    public void updateContact(Contact updated) {
        ArrayList<Contact> list = loadFromFile();
        boolean found = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getContactId() == updated.getContactId()) {
                list.set(i, updated);
                found = true;
                break;
            }
        }

        if (found) {
            saveToFile(list);
            System.out.println("Contact updated in file successfully!");
        } else {
            System.out.println("Contact ID not found.");
        }
    }

    public void deleteContact(int contactId) {
        ArrayList<Contact> list = loadFromFile();
        boolean found = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getContactId() == contactId) {
                System.out.println("Deleted: " + list.get(i).getName());
                list.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            saveToFile(list);
            System.out.println("Contact removed from file successfully!");
        } else {
            System.out.println("Contact ID not found.");
        }
    }
}
