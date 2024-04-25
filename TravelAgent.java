import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TravelAgent {
    private List<Trip> daftarTrip = new ArrayList<>();
    private List<Booking> daftarBooking = new ArrayList<>();

    void addTrip(Trip trip) {
        this.daftarTrip.add(trip);
    }

    void showAvailableTrip() {
        List<Trip> available = this.daftarTrip.stream().filter(trip -> trip.isAvailable()).toList();
        System.out.println("Terdapat " + available.size() + " trip yang masih tersedia");
        available.forEach(trip -> System.out.printf(
                "Destinasi : %s -- Keberangkatan : %s -- Harga %d -- Qty : %d -- Jenis : %s\n", trip.getDestinasi(),
                trip.getTanggalKeberangkatan().toString(), trip.getHarga(), trip.getQty(), trip.getJenis()));
    }

    void bookTrip(Customer customer, Trip trip) {
        String bookExist = this.bookExist(customer, trip);
        if (bookExist != null) {
            System.out.println(
                    "Pesanan gagal, pengguna telah memiliki pesanan pada trip yang sama dengan id " + bookExist);
        } else if (trip.getQty() == 0) {
            System.out.println("Pemesanan gagal, perjalanan ke " + trip.getDestinasi() + " telah habis terjual");
        } else {
            Booking booking = new Booking(customer, trip);
            daftarBooking.add(booking);
            System.out.println("pemesanan berhasil dilakukan dengan booking id " + booking.getId());
        }
    }

    void cancelBooking(String email, Trip trip) {
        boolean found = false;
        for (int i = 0; i < this.daftarBooking.size(); i++) {
            Booking booking = daftarBooking.get(i);
            if (booking.getCustomer().getEmail().equals(email) && booking.geTrip().equals(trip)) {
                this.daftarBooking.remove(i);
                trip.cancelBook();
                System.out.println("Pesanan dengan id booking " + booking.getId() + "berhasil dibatalkan");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Pesanan tidak ditemukan");
        }
    }

    void getBookingsByCustomerEmail(String email) {
        List<Booking> filtered = this.daftarBooking.stream()
                .filter(booking -> booking.getCustomer().getEmail().equals(email)).toList();
        if (filtered.size() == 0) {
            System.out.println("Tidak ditemukan pesanan untuk email " + email);
        } else {
            System.out.println("Pesanan dengan email " + email);
            filtered.forEach(booking -> System.out
                    .println("Booking ID: " + booking.getId() + ", Destinasi: " + booking.geTrip().getDestinasi()));
        }

    }

    void getAvailableTripsByType(TripType jenis) {
        List<Trip> filtered = this.daftarTrip.stream()
                .filter(trip -> trip.getJenis().equals(jenis) && trip.getQty() > 0).toList();
        if (filtered.size() == 0) {
            System.out.println("Tidak data trip dengan jenis " + jenis.toString());
        } else {
            System.out.println("Ditemukan " + filtered.size() + " trip untuk jenis " + jenis.toString());
            filtered.forEach(trip -> System.out.printf(
                    "Destinasi : %s -- Keberangkatan : %s -- Harga %d -- Qty : %d -- Jenis : %s\n", trip.getDestinasi(),
                    trip.getTanggalKeberangkatan().toString(), trip.getHarga(), trip.getQty(), trip.getJenis()));
        }
    }

    void getAvailableTripsByDate(String dateInString) {
        try {
            Date date = new SimpleDateFormat("d-MMM-yyyy").parse(dateInString);
            List<Trip> filtered = this.daftarTrip.stream()
                    .filter(trip -> trip.getTanggalKeberangkatan().equals(date) && trip.getQty() > 0).toList();
            if (filtered.size() == 0) {
                System.out.println("Tidak data trip dengan jadwal keberangkatan pada "
                        + new SimpleDateFormat("d-MMM-yyyy").format(date));
            } else {
                System.out.println(
                        "Ditemukan " + filtered.size() + " trip untuk keberangkatan tanggal " + new SimpleDateFormat("d-MMM-yyyy").format(date));
                filtered.forEach(trip -> System.out.printf(
                        "Destinasi : %s -- Keberangkatan : %s -- Harga %d -- Qty : %d -- Jenis : %s\n",
                        trip.getDestinasi(),
                        trip.getTanggalKeberangkatan().toString(), trip.getHarga(), trip.getQty(), trip.getJenis()));
            }
        } catch (ParseException e) {
            System.out.println("Tanggal tidak valid");
        }
    }

    String bookExist(Customer customer, Trip trip) {
        List<Booking> exist = this.daftarBooking.stream()
                .filter(book -> book.getCustomer().equals(customer) && book.geTrip().equals(trip))
                .toList();
        return exist.size() > 0 ? exist.get(0).getId() : null;
    }
}