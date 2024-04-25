public class Customer {
    private String nama;
    private String email;
    
    Customer(String nama, String email){
        this.nama = nama;
        this.email = email;
    }

    String getNama(){
        return this.nama;
    }

    String getEmail(){
        return this.email;
    }
}
