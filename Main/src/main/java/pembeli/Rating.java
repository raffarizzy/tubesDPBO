package pembeli;

import java.util.ArrayList;

public class Rating {
    private String namaProduk;
    private String pengguna;
    private String tanggalUlasan;
    private int ratingBintang;
    private ArrayList<Komentar> daftarKomentar;

    private static ArrayList<Rating> daftarRating = new ArrayList<>() {{
        Rating rating1 = new Rating("Laptop ABC", "Kroos", "2024-12-01", 5);
        rating1.tambahKomentar(new Komentar("Produk sangat sesuai harapan"));

        Rating rating2 = new Rating("Laptop ABC", "Bellingham", "2024-12-02", 4);
        rating2.tambahKomentar(new Komentar("Cukup memuaskan"));

        Rating rating3 = new Rating("Headphone DEF", "Modric", "2024-12-03", 4);
        rating3.tambahKomentar(new Komentar("Kualitas suara bagus"));

        Rating rating4 = new Rating("Headphone DEF", "Bale", "2024-12-04", 5);
        rating4.tambahKomentar(new Komentar("Nyaman dipakai sepanjang hari"));

        add(rating1);
        add(rating2);
        add(rating3);
        add(rating4);
    }};

    public Rating(String namaProduk, String pengguna, String tanggalUlasan, int ratingBintang) {
        this.namaProduk = namaProduk;
        this.pengguna = pengguna;
        this.tanggalUlasan = tanggalUlasan;
        this.ratingBintang = ratingBintang;
        this.daftarKomentar = new ArrayList<>();
    }

    public void tambahKomentar(Komentar komentar) {
        this.daftarKomentar.add(komentar);
    }

    public ArrayList<Komentar> getDaftarKomentar() {
        return daftarKomentar;
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

    public static ArrayList<Rating> getDaftarRating() {
        return daftarRating;
    }

    @Override
    public String toString() {
        String result = "Pengguna       : " + pengguna + "\n" +
                        "Tanggal Ulasan : " + tanggalUlasan + "\n" +
                        "Rating         : " + ratingBintang + " bintang\n" +
                        "Komentar       :\n";
        for (Komentar komentar : daftarKomentar) {
            result += "  - " + komentar.getKomentarText() + "\n";
        }
        return result;
    }
}
