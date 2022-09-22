/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1;
import DataHandler.DataHandler;
import ObjectClass.Booking;
import ObjectClass.Customer;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author zison
 */
public class LandingUI {
    public static Customer customer = null;
    public static void initLandingUI() {
        do {
            ArrayList<Booking> BookingList = DataHandler.getBookingList();
            ArrayList<Customer> CustomerList = DataHandler.getCustomerList();
            ArrayList<Ticket> TicketList = DataHandler.getTicketList();
            Scanner scanner = new Scanner(System.in);
            System.out.println("===============================================");
            System.out.println("[~~~ Amusement Park Management System ~~~]");
            System.out.println("===============================================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.println("===============================================");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            DataHandler.clearScreen();
            switch (choice) {
                case "1":
                    if(login(CustomerList)) {
                        DataHandler.clearScreen();
                        System.out.println("Login Successful");
                        do {
                            System.out.println("===============================================");
                            System.out.println("Welcome to the Amusement Park Ticketing System");
                            System.out.println("===============================================");
                            System.out.println("Welcome " + customer.getUserName() + ". How can we help you?");
                            System.out.println("-----------------------------------------------");
                            System.out.println("1.Search Booking Type");
                            System.out.println("2.View Booking(s)");
                            System.out.println("3.Update Booking");
                            System.out.println("4.Cancel Booking");
                            System.out.println("5.Logout");
                            System.out.println("===============================================");
                            System.out.println("Please enter your choice");
                            String choice2 = scanner.nextLine();
                            switch (choice2) {
                                case "1": {
                                    DataHandler.clearScreen();
                                    SearchNewBooking(customer, BookingList, TicketList);
                                    DataHandler.overWritingFile(BookingList);
                                    break;
                                }
                                case "2": {
                                    DataHandler.clearScreen();
                                    viewBooking(BookingList, customer);
                                    break;
                                }
                                case "3": {
                                    DataHandler.clearScreen();
                                    updateBooking(BookingList);
                                    DataHandler.overWritingFile(BookingList);
                                    break;
                                }
                                case "4": {
                                    DataHandler.clearScreen();
                                    cancelBooking(BookingList);
                                    DataHandler.overWritingFile(BookingList);
                                    break;
                                }
                                case "5": {
                                    DataHandler.clearScreen();
                                    System.out.println("System Reply: Returning to main menu...");
                                    customer = null;
                                    break;
                                }
                                default: {
                                    DataHandler.clearScreen();
                                    System.out.println("System Reply: Invalid choice");
                                    break;
                                }
                            }
                        } while (customer != null);
                    }
                    else {
                        System.out.println("Login Failed - Invalid username or password");
                    }
                    break;
                case "2":
                    register(CustomerList);
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(true);

    }

    public static boolean login(ArrayList<Customer> CustomerList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================================");
        System.out.println("[~~~ Login ~~~]");
        System.out.println("===============================================");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (Customer c : CustomerList) {
            if (c.getUserName().equals(username) && c.getUserPassword().equals(password)) {
                customer = c;
                return true;
            }
        }
        return false;
    }

    public static void register(ArrayList<Customer> CustomerList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================================");
        System.out.println("[~~~ Register ~~~]");
        System.out.println("===============================================");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();


        CustomerList.add(new Customer(username, email, password));
        DataHandler.StoreNewRegister(CustomerList);
        DataHandler.clearScreen();
        System.out.println("Registration Successful");
    }

    public static void SearchNewBooking(Customer customer, ArrayList<Booking> BookingList,ArrayList<Ticket> TicketList){
        int x = 1;
        for(Ticket t : TicketList) {
            System.out.println("===============================================");
            System.out.println("Available Packages");
            System.out.println("===============================================");
            System.out.println("Package "+ x + ".  " + t.toString());
            System.out.println("===============================================");
            x++;
        }
        System.out.println("Options : Request Booking [1]   Back [x]");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(choice.equals("1")){
            System.out.print("Please enter the package number :");
            String type = scanner.nextLine();
            Ticket chosen = null;
            if(type.equals("1")){
                chosen = TicketList.get(0);
            }
            else if(type.equals("2")){
                chosen = TicketList.get(1);
            }
            else if(type.equals("3")){
                chosen = TicketList.get(2);
            }
            else if(type.equals("x")){
                DataHandler.clearScreen();
                return;
            }
            else{
                DataHandler.clearScreen();
                System.out.println("System Reply: Invalid choice");
            }

            System.out.print("Please enter the number of tickets you want to book :");
            int number = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Please enter the date you want to book (yyyy-mm-dd format) : ");
            String date = scanner.nextLine();
            BookingList.add(new Booking(customer,chosen,date,number));
            DataHandler.clearScreen();
            System.out.println("Booking Successful - A confirmation email has been sent to " + customer.getUserEmail());

        }
        else if(choice.equals("x")){
            DataHandler.clearScreen();
        }
        else{
            DataHandler.clearScreen();
            System.out.println("System Reply : Invalid choice");
        }

    }

    public static void viewBooking(ArrayList<Booking> BookingList,Customer customer) {
        System.out.println("===============================================");
        System.out.println("__Your Booking(s)__");
        System.out.println("===============================================");
        boolean x = false;
        for(Booking b : BookingList){
            if(customer.getCustomerID().equals(b.getCustomer().getCustomerID())){
                x = true;
            }
        }
        if( x == true){
            for(Booking b : BookingList){
                if(customer.getCustomerID().equals(b.getCustomer().getCustomerID())){
                    b.ViewBookings();
                }
            }
        }
        else{
            DataHandler.clearScreen();
            System.out.println("System Reply : You have no booking");
        }
    }

    public static void updateBooking(ArrayList<Booking> BookingList) {
        System.out.println("===============================================");
        System.out.println("__Update Booking__");
        System.out.println("===============================================");

        boolean x = false;
        System.out.println("Please enter the booking ID you want to update");
        Scanner scanner = new Scanner(System.in);
        String bookingID = scanner.nextLine();
        for(Booking b: BookingList){
            if(bookingID.equals(b.getBookingID())){
                x = true;
            }
        }
        if(x){
            for(Booking b : BookingList){
                if(bookingID.equals(b.getBookingID())){
                    System.out.println("Please enter the new date you want to book (yyyy-mm-dd format)");
                    String date = scanner.nextLine();
                    b.setVisitDate(date);
                    System.out.println("Please enter the new number of tickets you want to book");
                    int number = scanner.nextInt();
                    b.setNumOfPax(number);
                    DataHandler.clearScreen();
                    System.out.println("System Reply : Booking updated");
                }
            }
        } else{
            DataHandler.clearScreen();
            System.out.println("System Reply : Invalid booking ID");
        }
    }

    public static void cancelBooking(ArrayList<Booking> BookingList) {
        ArrayList<Booking> toDelete = new ArrayList<>();
        System.out.println("===============================================");
        System.out.println("__Cancel Booking__");
        System.out.println("===============================================");
        System.out.print("Please enter the booking ID you want to cancel :");
        Scanner scanner = new Scanner(System.in);
        String bookingID = scanner.nextLine();
        for(Booking b : BookingList){
            if(bookingID.equals(b.getBookingID())){
                toDelete.add(b);
            }
        }
        BookingList.removeAll(toDelete);
        DataHandler.clearScreen();
        System.out.println("System Reply : ___!!! Booking Canceled !!!___");
    }


}

