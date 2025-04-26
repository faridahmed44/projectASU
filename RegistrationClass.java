package project;

import java.util.Scanner;

public class RegistrationClass {
    private Scanner scanner = new Scanner(System.in);

    public void registerAdmin() {
        System.out.println("\n--- Admin Registration ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter birth date: ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter work hours: ");
        String workHours = scanner.nextLine();
        Admin newAdmin = new Admin(username, password, birthDate, workHours);
        Database.getAdmins().add(newAdmin);
        System.out.println("Admin registered successfully!");
    }

    public void registerOrganizer() {
        System.out.println("\n--- Organizer Registration ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter organizer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter starting wallet balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume leftover newline

        Organizer newOrganizer = new Organizer(username, password, name, balance);
        Database.getOrganizers().add(newOrganizer);
        System.out.println("Organizer registered successfully!");
    }

    public void registerAttendee() {
        System.out.println("\n--- Attendee Registration ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter birth date: ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter wallet balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter gender (MALE/FEMALE): ");
        String genderInput = scanner.nextLine();
        Attendee.Gender gender = Attendee.Gender.valueOf(genderInput.toUpperCase());
        System.out.print("Enter favorite category: ");
        String favoriteCategory = scanner.nextLine();

        Attendee newAttendee = new Attendee(username, password, birthDate, balance, city, gender, favoriteCategory);
        Database.getAttendees().add(newAttendee);
        System.out.println("Attendee registered successfully!");
    }
}