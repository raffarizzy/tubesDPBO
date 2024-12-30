package penjual;

import pembeli.Rating;
import pembeli.Komentar;
import java.util.Scanner;

public class BalasUlasan {
    public static void balasUlasan() {
        Scanner sc = new Scanner(System.in);

        Produk.tampilkanSemuaProduk();

        System.out.print("Masukkan nama produk yang ulasannya ingin dibalas: ");
        String namaProduk = sc.nextLine();

        System.out.print("Masukkan nama pengguna yang ulasannya ingin dibalas: ");
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

        System.out.print("\nMasukkan balasan Anda untuk ulasan ini: ");
        String balasan = sc.nextLine();

        for (Komentar komentar : ratingDipilih.getDaftarKomentar()) {
            komentar.tambahBalasan(balasan);
        }

        System.out.println("\nBalasan Anda telah ditambahkan untuk ulasan pengguna \"" + namaPengguna + "\":");
        for (Komentar komentar : ratingDipilih.getDaftarKomentar()) {
            System.out.println("  \"" + komentar.getKomentarText() + "\" -> \"" + balasan + "\"");
        }
    }
}
