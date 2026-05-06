import java.util.ArrayList;

public class Category {
    private int categoryId;
    private String categoryName;
    private ArrayList<Contact> contactsInCategory;

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.contactsInCategory = new ArrayList<>();
    }

    public void createCategory() {
        System.out.println("Category created: " + categoryName);
    }

    // Assign a contact to the category (Aggregation)
    public void assignCategory(Contact contact) {
        contactsInCategory.add(contact);

        System.out.println(
            contact.getName() + " added to " + categoryName + " category."
        );
    }

    public void displayCategoryContacts() {
        System.out.println("\nCategory: " + categoryName);

        if (contactsInCategory.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact c : contactsInCategory) {
                System.out.println(c.getName() + " - " + c.getPhoneNumber());
            }
        }
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ArrayList<Contact> getContacts() {
        return contactsInCategory;
    }

    @Override
    public String toString() {
        return "Category ID: " + categoryId +
               ", Name: " + categoryName +
               ", Total Contacts: " + contactsInCategory.size();
    }
}
