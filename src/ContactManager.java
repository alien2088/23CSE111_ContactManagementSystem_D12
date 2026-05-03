import java.util.ArrayList;

/**
 * ContactManager class
 * Handles all operations: add, update, delete, search, display contacts.
 * Uses an ArrayList as the contact list (in-memory storage).
 */
public class ContactManager {
    private ArrayList<Contact> contactList;
    private int nextId;

    // Constructor
    public ContactManager() {
        contactList = new ArrayList<>();
        nextId = 1;
    }

    // Get next available ID (auto-increment)
    public int getNextId() {
        return nextId;
    }

    // Add a new contact
    public void addContact(Contact contact) {
        contactList.add(contact);
        nextId++;
    }

    // Update an existing contact (replaces entry by contactId)
    public void updateContact(Contact updatedContact) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getContactId() == updatedContact.getContactId()) {
                contactList.set(i, updatedContact);
                return;
            }
        }
        System.out.println("✘ Contact with ID " + updatedContact.getContactId() + " not found.");
    }

    // Delete contact by ID
    public void deleteContact(int contactId) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getContactId() == contactId) {
                System.out.println("✔ Deleted: " + contactList.get(i).getName());
                contactList.remove(i);
                return;
            }
        }
        System.out.println("✘ Contact with ID " + contactId + " not found.");
    }

    // Search contacts by name or phone number (case-insensitive)
    public void searchContact(String keyword) {
        boolean found = false;
        System.out.println("\n--- Search Results for: \"" + keyword + "\" ---");
        for (Contact c : contactList) {
            if (c.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                c.getPhoneNumber().contains(keyword)) {
                c.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("✘ No contacts found matching \"" + keyword + "\".\n");
        }
    }

    // Display all contacts
    public void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("\n✘ No contacts available.\n");
            return;
        }
        System.out.println("\n========== ALL CONTACTS (" + contactList.size() + ") ==========");
        for (Contact c : contactList) {
            c.display();
        }
    }

    // View a single contact by ID (returns null if not found)
    public Contact viewContact(int contactId) {
        for (Contact c : contactList) {
            if (c.getContactId() == contactId) {
                return c;
            }
        }
        return null;
    }

    // Get total number of contacts
    public int getTotalContacts() {
        return contactList.size();
    }
}
