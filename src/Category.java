import java.io.FileWriter;
import java.io.IOException;

public class Category {
    private int categoryId;
    private String categoryName;

    // Constructor
    public Category(int categoryId, String categoryName) {
        this.categoryId   = categoryId;
        this.categoryName = categoryName;
    }

    public void createCategory() {
        try (FileWriter fw = new FileWriter("categories.txt", true)) { 
            fw.write(categoryId + "," + categoryName + "\n");
            System.out.println("Category '" + categoryName + "' saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving category: " + e.getMessage());
        }
    }
    
    public void assignCategory(Contact contact) {
        try (FileWriter fw = new FileWriter("categories.txt", true)) {  
            fw.write(categoryId + "," + categoryName + "," + contact.getContactId()
                    + "," + contact.getName() + "\n");
            System.out.println("Contact '" + contact.getName() +
                    "' assigned to category '" + categoryName + "' and saved.");
        } catch (IOException e) {
            System.out.println("Error assigning category: " + e.getMessage());
        }
    }

    public int    getCategoryId()   { return categoryId; }
    public String getCategoryName() { return categoryName; }
}
