import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trip {
    private String destinasi;
    private int harga;
    private Date tanggalKeberangkatan;
    private int qty;
    private int available;
    private TripType jenisTrip;

    Trip(String destinasi, int harga, String tanggalkeberangkatan, TripType jenisTrip, int qty ){
        try {
            this.tanggalKeberangkatan = new SimpleDateFormat("d-MMM-yyyy").parse(tanggalkeberangkatan);
            this.destinasi = destinasi;
            this.harga = harga;
            this.jenisTrip = jenisTrip;
            this.qty = qty;
            this.available = qty;
        } catch (ParseException e) {
            System.out.println("Tanggal tidak valid");
        }
    }

    boolean isAvailable(){
        return this.available > 0;
    }

    String getDestinasi(){
        return this.destinasi;
    }

    int getHarga(){
        return this.harga;
    }

    Date getTanggalKeberangkatan(){
        return this.tanggalKeberangkatan;
    }
}

