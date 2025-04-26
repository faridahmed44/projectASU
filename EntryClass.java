package project;
import java.util.ArrayList;
import java.util.Scanner;

public class EntryClass {
    Scanner input = new Scanner(System.in);
    Database database = new Database();

    public Admin loginAdmin() {
        System.out.println("Enter your username:");
        String username = input.next();
        System.out.println("Enter your password:");
        String password = input.next();

        ArrayList<Admin> admins = database.getAdmins();
        for (Admin a : admins) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                System.out.println("Valid username and password\n");
                System.out.println("Welcome " + username+ " !");
                return a;  // return the matched Admin
            }
        }
        return null; // login failed
    }

    public Organizer loginOrganizer() {
        System.out.println("Enter your username:");
        String username = input.next();
        System.out.println("Enter your password:");
        String password = input.next();

        ArrayList<Organizer> organizers = database.getOrganizers();
        for (Organizer o : organizers) {
            if (o.getUsername().equals(username) && o.getPassword().equals(password)) {
                System.out.println("Valid username and password\n");
                System.out.println("Welcome " + username + " !");
                return o;  // return the matched Organizer
            }
        }
        return null;
    }

    public Attendee loginAttendee() {
        System.out.println("Enter your username:");
        String username = input.next();
        System.out.println("Enter your password:");
        String password = input.next();

        ArrayList<Attendee> attendees = database.getAttendees();
        for (Attendee a : attendees) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                System.out.println("Valid username and password\n");
                System.out.println("Welcome " + username+ " !");
                return a;  // return the matched Attendee
            }
        }
        return null;
    }

    public Admin signupAdmin(){
        return null;
    }
    public Attendee signupAttendee(){
        return null;
    }
    public Organizer signupOrganizer(){
        return null;
    }

    


}

