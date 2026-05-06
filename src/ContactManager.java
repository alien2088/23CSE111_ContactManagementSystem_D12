import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contactList;
    private int nextId;

    public ContactManager() {
        contactList = new ArrayList<>();
        nextId = 1;
    }

    public int getNextId() {
        return nextId;
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
        nextId++;
    }

    public void updateContact(Contact updatedContact) {
        for (int i = 0; i < contactList.size(); i++) {

            if (contactList.get(i).getContactId() == updatedContact.getContactId()) {

                contactList.set(i, updatedContact);

                System.out.println("Contact updated successfully.");
                return;
            }
        }

        System.out.println("Contact with ID " + updatedContact.getContactId() + " not found.");
    }

    public void deleteContact(int contactId) {
        for (int i = 0; i < contactList.size(); i++) {

            if (contactList.get(i).getContactId() == contactId) {
                System.out.println("Deleted contact: " + contactList.get(i).getName());
                contactList.remove(i);
                return;
            }
        }
        System.out.println("Contact with ID " + contactId + " not found.");
    }

    public void searchContact(String keyword) {
        boolean found = false;

        System.out.println("\nSearch Results for: " + keyword);

        for (Contact c : contactList) {

            if (c.getName().toLowerCase().contains(keyword.toLowerCase()) || c.getPhoneNumber().contains(keyword)) {
                c.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching contacts found.");
        }
    }

    public void displayContacts() {

        if (contactList.isEmpty()) {
            System.out.println("\nNo contacts available.\n");
            return;
        }

        System.out.println(
            "\nAll Contacts (" + contactList.size() + ")"
        );

        for (Contact c : contactList) {
            c.display();
        }
    }

    public Contact viewContact(int contactId) {

        for (Contact c : contactList) {

            if (c.getContactId() == contactId) {
                return c;
            }
        }

        return null;
    }

    public int getTotalContacts() {
        return contactList.size();
    }
}
