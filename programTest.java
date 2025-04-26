package project;


import java.util.ArrayList;
import java.util.Scanner;
public class programTest {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        Database.initializeDummyData();
        runDashboard();
    }

    public static void runDashboard() {
        while (true) {
            System.out.println("\n=== Welcome to the Event Management System ===");
            System.out.print("Select your role or exit:\n ");
            System.out.println("1. Admin Login");
            System.out.println("2. Organizer Login");
            System.out.println("3. Attendee Login");
            System.out.println("4. Register for the first time");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    EntryClass entryClass= new EntryClass();
                    Admin loggedAdmin = entryClass.loginAdmin();
                    if (loggedAdmin != null) {
                        adminDashboard(loggedAdmin);
                    } else {
                        System.out.println("Invalid username or password, please try again");
                    }
                    break;
                case 2:
                    EntryClass entryClass2 = new EntryClass();
                    Organizer loggedOrganizer =entryClass2.loginOrganizer();
                    if (loggedOrganizer != null) {
                        organizerDashboard(loggedOrganizer);
                    } else {
                        System.out.println("Invalid username or password, please try again");
                    }
                    break;
                case 3:
                    EntryClass entryClass3 = new EntryClass();
                    Attendee loggedAttendee = entryClass3.loginAttendee();
                    if (loggedAttendee != null) {
                        attendeeDashboard(loggedAttendee);
                    } else {
                        System.out.println("Invalid username or password, please try again");
                    }
                    break;
                case 4:
                    RegistrationClass register = new RegistrationClass();
                    System.out.println("\n--- Choose Role to Register ---");
                    System.out.println("1. Admin");
                    System.out.println("2. Organizer");
                    System.out.println("3. Attendee");
                    int regChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (regChoice) {
                        case 1: register.registerAdmin(); break;
                        case 2: register.registerOrganizer(); break;
                        case 3: register.registerAttendee(); break;
                        default: System.out.println("Invalid choice.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void adminDashboard(Admin admin) {
        while (true) {
            System.out.println("\n=== Admin Dashboard ===");
            System.out.print("Select an action: ");
            System.out.println("Logged in as: " + admin.getUsername());
            System.out.println("1. Show All Data");
            System.out.println("2. Add Rooms ");
            System.out.println("3. edit categories ");

            System.out.println("0. Back");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    showAll();
                    break;
                case 2:
                    admin.Addrooms();
                    break;
                case 3:
                    admin.CategoryEdit();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void organizerDashboard(Organizer organizer) {
        while (true) {
            System.out.println("\n=== Organizer Dashboard ===");
            System.out.println("Logged in as: " + organizer.getUsername());
            System.out.print("Select an action:\n ");
            System.out.println("1. Show My Events ");
            System.out.println("2. Create New Event");
            System.out.println("3. Edit events");
            System.out.println("4. Rent a room");
            System.out.println("0. Back");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewAttendeesForMyEvents(organizer);
                    organizer.viewMyEvents();

                    break;
                case 2:
                    organizer.CreateNewEvent();
                    break;
                case 3:
                    organizer.EventEdit();
                    break;
                case 4:
                    showRooms();
                    System.out.println("Enter the room you want to rent:");
                    String roomno = scanner.nextLine();
                    boolean found = false;

                    for (rooms r : Database.room) {
                        if (r.getRoomNumber().equals(roomno)) {
                            found = true;
                            if (r.isAvailable()) {
                                r.setAvailable(false);
                                System.out.println("Room rented successfully");
                            } else {
                                System.out.println("Room is already rented");
                            }
                            break; // Stop loop once room is found
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid room number");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    private static void viewAttendeesForMyEvents(Organizer organizer) {
        boolean hasEvents = false;
        for (Events e : Database.EVENT) {
            if (e.getOrganizer().equals(organizer)) {
                hasEvents = true;
                System.out.println("\nEvent: " + e.getTitle());
                ArrayList<Attendee> attendees = e.getRegisteredAttendees();
                if (attendees.isEmpty()) {
                    System.out.println("  No attendees yet.");
                } else {
                    for (Attendee a : attendees) {
                        System.out.println("  - " + a.getUsername());
                    }
                }
            }
        }
        if (!hasEvents) {
            System.out.println("You don't have any events created yet.");
        }
    }

    private static void showAll() {

        System.out.println("\n=== All Events ===");
        System.out.println("1. Show All Events");
        System.out.println("2. show All Organizers");
        System.out.println("3. Show All Attendees");
        System.out.println("4. Show All categories");


        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                for (Events e : Database.EVENT)
                    System.out.print(e);
                break;
            case 2:
                for (Organizer or : Database.organizers)
                    System.out.print(or);
                break;
            case 3:
                for (Attendee a : Database.attendees)
                    System.out.print(a);
                break;
            case 4:
                for (category c : Database.categories)
                    System.out.print(c);
                break;

            default:
                System.out.println("Invalid choice.");
                break;

        }


    }


    private static void showRooms() {
        System.out.println("\n=== Rooms ===");
        if (Database.room.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            for (rooms r : Database.room) {
                if (r.isAvailable()) {  // Assuming you have an isAvailable() method
                    System.out.println(r);
                }
            }
        }
    }


    public static void attendeeDashboard(Attendee attendee) {
        while (true) {
            System.out.println("\n=== Attendee Dashboard ===");
            System.out.println("Logged in as: " + attendee.getUsername());
            System.out.println("1. View Events");
            System.out.println("2. Buy Ticket");
            System.out.println("3. View Wallet Balance");
            System.out.println("0. Back");
            System.out.print("Select an action: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Available Events:");
                    for (int i = 0; i < Database.EVENT.size(); i++) {
                        System.out.println((i + 1) + ". " + Database.EVENT.get(i));
                    }
                    break;
                case 2:
                    System.out.println("Available Events:");
                    for (int i = 0; i < Database.EVENT.size(); i++) {
                        System.out.println((i + 1) + ". " + Database.EVENT.get(i));
                    }
                    System.out.print("Select an event to buy ticket: ");
                    int eventIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    attendee.buyTicket(Database.EVENT.get(eventIndex));
                    break;
                case 3:
                    System.out.println("\n\n Wallet Balance: $" + attendee.getBalance());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}




