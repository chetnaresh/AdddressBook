package AddressBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Dictionary of AddressBookName -> AddressBook object
        Map<String, AddressBook> addressBookSystem = new HashMap<>();

        System.out.println("Welcome to the Address Book System!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a New Address Book");
            System.out.println("2. Add New Contact(s) to an Address Book");
            System.out.println("3. Edit Contact in an Address Book");
            System.out.println("4. Delete Contact in an Address Book");
            System.out.println("5. Show All Contacts in an Address Book");
            System.out.println("6. Show All Address Books");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Address Book Name: ");
                    String bookName = sc.nextLine();

                    if (addressBookSystem.containsKey(bookName)) {
                        System.out.println("Address Book with this name already exists!");
                    } else {
                        addressBookSystem.put(bookName, new AddressBook());
                        System.out.println("Address Book '" + bookName + "' created successfully!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Address Book Name: ");
                    String addBook = sc.nextLine();
                    AddressBook abAdd = addressBookSystem.get(addBook);

                    if (abAdd == null) {
                        System.out.println("No Address Book found with this name!");
                        break;
                    }

                    System.out.print("How many contacts do you want to add? ");
                    int n = sc.nextInt();
                    sc.nextLine(); // consume newline

                    for (int i = 0; i < n; i++) {
                        System.out.println("\nEnter details for Contact " + (i + 1));

                        System.out.print("First Name: ");
                        String firstName = sc.nextLine();

                        System.out.print("Last Name: ");
                        String lastName = sc.nextLine();

                        System.out.print("Address: ");
                        String address = sc.nextLine();

                        System.out.print("City: ");
                        String city = sc.nextLine();

                        System.out.print("State: ");
                        String state = sc.nextLine();

                        System.out.print("Zip: ");
                        String zip = sc.nextLine();

                        System.out.print("Phone Number: ");
                        String phone = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        Contacts contact = new Contacts(firstName, lastName, address, city, state, zip, phone, email);
                        abAdd.addContact(contact);
                    }
                    break;

                case 3:
                    System.out.print("Enter Address Book Name: ");
                    String editBook = sc.nextLine();
                    AddressBook abEdit = addressBookSystem.get(editBook);

                    if (abEdit != null) {
                        abEdit.editContactByName();
                    } else {
                        System.out.println("No Address Book found with this name!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Address Book Name: ");
                    String delBook = sc.nextLine();
                    AddressBook abDel = addressBookSystem.get(delBook);

                    if (abDel != null) {
                        abDel.deleteContactByName();
                    } else {
                        System.out.println("No Address Book found with this name!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Address Book Name: ");
                    String showBook = sc.nextLine();
                    AddressBook abShow = addressBookSystem.get(showBook);

                    if (abShow != null) {
                        System.out.println("\nContacts in Address Book '" + showBook + "':");
                        if (abShow.getContacts().isEmpty()) {
                            System.out.println("No contacts available.");
                        } else {
                            for (Contacts c : abShow.getContacts()) {
                                System.out.println(c);
                            }
                        }
                    } else {
                        System.out.println("No Address Book found with this name!");
                    }
                    break;

                case 6:
                    if (addressBookSystem.isEmpty()) {
                        System.out.println("No Address Books available.");
                    } else {
                        System.out.println("Available Address Books:");
                        for (String name : addressBookSystem.keySet()) {
                            System.out.println("- " + name);
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting Address Book System. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
