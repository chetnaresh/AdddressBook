package AddressBook;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Welcome to the Address Book Program!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add New Contact(s)");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Show All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
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
                        addressBook.addContact(contact);
                    }
                    break;

                case 2:
                    addressBook.editContactByName();
                    break;

                case 3:
                    addressBook.deleteContactByName();
                    break;

                case 4:
                    System.out.println("\nContacts in Address Book:");
                    if (addressBook.getContacts().isEmpty()) {
                        System.out.println("No contacts available.");
                    } else {
                        for (Contacts c : addressBook.getContacts()) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting Address Book. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
