package moderator;

import java.util.ArrayList;
import java.util.Map;
import penjual.Produk;
import java.util.Scanner;
import pembeli.Rating;

public class HapusUlasan {
    public static void hapusUlasan(Moderator moderator) {
        Produk.initializeDaftarProduk();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukan nama produk: ");
        String namaProduk = scanner.nextLine();
        boolean produkDitemukan = false;

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

        if (!produkDitemukan) {
            System.out.println("Nama produk tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan nama pengguna yang memberi ulasan: ");
        String namaPengguna = scanner.nextLine();
        boolean penggunaDitemukan = false;

        for (Rating r : Rating.getDaftarRating()) {
            if (namaPengguna.equals(r.getPengguna()) && r.getNamaProduk().equalsIgnoreCase(namaProduk)) {
                penggunaDitemukan = true;
                break;
            }
        }

        if (!penggunaDitemukan) {
            System.out.println("Nama pengguna tidak ditemukan!");
            return;
        }

        String isiUlasan = null;
        for (Rating r : Rating.getDaftarRating()) {
            if (r.getNamaProduk().equalsIgnoreCase(namaProduk) && r.getPengguna().equalsIgnoreCase(namaPengguna)) {
                isiUlasan = r.toString();  
                break;
            }
        }

        RiwayatModerasi.tambahRiwayatHapusUlasan(namaProduk, namaPengguna, isiUlasan);

        Rating.hapusRating(namaProduk, namaPengguna);
        moderator.setJumlahUlasanDihapus(1);
        System.out.println("Ulasan oleh pengguna " + namaPengguna + " untuk produk " + namaProduk + " telah dihapus.");
    }
}
