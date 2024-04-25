public class Booking {
    private static int increment = 0;
    private int idBooking;
    private Customer customer;
    private Trip trip;

    Booking(Customer customer, Trip trip){
        Booking.increment += 1;
        this.idBooking = Booking.increment;
        this.customer = customer;
        this.trip = trip;
    }

    int getId(){
        return this.idBooking;
    }

    Customer getCustomer(){
        return this.customer;
    }

    Trip geTrip(){
        return this.trip;
    }
}