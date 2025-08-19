package AddressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    private ArrayList<Contacts> contacts;

    // Constructor
    public AddressBook() {
        contacts = new ArrayList<>();
    }

    // Add a new contact
    public void addContact(Contacts contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    // Edit an existing contact by first name
    public void editContactByName() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available to edit.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first name of the contact to edit: ");
        String searchName = sc.nextLine();

        boolean found = false;
        for (Contacts c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(searchName)) {
                found = true;

                System.out.print("Enter new Last Name: ");
                c.setLastName(sc.nextLine());

                System.out.print("Enter new Address: ");
                c.setAddress(sc.nextLine());

                System.out.print("Enter new City: ");
                c.setCity(sc.nextLine());

                System.out.print("Enter new State: ");
                c.setState(sc.nextLine());

                System.out.print("Enter new ZIP: ");
                c.setZip(sc.nextLine());

                System.out.print("Enter new Phone Number: ");
                c.setPhoneNumber(sc.nextLine());

                System.out.print("Enter new Email: ");
                c.setEmail(sc.nextLine());

                System.out.println("Contact updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found with the given first name.");
        }
    }

    // Delete a contact by first name
    public void deleteContactByName() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available to delete.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first name of the contact to delete: ");
        String searchName = sc.nextLine();

        boolean removed = contacts.removeIf(c -> c.getFirstName().equalsIgnoreCase(searchName));

        if (removed) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found with the given first name.");
        }
    }

    // Getter to access contacts
    public ArrayList<Contacts> getContacts() {
        return contacts;
    }
}
