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
        rating1.tambahKomentar(Komentar.getDaftarKomentar().get(0));

        Rating rating2 = new Rating("Laptop ABC", "Thanos", "2024-12-02", 4);
        rating2.tambahKomentar(Komentar.getDaftarKomentar().get(1));

        Rating rating3 = new Rating("Headphone DEF", "Modric", "2024-12-03", 4);
        rating3.tambahKomentar(Komentar.getDaftarKomentar().get(2));

        Rating rating4 = new Rating("Headphone DEF", "Wanda", "2024-12-04", 5);
        rating4.tambahKomentar(Komentar.getDaftarKomentar().get(3));

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

    public String getNamaProduk() {
        return namaProduk;
    }

    public ArrayList<Komentar> getDaftarKomentar() {
        return daftarKomentar;
    }

    public String getPengguna() {
        return pengguna;
    }

    public String getTanggalUlasan() {
        return tanggalUlasan;
    }

    public int getRatingBintang() {
        return ratingBintang;
    }

    public static ArrayList<Rating> getDaftarRating() {
        return daftarRating;
    }

    public static void tampilkanRating(String namaProduk) {
        ArrayList<Rating> daftarRating = Rating.getDaftarRating();

        boolean ditemukan = false;
        for (Rating rating : daftarRating) {
            if (rating.getNamaProduk().equals(namaProduk)) {
                ditemukan = true;
                System.out.println("Pengguna       : " + rating.getPengguna());
                System.out.println("Tanggal Ulasan : " + rating.getTanggalUlasan());
                System.out.println("Rating         : " + rating.getRatingBintang() + " bintang");
                System.out.print("Komentar       : ");

                for (Komentar komentar : rating.getDaftarKomentar()) {
                    System.out.println(komentar.getKomentarText());
                }

                System.out.println();
            }
        }

        if (!ditemukan) {
            System.out.println("Belum ada rating untuk produk ini.");
        }
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
