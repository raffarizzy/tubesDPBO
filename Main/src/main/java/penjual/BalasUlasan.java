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
        
        boolean produkDitemukan = false;
        ArrayList<Rating> ratingTerkait = new ArrayList<>();
        for (Rating rating : Rating.getDaftarRating()) {
            if (rating.getNamaProduk().equalsIgnoreCase(namaProduk)) {
                produkDitemukan = true;
                ratingTerkait.add(rating);
            }
        }
        
        if (!produkDitemukan) {
            System.out.println("Produk dengan nama \"" + namaProduk + "\" tidak ditemukan!");
            return;
        }
        
        // Tampilkan daftar ulasan terkait produk tersebut
        System.out.println("\nDaftar Ulasan untuk Produk \"" + namaProduk + "\":");
        ArrayList<Komentar> semuaKomentar = new ArrayList<>();
        for (Rating rating : ratingTerkait) {
            System.out.println("- Pengguna: " + rating.getPengguna());
            System.out.println("  Rating: " + rating.getRatingBintang() + " bintang");
            System.out.println("  Ulasan: ");
            int index = 1;
            for (Komentar komentar : rating.getDaftarKomentar()) {
                System.out.println("    " + index + ". " + komentar.getKomentarText());
                semuaKomentar.add(komentar); // Tambahkan ke daftar semua komentar
                index++;
            }
            System.out.println();
        }
        
        // Pilih ulasan untuk dibalas
        System.out.print("Masukkan nomor ulasan yang ingin dibalas: ");
        int pilihan = sc.nextInt();
        sc.nextLine(); // Buang newline setelah input angka
        
        if (pilihan < 1 || pilihan > semuaKomentar.size()) {
            System.out.println("Pilihan tidak valid!");
            return;
        }
        
        // Ambil ulasan yang dipilih
        Komentar ulasanDipilih = semuaKomentar.get(pilihan - 1);
        
        // Input balasan dari penjual
        System.out.print("Masukkan balasan Anda untuk ulasan ini: ");
        String balasan = sc.nextLine();
        
        // Tambahkan balasan ke ulasan
        ulasanDipilih.tambahBalasan(balasan);
        System.out.println("Balasan Anda telah ditambahkan:");
        System.out.println("  \"" + ulasanDipilih.getKomentarText() + "\" -> \"" + balasan + "\"");
    }
}
