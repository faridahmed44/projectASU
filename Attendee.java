package project;

public class Attendee extends person implements Interface {

    private wallet wallet;
    private String address;
    private Gender gender;
    private String interests;


    enum Gender {
        MALE, FEMALE
    }

    public Attendee(String username, String pass, String dateofbirth, double balance, String address, Gender gender) {
        super(username, pass, dateofbirth);
        this.wallet = new wallet(balance);
        this.address = address;
        this.gender = gender;
        this.interests = "N/A";
    }

    public Attendee() {
        this.wallet = new wallet(0.0);
    }

    public Attendee(String username, String password, String dateOfBirth, double balance, String address, Gender gender, String interests) {
        super(username, password, dateOfBirth);
        this.wallet = new wallet(balance);
        this.address = address;
        this.gender = gender;
        this.interests = interests;
    }

    public String Role() {
        return "Attendee";
    }

    public void setBalance(double balance) {
        this.wallet = new wallet(balance);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public double getBalance() {
        return wallet.getBalance();
    }

    public String getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    public String getInterests() {
        return interests;
    }

    @Override
    public String toString() {
        return "Username: " + getUsername() +
                "\nAddress: " + address +
                "\nGender: " + gender +
                "\nInterests: " + interests +
                "\nBalance: $" + getBalance() +
                "\nRole: " + Role() +
                "\n-------------------------\n";
    }


    public boolean login(String username, String password) {
        return getUsername().equals(username) && getPassword().equals(password);
    }


    public void viewDashboard() {
        System.out.println("Welcome, " + getUsername() + "! You can view and book events here.");
    }



    public void setTitle(String title) {

    }


    public String getCategory() {
        return "";
    }



    public void chooseEvent(Events event) {
        System.out.println("You have selected:");
        System.out.println(event.toString());
    }

    public void buyTicket(Events event) {
        double price = event.getTicketPrice();

        if (this.wallet.deduct(price, event)) { // ✅ Deduct from attendee’s wallet
            Organizer org = event.getOrganizer();

            if (org != null && org.getWallet() != null) {
                org.getWallet().add(price);
                event.addAttendee(this);
                System.out.println("Ticket purchased successfully!");
            } else {
                System.out.println("Error: Organizer or wallet not found.");
            }
        } else {
            System.out.println("Insufficient balance to purchase the ticket.");
        }
    }
}