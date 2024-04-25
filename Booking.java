public class Booking {
    private static int increment = 0;
    private String idBooking;
    private Customer customer;
    private Trip trip;

    Booking(Customer customer, Trip trip){
        this.idBooking = Booking.generateId(trip);
        this.customer = customer;
        this.trip = trip;
        trip.bookTrip();
    }

    static String generateId(Trip trip){
        Booking.increment += 1;
        return String.format("00%s00%s%d", trip.getDestinasi(), trip.getJenis().toString(), Booking.increment);
    }

    String getId(){
        return this.idBooking;
    }

    Customer getCustomer(){
        return this.customer;
    }

    Trip geTrip(){
        return this.trip;
    }
}