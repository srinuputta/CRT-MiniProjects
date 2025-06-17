import java.util.*;

class Contact {
    private String name;
    private String phoneNumber;
    private String address;
    private String mobileName;
    private double mobileCost;
    private double mobileRating;

    public Contact(String name, String phoneNumber, String address, String mobileName, double mobileCost, double mobileRating) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.mobileName = mobileName;
        this.mobileCost = mobileCost;
        this.mobileRating = mobileRating;
    }

    public void displayContact() {
        System.out.println("Name         : " + name);
        System.out.println("Phone        : " + phoneNumber);
        System.out.println("Address      : " + address);
        System.out.println("Mobile Name  : " + mobileName);
        System.out.println("Mobile Cost  : $" + mobileCost);
        System.out.println("Mobile Rating: " + mobileRating + "/5");
        System.out.println("----------------------------");
    }

    public double getMobileCost() {
        return mobileCost;
    }

    public double getMobileRating() {
        return mobileRating;
    }
}

public class PhoneBookApp {
    private static ArrayList<Contact> phoneBook = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Phone Book Menu ===");
            System.out.println("1. Add New Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Sort by Mobile Cost");
            System.out.println("4. Sort by Mobile Rating");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    sortByMobileCost();
                    break;
                case 4:
                    sortByMobileRating();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting Phone Book. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Mobile Name: ");
        String mobileName = scanner.nextLine();

        System.out.print("Enter Mobile Cost: ");
        double mobileCost = scanner.nextDouble();

        System.out.print("Enter Mobile Rating (out of 5): ");
        double mobileRating = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Contact contact = new Contact(name, phoneNumber, address, mobileName, mobileCost, mobileRating);
        phoneBook.add(contact);

        System.out.println("Contact added successfully!");
    }

    private static void viewContacts() {
        if (phoneBook.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\n--- Contact List ---");
            for (Contact contact : phoneBook) {
                contact.displayContact();
            }
        }
    }

    private static void sortByMobileCost() {
        if (phoneBook.isEmpty()) {
            System.out.println("No contacts to sort.");
            return;
        }

        phoneBook.sort(Comparator.comparingDouble(Contact::getMobileCost));
        System.out.println("Contacts sorted by Mobile Cost (Low to High):");
        viewContacts();
    }

    private static void sortByMobileRating() {
        if (phoneBook.isEmpty()) {
            System.out.println("No contacts to sort.");
            return;
        }

        phoneBook.sort((c1, c2) -> Double.compare(c2.getMobileRating(), c1.getMobileRating()));
        System.out.println("Contacts sorted by Mobile Rating (High to Low):");
        viewContacts();
    }
}
