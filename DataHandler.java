package DataHandler;

import ObjectClass.Booking;
import ObjectClass.Customer;
import ObjectClass.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DataHandler {
    public static File CUSTOMER_FILE = new File("CustomerList.txt");
    public static File BOOKING_FILE = new File("BookingList.txt");

    public static void ScanFile() {
        try {
            if (!CUSTOMER_FILE.exists()) CUSTOMER_FILE.createNewFile();

            if (!BOOKING_FILE.exists()) BOOKING_FILE.createNewFile();
        } catch (IOException err) {
            System.out.println("Data files can't be created!");
        }
    }
    // Get all customer profile from the file and add it into an arraylist and return it.
    public static ArrayList<ObjectClass.Customer> getCustomerList(){
        // Create an arraylist to store all customer profile.
        ArrayList<ObjectClass.Customer> customerList = new ArrayList<>();
        // Read from file
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(CUSTOMER_FILE));
            // Read each line and add it to the arraylist.
            for (String lines : bufferedReader.lines().collect(Collectors.toList()))
            {   // Split the line into an array of string.
                String[] customerDetails = lines.split(",");
                // Create a new customer profile and add it to the arraylist.
                customerList.add(new Customer(customerDetails[0], customerDetails[1], customerDetails[2],customerDetails[3]));
            }

            bufferedReader.close();
        } catch (IOException err) {
            System.out.println("File can't be written!");
        }
        // Return the arraylist.
        return customerList;
    }
    // Get all booking profile from the file and add it into an arraylist and return it.
    public static ArrayList<ObjectClass.Booking> getBookingList(){
        /* Create a ArrayList of Booking Object */
        ArrayList<ObjectClass.Booking> bookingList = new ArrayList<>();
        /* Retrieve the customer list and ticker list from the getCustomerList() and getTicketList() */
        ArrayList<ObjectClass.Customer> customerList = getCustomerList();
        ArrayList<ObjectClass.Ticket> ticketList = getTicketList();

        /*  Read the text from file then convert it to booking object and store it into the arrayList */
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(BOOKING_FILE));

            for (String lines : bufferedReader.lines().collect(Collectors.toList()))
            {
                String[] bookingDetails = lines.split(",");
                /* The buffer reader will scan the file and create object based on the object from customer and ticket type and compare it with the text CustomerID and TicketID */
                for(Customer c : customerList){
                    /* If the customerID is the same as the text file it */
                    if(c.getCustomerID().equals(bookingDetails[0])){
                        for(Ticket t : ticketList){
                            /* If the ticketID is the same as the text file it */
                            if(t.getTicketID().equals(bookingDetails[2])){
                                /* Create a new booking object with the attribute of customer object and ticket object and add it into the array list */
                                bookingList.add(new Booking(c,bookingDetails[1],t,bookingDetails[3],Integer.parseInt(bookingDetails[4])));
                            }
                        }
                    }
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("File can't be written!");
        }

        return bookingList;
    }
    // Creates ticket object and add it into an arraylist and return it.
    public static ArrayList<Ticket> getTicketList() {
        ArrayList<Ticket> TicketList = new ArrayList<Ticket>();
        TicketList.add(new Ticket(60, "TID001", "Gold", "Allows entry to every ride"));
        TicketList.add(new Ticket(180, "TID002", "Platinum", "VIP entry - skip queue line on every ride"));
        TicketList.add(new Ticket(300, "TID003", "Diamond",  "VIP entry + Premium meals in selected outlets"));
        return TicketList;
    }

    public static void StoreNewRegister(ArrayList<Customer> customerList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(CUSTOMER_FILE));
            for(Customer b : customerList){
                bufferedWriter.write(b.getCustomerID() + "," + b.getUserName() + "," + b.getUserEmail() + "," + b.getUserPassword());
                bufferedWriter.newLine();
            }
//            bufferedWriter.write(userID + "," + userName + "," + userEmail + "," + userPassword);
//            bufferedWriter.newLine();
//            bufferedWriter.close();
            bufferedWriter.close();
        } catch (IOException err) {
            System.out.println("File can't be written!");
        }
    }

    public static void overWritingFile(ArrayList<Booking>BookingList){
       try{
           BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(BOOKING_FILE));

           for (Booking b : BookingList){
                bufferedWriter.write(b.getCustomer().getCustomerID()+","+b.getBookingID()+","+b.getTicket().getTicketID()+","+b.getVisitDate()+","+b.getNumOfPax());
                bufferedWriter.newLine();
           }
                bufferedWriter.close();
//            PrintWriter printWriter = new PrintWriter("BookingList.txt");
//
//            for(Booking b : BookingList){
//                if (BookingList.indexOf(b) != BookingList.size() - 1) {
//                    printWriter.write(b.getCustomer().getCustomerID()+","+b.getBookingID()+","+b.getTicket().getTicketID()+","+b.getVisitDate()+","+b.getNumOfPax());
//                    continue;
//                }
//
//                printWriter.write(b.getCustomer().getCustomerID()+","+b.getBookingID()+","+b.getTicket().getTicketID()+","+b.getVisitDate()+","+b.getNumOfPax());
//            }
//
//            printWriter.close();
        }
        catch(IOException err){
            System.out.println("File can't be written!");
        }
    }

    public static void clearScreen() {

        try {

            if (System.getProperty("os.name").contains("Windows"))

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else

                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException ex) {}

    }
}
