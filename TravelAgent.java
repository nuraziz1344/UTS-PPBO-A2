import java.util.ArrayList;
import java.util.List;

public class TravelAgent {
    private List<Trip> daftarTrip = new ArrayList<>(); 
    private List<Booking> daftarBooking = new ArrayList<>();

    void addTrip(Trip trip){
        this.daftarTrip.add(trip);
    }

    void showAvailableTrip(){
        List<Trip> available = this.daftarTrip.stream().filter(trip -> )
    }
}