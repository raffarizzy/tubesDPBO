package pembeli;

import com.method.main.Pengguna;
import penjual.Produk;
import java.util.ArrayList;
import java.util.Scanner;

public class Pembeli extends Pengguna {
    private static ArrayList<Pembeli> daftarPembeli = new ArrayList<>() {{
        add(new Pembeli("Dhea Sri Noor Septianiz", "dhea@gmail.com", "dhea123", "081234567891"));
    }};

    private final ArrayList<Produk> produkYangSudahDibeli = new ArrayList<>();
    private final ArrayList<String> produkYangSudahDiberiRating = new ArrayList<>();

    public Pembeli(String nama, String email, String password, String nomorTelepon) {
    super(nama, email, password, nomorTelepon);
    
    Produk.initializeDaftarProduk(); 
    ArrayList<Produk> produkRahmah = Produk.getDaftarProduk().get("Rahmah");
        if (produkRahmah != null) {
            for (Produk produk : produkRahmah) {
                if (produk.getNama().equals("Laptop ABC")) {
                    produkYangSudahDibeli.add(produk);
                    break;
                }
            }
        }
    }

    public static Pembeli cariPembeli(String email, String password) {
        for (Pembeli pembeli : daftarPembeli) {
            if (pembeli.getEmail().equals(email) && pembeli.getPassword().equals(password)) {
                return pembeli;
            }
        }
        return null;
    }

    public static void loginPembeli(Scanner scan) {
        while (true) {
            System.out.println("================================= Login Pembeli ==============================");
            System.out.println("Ketik 'exit' untuk keluar dari login pembeli.");
            System.out.print("Email: ");
            String email = scan.nextLine();
            if (email.equalsIgnoreCase("exit")) {
                System.out.println("Anda keluar dari login penjual.");
                break; 
            }
            System.out.print("Password: ");
            String password = scan.nextLine();

            Pembeli pembeli = cariPembeli(email, password);
            if (pembeli != null) {
                System.out.println("Login berhasil. Selamat datang, " + pembeli.getNama() + "!");
                MenuPembeli menu = new MenuPembeli(pembeli);
                menu.aksi();
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
            for (Produk produk : produkYangSudahDibeli) {
                produk.tampilkanInfo();
            }
        }
    }

    public void berikanRating() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama produk yang ingin diberi rating: ");
        String namaProduk = scanner.nextLine();

        Produk produkDitemukan = null;
        for (Produk produk : produkYangSudahDibeli) {
            if (produk.getNama().equalsIgnoreCase(namaProduk)) {
                produkDitemukan = produk;
                break;
            }
        }

        if (produkDitemukan != null) {
            System.out.print("Berikan rating (1-5): ");
            int ratingBintang = scanner.nextInt();
            scanner.nextLine();

            if (ratingBintang >= 1 && ratingBintang <= 5) {
                System.out.print("Berikan komentar: ");
                String komentarText = scanner.nextLine();

                Komentar komentar = new Komentar(komentarText);
                Rating rating = new Rating(produkDitemukan.getNama(), this.getNama(), "2025-01-01", ratingBintang);
                rating.tambahKomentar(komentar);
                Rating.getDaftarRating().add(rating);

                produkYangSudahDiberiRating.add(produkDitemukan.getNama());
                System.out.println("Rating berhasil diberikan untuk " + produkDitemukan.getNama());
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
