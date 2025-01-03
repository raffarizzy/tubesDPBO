package penjual;

import java.util.Scanner;
import java.util.ArrayList;
import pembeli.Komentar;
import pembeli.Rating;

public class LaporUlasan {
    private final String namaProduk;
    private final String namaPengguna;
    private final String komentar;
    private static final ArrayList<LaporUlasan> ulasanDilanggar = new ArrayList<>();

    public LaporUlasan(String namaProduk, String namaPengguna, String komentar) {
        this.namaProduk = namaProduk;
        this.namaPengguna = namaPengguna;
        this.komentar = komentar;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public String getKomentar() {
        return komentar;
    }

    public static ArrayList<LaporUlasan> getUlasanDilanggar() {
        return ulasanDilanggar;
    }

    public static void tampilkanLaporan() {
        if (getUlasanDilanggar().isEmpty()) {
            System.out.println("Tidak ada ulasan yang dilaporkan.");
        } else {
            System.out.println("Daftar Ulasan yang Dilaporkan:");
            for (LaporUlasan ulasan : ulasanDilanggar) {
                System.out.println("- Produk: " + ulasan.getNamaProduk());
                System.out.println("  Pengguna: " + ulasan.getNamaPengguna());
                System.out.println("  Ulasan: " + ulasan.getKomentar());
                System.out.println();
            }
        }
    }

    public static void pilihDanLaporUlasan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama produk yang ulasannya ingin dilaporkan: ");
        String namaProduk = sc.nextLine();

        System.out.print("Masukkan nama pengguna yang ulasannya ingin dilaporkan: ");
        String namaPengguna = sc.nextLine();

        boolean ulasanDitemukan = false;
        Rating ratingDipilih = null;

        for (Rating rating : Rating.getDaftarRating()) {
            if (rating.getNamaProduk().equalsIgnoreCase(namaProduk) &&
                rating.getPengguna().equalsIgnoreCase(namaPengguna)) {
                ulasanDitemukan = true;
                ratingDipilih = rating;
                break;
            }
        }

        if (!ulasanDitemukan) {
            System.out.println("Ulasan untuk produk \"" + namaProduk + "\" dari pengguna \"" + namaPengguna + "\" tidak ditemukan!");
            return;
        }

        System.out.println("\nUlasan dan Rating");
        System.out.println("Pengguna       : " + ratingDipilih.getPengguna());
        System.out.println("Tanggal Ulasan : " + ratingDipilih.getTanggalUlasan());
        System.out.println("Rating         : " + ratingDipilih.getRatingBintang() + " bintang");
        System.out.println("Komentar       :");
        for (Komentar komentar : ratingDipilih.getDaftarKomentar()) {
            System.out.println("  - " + komentar.getKomentarText());
        }

        System.out.print("\nApakah Anda ingin melaporkan ulasan ini? (ya/tidak): ");
        String konfirmasi = sc.nextLine();

        if (konfirmasi.equalsIgnoreCase("ya")) {
            for (Komentar komentar : ratingDipilih.getDaftarKomentar()) {
                ulasanDilanggar.add(new LaporUlasan(namaProduk, namaPengguna, komentar.getKomentarText()));
            }
            System.out.println("Ulasan untuk produk \"" + namaProduk + "\" oleh pengguna \"" + namaPengguna + "\" telah dilaporkan.");
        } else {
            System.out.println("Ulasan tidak dilaporkan.");
        }
    }
}
