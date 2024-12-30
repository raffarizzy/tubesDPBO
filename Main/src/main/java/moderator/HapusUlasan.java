package moderator;

import java.util.ArrayList;
import java.util.Map;
import penjual.Produk;
import java.util.Scanner;
import pembeli.Rating;

public class HapusUlasan {
    public static void hapusUlasan() {
        // Pastikan daftar produk diinisialisasi
        Produk.initializeDaftarProduk();
        Scanner scanner = new Scanner(System.in);

        // Meminta input nama produk dari pengguna
        System.out.print("Masukan nama produk: ");
        String namaProduk = scanner.nextLine();
        boolean produkDitemukan = false;

        // Mencari produk berdasarkan nama
        for (Map.Entry<String, ArrayList<Produk>> entry : Produk.getDaftarProduk().entrySet()) {
            ArrayList<Produk> produkList = entry.getValue();
            
            for (Produk p : produkList) {
                if (namaProduk.equalsIgnoreCase(p.getNama())) {
                    produkDitemukan = true;
                    System.out.println("Produk dengan nama \"" + namaProduk + "\" ditemukan.");
                    break;
                }
            }
            if (produkDitemukan) {
                break;
            }
        }

        // Jika produk tidak ditemukan, keluar dari metode
        if (!produkDitemukan) {
            System.out.println("Nama produk tidak ditemukan!");
            return;
        }

        // Meminta input nama pengguna dari pengguna
        System.out.print("Masukkan nama pengguna yang memberi ulasan: ");
        String namaPengguna = scanner.nextLine();
        boolean penggunaDitemukan = false;

        // Mencari pengguna di daftar rating
        for (Rating r : Rating.getDaftarRating()) {
            if (namaPengguna.equals(r.getPengguna()) && r.getNamaProduk().equalsIgnoreCase(namaProduk)) {
                penggunaDitemukan = true;
                break;
            }
        }

        // Jika pengguna tidak ditemukan, keluar dari metode
        if (!penggunaDitemukan) {
            System.out.println("Nama pengguna tidak ditemukan!");
            return;
        }

        // Ambil isi ulasan sebelum dihapus
        String isiUlasan = null;
        for (Rating r : Rating.getDaftarRating()) {
            if (r.getNamaProduk().equalsIgnoreCase(namaProduk) && r.getPengguna().equalsIgnoreCase(namaPengguna)) {
                isiUlasan = r.toString();  // Dapatkan seluruh informasi ulasan
                break;
            }
        }

        // Tambahkan ke riwayat moderasi dengan detail ulasan yang dihapus
        RiwayatModerasi.tambahRiwayatHapusUlasan(namaProduk, namaPengguna, isiUlasan);

        // Hapus rating dari produk
        Rating.hapusRating(namaProduk, namaPengguna);
        System.out.println("Ulasan oleh pengguna " + namaPengguna + " untuk produk " + namaProduk + " telah dihapus.");
    }
}
