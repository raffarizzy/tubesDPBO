package penjual;

import pembeli.Rating;
import pembeli.Komentar;

import java.util.ArrayList;
import java.util.Scanner;

public class BalasUlasan {
    public static void balasUlasan() {
        Scanner sc = new Scanner(System.in);

        // Tampilkan semua produk
        Produk.tampilkanSemuaProduk();

        // Input nama produk
        System.out.print("Masukkan nama produk yang ulasannya ingin dibalas: ");
        String namaProduk = sc.nextLine();

        // Input nama pengguna
        System.out.print("Masukkan nama pengguna yang ulasannya ingin dibalas: ");
        String namaPengguna = sc.nextLine();

        boolean ulasanDitemukan = false;
        Rating ratingDipilih = null;

        // Cari ulasan yang sesuai dengan nama produk dan nama pengguna
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

        // Tampilkan detail ulasan lengkap dari pengguna
        System.out.println("\nUlasan dan Rating");
        System.out.println("Pengguna       : " + ratingDipilih.getPengguna());
        System.out.println("Tanggal Ulasan : " + ratingDipilih.getTanggalUlasan());
        System.out.println("Rating         : " + ratingDipilih.getRatingBintang() + " bintang");
        System.out.println("Komentar       :");
        for (Komentar komentar : ratingDipilih.getDaftarKomentar()) {
            System.out.println("  - " + komentar.getKomentarText());
        }

        // Input balasan dari penjual
        System.out.print("\nMasukkan balasan Anda untuk ulasan ini: ");
        String balasan = sc.nextLine();

        // Tambahkan balasan ke semua komentar dalam ulasan
        for (Komentar komentar : ratingDipilih.getDaftarKomentar()) {
            komentar.tambahBalasan(balasan);
        }

        System.out.println("\nBalasan Anda telah ditambahkan untuk ulasan pengguna \"" + namaPengguna + "\":");
        for (Komentar komentar : ratingDipilih.getDaftarKomentar()) {
            System.out.println("  \"" + komentar.getKomentarText() + "\" -> \"" + balasan + "\"");
        }
    }
}
