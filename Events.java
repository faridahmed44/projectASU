package project;
import java.util.*;

public class Events  {
    // Event attributes
    private String title;
    private String category;
    private String date;
    private Organizer organizer; // ✅ Use actual object
    private double ticketPrice;
    // Constructors for initializing Events
    public Events() {
    }

    public Events(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Events(String date) {
        this.date = date;
    }

    public Events(String title, String category, String date, Organizer organizer, double ticketPrice) {
        this.title = title;
        this.category = category;
        this.date = date;
        this.organizer = organizer;
        this.ticketPrice = ticketPrice;
    }
    // Override methods from Interface



    public void setTitle(String title) {
        this.title = title;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Organizer getOrganizer() {
        return organizer;
    }


    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }


    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }


    private ArrayList<Attendee> registeredAttendees = new ArrayList<>();

    public void addAttendee(Attendee attendee) {
        registeredAttendees.add(attendee);
    }

    public ArrayList<Attendee> getRegisteredAttendees() {
        return registeredAttendees;
    }


    public String toString() { // Return a summary of event details as a string
        return "Event title: " + title +
                "\nDate: " + date +
                "\nOrganizer: " + (organizer != null ? organizer.getUsername() : "N/A") +
                "\nPricing: $" + ticketPrice +"\n";
    }


    public String getTitle() {
        return title;
    }
}