/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1;

/**
 *
 * @author zison
 */
public class Customer {
    private String CustomerID;
    private String userName;
    private String userEmail;
    private String userPassword;



    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    //Constructor
    //Creating New Customer Profile
    public Customer(String userName, String userEmail, String userPassword) {
        this.CustomerID = generateCustomerID();
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
    //Constructor for importing customer profile to the file. As file only can read String, we need to add String to the constructor.
    public Customer(String customerID, String userName, String userEmail, String userPassword) {
        this.CustomerID = customerID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String toString(){
        return "CustomerID: " + CustomerID + "\n" + "UserName: " + userName + "\n" + "UserEmail: " + userEmail + "\n" + "UserPassword: " + userPassword;
    }
    //Generate a unique CustomerID
    public String generateCustomerID() {
        String customerID = "UID"+ new Random().nextInt(99999);

        while (hasID(customerID)) {
            customerID = "UID"+ new Random().nextInt(99999);
        }

        return customerID;
    }
    //Check if the customerID already exists in the system
    private static boolean hasID(String id){
        for (Customer customer : DataHandler.getCustomerList()) {
            if (customer.getCustomerID().equals(id)) return true;
        }
        return false;
    }

}

