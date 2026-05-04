# 23CSE113_ContactManagementSystem_D12

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
# Sample Input / Output

---

## Login

**Input:**
```
Enter Username : admin
Enter Password : admin123
```
**Output:**
```
==========================================
       CONTACT MANAGEMENT SYSTEM         
==========================================
Login successful! Welcome, admin!
```

---

## Main Menu
```
------------------------------------------
                MAIN MENU                
------------------------------------------
1. Add Contact
2. View All Contacts
3. Search Contact
4. Edit Contact
5. Delete Contact
6. Logout
Enter choice:
```

---

##  1. Add Contact

**Input:**
```
Enter choice: 1

--- ADD CONTACT ---
Name     : Alien Lakshmi
Phone    : 9876543210
Email    : alien@gmail.com
Address  : Kochi Kerala
Birthday : 2005-03-15
Company  : Amrita
```
**Output:**
```
Contact saved to file successfully!
Contact added with ID: 1
```

---

## 2. View All Contacts

**Input:**
```
Enter choice: 2
```
**Output:**
```
========== ALL CONTACTS (3) ==========
+------------------------------------------+
| ID       : 1                              |
| Name     : Alien Lakshmi                  |
| Phone    : 9876543210                     |
| Email    : alien@gmail.com                |
| Address  : Kochi Kerala                   |
| Birthday : 2005-03-15                     |
| Company  : Amrita                         |
+------------------------------------------+
+------------------------------------------+
| ID       : 2                              |
| Name     : Abel Binu Varghese             |
| Phone    : 9123456789                     |
| Email    : abel@gmail.com                 |
| Address  : Trivandrum                     |
| Birthday : 2004-11-20                     |
| Company  : Amrita                         |
+------------------------------------------+
+------------------------------------------+
| ID       : 3                              |
| Name     : Kasinath V                     |
| Phone    : 9988776655                     |
| Email    : kasinath@gmail.com             |
| Address  : Ernakulum                      |
| Birthday : 2005-07-08                     |
| Company  : Amrita                         |
+------------------------------------------+
```

---

## 3. Search Contact

**Input:**
```
Enter choice: 3

--- SEARCH CONTACT ---
Enter name or phone: Alien
```
**Output:**
```
--- Search Results for: "Alien" ---
+------------------------------------------+
| ID       : 1                              |
| Name     : Alien Lakshmi                  |
| Phone    : 9876543210                     |
| Email    : alien@gmail.com                |
| Address  : Kochi Kerala                   |
| Birthday : 2005-03-15                     |
| Company  : Amrita                         |
+------------------------------------------+
```

---

## 4. Edit Contact

**Input:**
```
Enter choice: 4

--- EDIT CONTACT ---
Enter Contact ID to edit: 2
Leave blank to keep current value.

Name     [Abel Binu]: Abel Binu Varghese
Phone    [9123456789]:
Email    [abel@gmail.com]:
Address  [Trivandrum]:
Birthday [2004-11-20]:
Company  [Amrita]:
```
**Output:**
```
Contact updated in file successfully!
```

---

## 5. Delete Contact

**Input:**
```
Enter choice: 5

--- DELETE CONTACT ---
Enter Contact ID to delete: 3
```
**Output:**
```
Deleted: Kasinath V
Contact removed from file successfully!
```

---

## 6. Logout

**Input:**
```
Enter choice: 6
```
**Output:**
```
Goodbye, admin! Your session has been logged.
```

---

## Generated File Contents

### `contacts.txt` (after session)
```
1,Alien Lakshmi,9876543210,alien@gmail.com,Kochi Kerala,2005-03-15,Amrita
2,Abel Binu Varghese,9123456789,abel@gmail.com,Trivandrum,2004-11-20,Amrita
```

### `log.txt` (after session)
```
[03-05-2026 16:36:40] LOGIN  - User 'admin' logged in.
[03-05-2026 16:36:40] LOGOUT - User 'admin' logged out.
```

---

## Invalid Login Attempt

**Input:**
```
Enter Username : admin
Enter Password : wrongpass
```
**Output:**
```
Invalid credentials. Try again.
```

---

## Search — Not Found

**Input:**
```
Enter name or phone: Devananda
```
**Output:**
```
--- Search Results for: "Devananda" ---
No contact found matching "Devananda".
```

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



