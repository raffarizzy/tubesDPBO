package pembeli;

import com.method.main.Pengguna;
import java.util.ArrayList;
import java.util.Scanner;

public class Pembeli extends Pengguna {
    private static ArrayList<Pembeli> daftarPembeli = new ArrayList<>() {{
        add(new Pembeli("Dhea Sri Noor Septianiz", "dhea@gmail.com", "dhea123", "081234567891"));
    }};

    private final ArrayList<String> produkYangSudahDibeli = new ArrayList<>();
    private final ArrayList<String> produkYangSudahDiberiRating = new ArrayList<>();

    public Pembeli(String nama, String email, String password, String nomorTelepon) {
        super(nama, email, password, nomorTelepon);
        produkYangSudahDibeli.add("Laptop ABC");
    }
    
    public static Pembeli cariPembeli(String email, String password) {
        for (Pembeli pembeli : daftarPembeli) {
            if (pembeli.getEmail().equals(email) && pembeli.getPassword().equals(password)) {
                return pembeli;
            }
        }
        return null;
    }

    public static Pembeli loginPembeli(Scanner scan) {
        while (true) {
            System.out.println("================================= Login Pembeli ==============================");
            System.out.print("Email: ");
            String email = scan.nextLine();
            System.out.print("Password: ");
            String password = scan.nextLine();

            Pembeli pembeli = cariPembeli(email, password);
            if (pembeli != null) {
                System.out.println("Login berhasil. Selamat datang, " + pembeli.getNama() + "!");
                return pembeli;
            } else {
                System.out.println("Login gagal. Email atau password salah. Coba lagi.");
            }
        }
    }

    public void tampilkanProdukSudahDibeli() {
        if (produkYangSudahDibeli.isEmpty()) {
            System.out.println("Anda belum membeli produk apapun.");
        } else {
            System.out.println("Produk yang sudah dibeli:");
            for (String namaProduk : produkYangSudahDibeli) {
                System.out.println("- " + namaProduk);
            }
        }
    }

    public void berikanRating() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama produk yang ingin diberi rating: ");
        String namaProduk = scanner.nextLine();

        if (produkYangSudahDibeli.contains(namaProduk)) {
            System.out.print("Berikan rating (1-5): ");
            int ratingBintang = scanner.nextInt();
            scanner.nextLine();

            if (ratingBintang >= 1 && ratingBintang <= 5) {
                System.out.print("Berikan komentar: ");
                String komentarText = scanner.nextLine();

                Komentar komentar = new Komentar(komentarText);
                Rating rating = new Rating(namaProduk, this.getNama(), "2025-01-01", ratingBintang);
                rating.tambahKomentar(komentar);
                Rating.getDaftarRating().add(rating);

                produkYangSudahDiberiRating.add(namaProduk);
                System.out.println("Rating berhasil diberikan untuk " + namaProduk);
            } else {
                System.out.println("Rating harus antara 1 sampai 5.");
            }
        } else {
            System.out.println("Produk " + namaProduk + " tidak ditemukan dalam daftar produk yang sudah dibeli.");
        }
    }

    public void tampilkanProdukDiberiRating() {
        if (produkYangSudahDiberiRating.isEmpty()) {
            System.out.println("Belum ada produk yang diberi rating.");
        } else {
            System.out.println("Produk yang sudah diberi rating:");
            for (Rating rating : Rating.getDaftarRating()) {
                if (rating.getPengguna().equals(this.getNama())) {
                    System.out.println("Produk: " + rating.getNamaProduk());
                    System.out.println("Tanggal Ulasan: " + rating.getTanggalUlasan());
                    System.out.println("Rating: " + rating.getRatingBintang() + " bintang");
                    System.out.print("Komentar: ");
                    for (Komentar komentar : rating.getDaftarKomentar()) {
                        System.out.println(komentar.getKomentarText());
                    }
                    System.out.println("------------------------------------------------------------------------------");
                }
            }
        }
    }

    @Override
    public void jenisPengguna() {
        System.out.println("=================================== Pembeli ==================================");
        super.tampilkanProfil();
    }
}
