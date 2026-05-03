import java.util.ArrayList;

/**
 * Category class
 * Groups contacts into types like Personal, Business, Family, etc.
 * Methods: createCategory(), assignCategory()
 */
public class Category {
    private int categoryId;
    private String categoryName;
    private ArrayList<Contact> contactsInCategory;

    // Constructor
    public Category(int categoryId, String categoryName) {
        this.categoryId          = categoryId;
        this.categoryName        = categoryName;
        this.contactsInCategory  = new ArrayList<>();
    }

    // Create/display category info
    public void createCategory() {
        System.out.println("✔ Category created: [" + categoryId + "] " + categoryName);
    }

    // Assign a contact to this category
    public void assignCategory(Contact contact) {
        contactsInCategory.add(contact);
        System.out.println("✔ Contact '" + contact.getName() +
                           "' assigned to category '" + categoryName + "'.");
    }

    // Display all contacts in this category
    public void displayCategoryContacts() {
        System.out.println("\n--- Category: " + categoryName + " ---");
        if (contactsInCategory.isEmpty()) {
            System.out.println("  (No contacts in this category)");
        } else {
            for (Contact c : contactsInCategory) {
                System.out.println("  • " + c.getName() + " | " + c.getPhoneNumber());
            }
        }
    }

    // Getters
    public int    getCategoryId()   { return categoryId; }
    public String getCategoryName() { return categoryName; }
    public ArrayList<Contact> getContacts() { return contactsInCategory; }

    @Override
    public String toString() {
        return "Category{ID=" + categoryId + ", Name='" + categoryName +
               "', Contacts=" + contactsInCategory.size() + "}";
    }
}
