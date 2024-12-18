package aerocheck;
public class Passenger {

    protected String bookingNo, name, iC, email, seatNo, phoneNo, origin, destination;

    public Passenger() {
        bookingNo = null;
        name = null;
        iC = null;
        email = null;
        seatNo = null;
        phoneNo = null;
        origin = null;
        destination = null;
    }
    public Passenger(String bookingNo, String name, String iC, String phoneNo,
            String email, String origin, String destination, String seatNo) 
    {
        this.bookingNo = bookingNo;
        this.name = name;
        this.iC = iC;
        this.phoneNo = phoneNo;
        this.email = email;
        this.origin = origin;
        this.destination = destination;
        this.seatNo = seatNo;
    }

    //Getter method
    public String getBookingNo() {
        return bookingNo;
    }
    public String getName() {
        return name;
    }
    public String getIC() {
        return iC;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public String getEmail() {
        return email;
    }
    public String getOrigin() {
        return origin;
    }
    public String getDest() {
        return destination;
    }
    public String getSeatNo() {
        return seatNo;
    }
}
