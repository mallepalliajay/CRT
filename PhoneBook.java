import java.util.Scanner;
import java.util.ArrayList;

class Contact {
    private String name;
    private String phoneNumber;
    private String address;
    private String email;

    public Contact(String name, String phoneNumber, String address, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + 
               ", Phone: " + phoneNumber + 
               ", Address: " + address + 
               ", Email: " + email;
    }
}

class PhonebookManager {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String phoneNumber, String address, String email) {
        contacts.add(new Contact(name, phoneNumber, address, email));
        System.out.println("Contact added successfully.");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.");
            return;
        }
        System.out.println("\n--- Contact List ---");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public void searchContact(String keyword) {
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(keyword) || 
                c.getPhoneNumber().equals(keyword) || 
                c.getEmail().equalsIgnoreCase(keyword)) {
                System.out.println("Found: " + c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String name) {
        boolean removed = contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhonebookManager manager = new PhonebookManager();
        int choice;

        do {
            System.out.println("\n--- Phonebook Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    manager.addContact(name, phone, address, email);
                    break;

                case 2:
                    manager.viewContacts();
                    break;

                case 3:
                    System.out.print("Enter name, phone number, or email to search: ");
                    String keyword = scanner.nextLine();
                    manager.searchContact(keyword);
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    String nameToDelete = scanner.nextLine();
                    manager.deleteContact(nameToDelete);
                    break;

                case 5:
                    System.out.println("Exiting Phonebook.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
