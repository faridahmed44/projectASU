package project;

import java.util.Scanner;
public class Organizer extends person{
    private wallet wallet;

    public Organizer() {

            this.wallet = new wallet(0.0);

    }

    public Organizer(String username, String password,double balance) {
        super(username,password);
       this.wallet = new wallet(balance);

    }

    public Organizer(String username, String password, String name, double balance) {
    }

    @Override
    public String Role() {

        return "Oragnizer";

    }


    public void CreateNewEvent(){
        System.out.println("Enter event title : ");
        Scanner input = new Scanner(System.in);
        String eventTitle = input.nextLine();
        System.out.println("what category is it in ? (Music - Sports - Tech - Art - Comedy - Other)  : ");
        String category = input.nextLine();
        System.out.println("what date is it in ? (DD-MM-YYYY) : ");
        String date = input.nextLine();
        System.out.println("what is the price of a ticket: ");
        double pricing= input.nextDouble();
        Events event = new Events(eventTitle,category,date,this,pricing);
        Database.EVENT.add(event);
        System.out.println("Event created successfully !! ");
    }


    @Override
    public String toString() {
        return "Username: " + getUsername() +
                "\nwallet balance: $"+getWallet()+
                "\nRole: " + Role() +
                "\n-------------------------\n";
    }
    public void addToBalance(double amount){
        this.wallet = new wallet(amount);
    }

    Scanner sc = new Scanner(System.in);

    public void EventEdit() {
        while (true) {
            System.out.println("Select the action you want to proceed with:");
            System.out.println("1. Delete an event");
            System.out.println("2. Update an event");
            System.out.println("0. Exit dashboard");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Events available:\n");
                    for (Events e : Database.EVENT) {
                        System.out.println(e);
                    }

                    System.out.println("Enter the title of the event you want to delete:");
                    String nameToDelete = sc.nextLine();

                    boolean deleted = false;
                    for (int i = 0; i < Database.EVENT.size(); i++) {
                        if (Database.EVENT.get(i).getTitle().equals(nameToDelete)) {
                            Database.EVENT.remove(i);
                            System.out.println("Event deleted successfully.");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Event not found.");
                    }
                    break;

                case 2:
                    System.out.println("Events available:\n");
                    for (Events e : Database.EVENT) {
                        System.out.println(e);
                    }

                    System.out.println("Enter the title of the event you want to update:");
                    String nameToUpdate = sc.nextLine();

                    boolean updated = false;
                    for (Events currentEvent : Database.EVENT) {
                        if (currentEvent.getTitle().equals(nameToUpdate)) {
                            updated = true;

                            System.out.println("Do you want to update (1) ticket price or (2) date?");
                            int action = sc.nextInt();
                            sc.nextLine(); // Consume newline

                            if (action == 1) {
                                System.out.println("Enter new ticket price:");
                                double newPrice = sc.nextDouble();
                                sc.nextLine(); // Consume newline

                                if (newPrice > 10 && newPrice < 1000) {
                                    currentEvent.setTicketPrice(newPrice);
                                    System.out.println("Ticket price updated.");
                                } else {
                                    System.out.println("Invalid price. Must be between 10 and 1000.");
                                }

                            } else if (action == 2) {
                                System.out.println("Enter new date (DD-MM-YYYY):");
                                String newDate = sc.nextLine();
                                currentEvent.setDate(newDate);
                                System.out.println("Date updated.");

                            } else {
                                System.out.println("Invalid option.");
                            }

                            break; // Exit loop once updated
                        }
                    }

                    if (!updated) {
                        System.out.println("Event not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting dashboard...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public wallet getWallet() {
        return wallet;
    }

    public void setWallet(wallet wallet) {
        this.wallet = wallet;
    }
    public void viewMyEvents() {
        System.out.println("Events created by " + this.getUsername() + ":");

        for (Events event : Database.EVENT) {
            if (event.getOrganizer().equals(this)) {
                System.out.println("- " + event.getTitle() + " on " + event.getDate());
            }
        }
    }
}
