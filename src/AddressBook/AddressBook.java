package AddressBook;

import java.util.ArrayList;

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

    // Getter to access contacts
    public ArrayList<Contacts> getContacts() {
        return contacts;
    }
}
