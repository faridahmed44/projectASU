package project;

public class wallet {
    private double balance;

    public wallet(double balance) {
        this.balance = balance;
    }

    public wallet() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deduct(double ticketPrice, Events event) {
        if (balance >= ticketPrice) {
            balance -= ticketPrice;
            System.out.println("Ticket purchased for event: " + event.getTitle());
            System.out.println("Remaining Balance: $" + balance);
            return true;
        } else {
            System.out.println("Insufficient balance to purchase ticket for: " + event.getTitle());
            return false;
        }
    }

    public void add(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public String toString() {
        return "Balance: " + balance;
    }
}
