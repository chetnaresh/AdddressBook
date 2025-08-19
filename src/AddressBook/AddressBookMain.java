package AddressBook;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Welcome to the Address Book Program!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add New Contact");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    System.out.print("Enter State: ");
                    String state = sc.nextLine();
                    System.out.print("Enter Zip: ");
                    String zip = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    // Create a new contact object and add it
                    Contacts contact = new Contacts(firstName, lastName, address, city, state, zip, phone, email);
                    addressBook.addContact(contact);
                    break;

                case 2:
                    System.out.println("Exiting Address Book. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
