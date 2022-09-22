package ObjectClass;

import DataHandler.DataHandler;

import java.util.Random;

public class Booking {
    private Customer Customer;
    private String bookingID;
    private Ticket Ticket;
    private String visitDate;
    private int numOfPax;
    private double totalPrice;


    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public int getNumOfPax() {
        return numOfPax;
    }

    public void setNumOfPax(int numOfPax) {
        this.numOfPax = numOfPax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Customer getCustomer() {
        return Customer;
    }
    public void setCustomer(Customer customer) {
        Customer = customer;
    }
    public Ticket getTicket() {
        return Ticket;
    }
    public void setTicket(Ticket ticket) {
        Ticket = ticket;
    }

// Constructor
    public Booking(Customer customer, String bookingID, Ticket ticket, String visitDate, int numOfPax) {
        this.Customer = customer;
        this.bookingID = bookingID;
        this.Ticket = ticket;
        this.visitDate = visitDate;
        this.numOfPax = numOfPax;
    }
    public Booking(Customer customer, Ticket ticket, String visitDate, int numOfPax) {
        this.Customer = customer;
        this.bookingID = generateBookingID();
        this.Ticket = ticket;
        this.visitDate = visitDate;
        this.numOfPax = numOfPax;
    }
// Booking Method
    //Generate the booking details
    public void ViewBookings(){
        System.out.println("______________________________________________________________________________");
        System.out.println("Booking ID: " + bookingID);
        System.out.println("Customer ID: " + Customer.getCustomerID());
        System.out.println("Ticket ID: " + Ticket.getTicketID() + " - " + Ticket.getTicketType());
        System.out.println("Visit Date: " + visitDate);
        System.out.println("Number of Pax: " + numOfPax);
        System.out.println("Total Price: RM" + calculatePrice());
        System.out.println("______________________________________________________________________________");
    }
    // Calculate Price Method
    public double calculatePrice(){
        return totalPrice = numOfPax * Ticket.getPrice();
    }
    //Generate a unique Booking ID
    public static String generateBookingID() {
        String bookingID = "BID"+ new Random().nextInt(99999);

        while (hasID(bookingID)) {
            bookingID = "BID"+ new Random().nextInt(99999);
        }

        return bookingID;
    }
    // Check if the booking ID is already in the system
    private static boolean hasID(String id) {
        for (Booking booking : DataHandler.getBookingList()) {
            if (booking.getBookingID().equals(id)) return true;
        }
        return false;
    }

}
