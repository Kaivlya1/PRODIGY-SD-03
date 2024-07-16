package ContactManagement;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();
        System.out.println("====================================");
        System.out.println(" Welcome to the Contact Management ");
        System.out.println("====================================");
        while (true) {
            System.out.println("\n=====================");
            System.out.println("Contact Management");
            System.out.println("=====================");
            System.out.println("1. Add Contacts");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.println("=====================");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.println("\n--- Add New Contacts ---");
                    System.out.print("How many contacts do you want to add? ");
                    int numberOfContacts = sc.nextInt();
                    sc.nextLine(); 
                    for (int i = 0; i < numberOfContacts; i++) {
                        System.out.println("\n--- Contact " + (i + 1) + " ---");
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = sc.nextLine();
                        System.out.print("Enter E-mail Address: ");
                        String emailAddress = sc.nextLine();
                        contactManager.addContact(new Contact(name, phoneNumber, emailAddress));
                        System.out.println("Contact added successfully!");
                    }
                    break;
                case 2:
                    System.out.println("\n--- Contact List ---");
                    if (contactManager.getContacts().isEmpty()) {
                        System.out.println("No contacts found.");
                    } else {
                        System.out.printf("%-5s%-20s%-20s%-30s\n", "Index", "Name", "Phone Number", "Email Address");
                        System.out.println("--------------------------------------------------------------------------");
                        for (int i = 0; i < contactManager.getContacts().size(); i++) {
                            Contact contact = contactManager.getContacts().get(i);
                            System.out.printf("%-5d%-20s%-20s%-30s\n", (i + 1), contact.getName(), contact.getphoneNumber(), contact.getemailAddress());
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n--- Edit Contact ---");
                    System.out.print("Enter the index of the contact to edit: ");
                    int editIndex = sc.nextInt();
                    sc.nextLine(); 
                    if (editIndex > 0 && editIndex <= contactManager.getContacts().size()) {
                        System.out.print("Enter New Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter New Phone Number: ");
                        String phoneNumber = sc.nextLine();
                        System.out.print("Enter New Email Address: ");
                        String emailAddress = sc.nextLine();
                        contactManager.editContact(editIndex - 1, new Contact(name, phoneNumber, emailAddress));
                        System.out.println("Contact updated successfully!");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 4:
                    System.out.println("\n--- Delete Contact ---");
                    System.out.print("Do you want to delete a single contact or all contacts? (single/all): ");
                    String deleteOption = sc.nextLine().toLowerCase();
                    if (deleteOption.equals("single")) {
                        System.out.print("Enter the index of the contact to delete: ");
                        int deleteIndex = sc.nextInt();
                        sc.nextLine(); 
                        if (deleteIndex > 0 && deleteIndex <= contactManager.getContacts().size()) {
                            contactManager.deleteContact(deleteIndex - 1);
                            System.out.println("Contact deleted successfully!");
                        } else {
                            System.out.println("Invalid index.");
                        }
                    } else if (deleteOption.equals("all")) {
                        contactManager.deleteAllContacts();
                        System.out.println("All contacts deleted successfully!");
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;
                case 5:
                    System.out.println("\nThank you for using Contact Management. Goodbye!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
