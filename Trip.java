import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trip {
    private String destinasi;
    private int harga;
    private Date tanggalKeberangkatan;
    private int qty;
    private TripType jenisTrip;

    Trip(String destinasi, int harga, String tanggalkeberangkatan, TripType jenisTrip, int qty) {
        try {
            this.tanggalKeberangkatan = new SimpleDateFormat("d-MMM-yyyy").parse(tanggalkeberangkatan);
            this.destinasi = destinasi;
            this.harga = harga;
            this.jenisTrip = jenisTrip;
            this.qty = qty;
        } catch (ParseException e) {
            System.out.println("Tanggal tidak valid");
        }
    }

    boolean isAvailable() {
        return this.qty > 0;
    }

    void bookTrip() {
        this.qty -= 1;
    }

    void cancelBook() {
        this.qty += 1;
    }

    String getDestinasi() {
        return this.destinasi;
    }

    int getHarga() {
        return this.harga;
    }

    Date getTanggalKeberangkatan() {
        return this.tanggalKeberangkatan;
    }

    int getQty() {
        return this.qty;
    }

    TripType getJenis() {
        return this.jenisTrip;
    }
}
