package ObjectClass;

public class Ticket {
    private int price;
    private String ticketID;
    private String ticketType;
    private String ticketDescription;
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getTicketID() {
        return ticketID;
    }
    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
    public String getTicketType() {
        return ticketType;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public String getTicketDescription()
    {
        return ticketDescription;
    }
    public Ticket(int price, String ticketID, String ticketType, String ticketDescription) {
        this.price = price;
        this.ticketID = ticketID;
        this.ticketType = ticketType;
        this.ticketDescription = ticketDescription;
    }
    public String toString(){
        return "Ticket ID: " + ticketID + "\n" + "Ticket Type: " + ticketType + "\n" + "Ticket Description: " + ticketDescription + "\n" + "Price: RM" + price;
    }

}
