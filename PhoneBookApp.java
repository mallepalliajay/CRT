import java.util.ArrayList;
import java.util.Scanner;

// Contact class to store name, phone, email
class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }

    // Display contact info
    public void displayContact() {
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("----------------------");
    }
}

// Main application class
public class PhoneBookApp {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nPhonebook Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting Phonebook. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);
    }

    // Add a new contact
    private static void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phoneNumber, email));
        System.out.println("Contact added successfully.");
    }

    // View all contacts
    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.");
            return;
        }

        System.out.println("\nAll Contacts:");
        for (Contact c : contacts) {
            c.displayContact();
        }
    }

    // Search for a contact by name
    private static void searchContact() {
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Contact Found:");
                c.displayContact();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No contact found with name: " + searchName);
        }
    }

    // Delete a contact by name
    private static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String nameToDelete = scanner.nextLine();
        boolean removed = contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(nameToDelete));

        if (removed) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
