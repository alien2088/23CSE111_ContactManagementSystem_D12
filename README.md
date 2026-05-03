# Contact_Management_System

Course: 23CSE111 – Object Oriented Programming  
Program: S2 B.Tech CSE | Amrita School of Computing, Amritapuri  
Case Study: Phase I II & III| Group No: D12

## Team Members

| Roll No | Name |

| AM.SC.U4CSE25359 | Abel Binu Varghese |
| AM.SC.U4CSE25360 | Alien Lakshmi C |
| AM.SC.U4CSE25366 | Kasinath V |
| AM.SC.U4CSE25368 | Devananda J A |


## Problem Description

A Contact Management System to store and manage personal and business contacts digitally.  
Users can add, update, delete, and search contacts. All data is persisted to files across sessions.


##  How to Run

### Prerequisites
- Java JDK 8 or above installed
- Terminal / Command Prompt

### Steps

# 1. Clone the repository
git clone https://github.com/<your-username>/ContactManagementSystem.git
cd ContactManagementSystem/src

# 2. Compile all Java files
javac *.java

# 3. Run the program
java Main

### Default Login Credentials
Username : admin
Password : admin123

## Class Overview

### User.java
- Handles login with `validateCredentials()`
- Logs every login and logout to `log.txt` with timestamp using `LocalDateTime`

### Contact.java
- Stores all 7 contact fields
- `toFileString()` converts the object to a CSV line for file storage
- `display()` prints a formatted box to the console

### ContactManager.java
- `addContact()` — appends to `contacts.txt` using `FileWriter(file, true)`
- `displayContacts()` / `searchContact()` — reads file using `BufferedReader`
- `updateContact()` / `deleteContact()` — loads entire file, modifies, overwrites

### Category.java
- `createCategory()` — saves category to `categories.txt`
- `assignCategory(contact)` — appends contact-category mapping to file

##  File Format

### contacts.txt
Each line stores one contact in comma-separated format:

### log.txt
Each line records a timestamped login or logout

# Sample Input / Output
==========================================
       CONTACT MANAGEMENT SYSTEM         
==========================================
Enter Username : admin
Enter Password : admin123

Login successful! Welcome, admin!

------------------------------------------
                MAIN MENU                
------------------------------------------
1. Add Contact
2. View All Contacts
3. Search Contact
4. Edit Contact
5. Delete Contact
6. Logout
Enter choice: 1

--- ADD CONTACT ---
Name     : Devananda JA
Phone    : 9876543210
Email    : devanandaja@gmail.com
Address  : Green Valley appartments
Birthday : 11 November 2006
Company  : Google
Contact saved to file successfully!
Contact added with ID: 1

------------------------------------------
                MAIN MENU                
------------------------------------------
1. Add Contact
2. View All Contacts
3. Search Contact
4. Edit Contact
5. Delete Contact
6. Logout
Enter choice: 2

========== ALL CONTACTS (1) ==========
+------------------------------------------+
| ID       : 1                              |
| Name     : Devananda JA                   |
| Phone    : 9876543210                     |
| Email    : devanandaja@gmail.com          |
| Address  : Green Valley appartments       |
| Birthday : 11 November 2006               |
| Company  : Google                         |
+------------------------------------------+
------------------------------------------
                MAIN MENU                
------------------------------------------
1. Add Contact
2. View All Contacts
3. Search Contact
4. Edit Contact
5. Delete Contact
6. Logout
Enter choice: 3

--- SEARCH CONTACT ---
Enter name or phone: Devananda JA

--- Search Results for: "Devananda JA" ---
+------------------------------------------+
| ID       : 1                              |
| Name     : Devananda JA                   |
| Phone    : 9876543210                     |
| Email    : devanandaja@gmail.com          |
| Address  : Green Valley appartments       |
| Birthday : 11 November 2006               |
| Company  : Google                         |
+------------------------------------------+
------------------------------------------
                MAIN MENU                
------------------------------------------
1. Add Contact
2. View All Contacts
3. Search Contact
4. Edit Contact
5. Delete Contact
6. Logout
Enter choice: 9876543210
Invalid choice. Try again.
------------------------------------------
                MAIN MENU                
------------------------------------------
1. Add Contact
2. View All Contacts
3. Search Contact
4. Edit Contact
5. Delete Contact
6. Logout
Enter choice: 3

--- SEARCH CONTACT ---
Enter name or phone: 9876543210

--- Search Results for: "9876543210" ---
+------------------------------------------+
| ID       : 1                              |
| Name     : Devananda JA                   |
| Phone    : 9876543210                     |
| Email    : devanandaja@gmail.com          |
| Address  : Green Valley appartments       |
| Birthday : 11 November 2006               |
| Company  : Google                         |
+------------------------------------------+
------------------------------------------
                MAIN MENU                
------------------------------------------
1. Add Contact
2. View All Contacts
3. Search Contact
4. Edit Contact
5. Delete Contact
6. Logout
Enter choice: 4

--- EDIT CONTACT ---
Enter Contact ID to edit: 1
Leave blank to keep current value.

Name     [Devananda JA]: 
Phone    [9876543210]: 
Email    [devanandaja@gmail.com]: 
Address  [Green Valley appartments]: 
Birthday [11 November 2006]: 
Company  [Google]: Microsoft
Contact updated in file successfully!

------------------------------------------
                MAIN MENU                
------------------------------------------
1. Add Contact
2. View All Contacts
3. Search Contact
4. Edit Contact
5. Delete Contact
6. Logout
Enter choice: 5

--- DELETE CONTACT ---
Enter Contact ID to delete: 1
Deleted: Devananda JA
Contact removed from file successfully!

------------------------------------------
                MAIN MENU                
------------------------------------------
1. Add Contact
2. View All Contacts
3. Search Contact
4. Edit Contact
5. Delete Contact
6. Logout
Enter choice: 6
Goodbye, admin! Your session has been logged.

## Tools/Techniques used

| Concept | Where Applied |

| **Encapsulation** | All fields `private`; accessed via getters and setters |
| **Abstraction** | File I/O logic hidden inside `private` helper methods |
| **Constructors** | Parameterized constructors in all 4 classes |
| **`this` keyword** | Resolves variable shadowing in constructors |
| **ArrayList** | Dynamic contact list in `ContactManager` |
| **Exception Handling** | `try-catch IOException` on all file operations |
| **File Handling** | `FileWriter`, `BufferedReader`, `FileReader` across multiple classes |
| **`@Override`** | Custom `toString()` in `Contact` and `User` |



