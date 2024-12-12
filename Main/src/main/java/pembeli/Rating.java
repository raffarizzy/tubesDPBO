package pembeli;

public class Rating {
    private String namaProduk;
    private String pengguna;
    private String tanggalUlasan;
    private int ratingBintang;

    public Rating(String namaProduk, String pengguna, String tanggalUlasan, int ratingBintang) {
        this.namaProduk = namaProduk;
        this.pengguna = pengguna;
        this.tanggalUlasan = tanggalUlasan;
        this.ratingBintang = ratingBintang;
    }

    public String getNamaProduk() {
        return namaProduk;
    }
    
    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }
    
    public String getPengguna() {
        return pengguna;
    }

    public void setPengguna(String pengguna) {
        this.pengguna = pengguna;
    }
    
    public String getTanggalUlasan() {
        return tanggalUlasan;
    }

    public void setTanggalUlasan(String tanggalUlasan) {
        this.tanggalUlasan = tanggalUlasan;
    }

    public int getRatingBintang() {
        return ratingBintang;
    }

    public void setRatingBintang(int ratingBintang) {
        if (ratingBintang >= 1 && ratingBintang <= 5) {
            this.ratingBintang = ratingBintang;
        } else {
            System.out.println("Rating harus antara 1 dan 5.");
        }
    }

    @Override
    public String toString() {
        return "Pengguna       : " + pengguna + "\n" +
               "Tanggal Ulasan : " + tanggalUlasan +
               "Rating         : " + ratingBintang + " bintang";
    }
}
