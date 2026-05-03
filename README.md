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


##  Project Structure

ContactManagementSystem/
├── src/
│   ├── Main.java            # Entry point — login flow and menu loop
│   ├── User.java            # Login, logout, timestamp-based activity logging
│   ├── Contact.java         # Contact data model with file serialization
│   ├── ContactManager.java  # All CRUD operations with file read/write
│   └── Category.java        # Category grouping saved to file
├── data/                    # Auto-created when program runs
│   ├── contacts.txt         # All contact records (CSV format)
│   ├── log.txt              # Login/logout audit trail with timestamps
│   └── categories.txt       # Category assignments
├── docs/
│   ├── PHASE I OOP
│   └── PHASE II OOP
└── README.md


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


## Features

Feature : Description 

 Add Contact : Enter all contact details; saved instantly to `contacts.txt` 
 View All Contacts : Reads and displays all records from file in a formatted box 
 Search Contact : Case-insensitive search by name or phone number 
 Edit Contact : Load contact by ID, update any field, overwrite file 
 Delete Contact : Remove contact by ID, overwrite file 
 File Persistence : Data survives between program runs (stored in `contacts.txt`) 
 Activity Logging : Every login/logout timestamped and saved to `log.txt` 
 Category Support : Assign contacts to categories; saved to `categories.txt`

##  File Format

### contacts.txt
Each line stores one contact in comma-separated format:

### log.txt
Each line records a timestamped login or logout

## OOP Concepts Used

| Concept | Where Applied |

| **Encapsulation** | All fields `private`; accessed via getters and setters |
| **Abstraction** | File I/O logic hidden inside `private` helper methods |
| **Constructors** | Parameterized constructors in all 4 classes |
| **`this` keyword** | Resolves variable shadowing in constructors |
| **ArrayList** | Dynamic contact list in `ContactManager` |
| **Exception Handling** | `try-catch IOException` on all file operations |
| **File Handling** | `FileWriter`, `BufferedReader`, `FileReader` across multiple classes |
| **`@Override`** | Custom `toString()` in `Contact` and `User` |


## 📄 Class Overview

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


## 📚 Documents

| Document | Description |
|---|---|
| `docs/Phase1_Analysis.docx` | Problem identification, class mapping, attributes & behaviours |
| `docs/Phase2_Design_Implementation.docx` | Class diagram, use cases, sequence diagrams, code snippets, OOP concepts |
