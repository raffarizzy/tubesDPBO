package moderator;
import com.method.main.Menu;
import penjual.Produk;
import java.util.Scanner;
import pembeli.Rating;
import pembeli.Komentar;

public class MenuModerator implements Menu {
    private final Produk produk;
    private Moderator moderator;
    private Scanner scanner;

    public MenuModerator(Moderator moderator) {
        this.moderator = moderator;
        this.produk = new Produk();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("=== Menu Moderator ===");
        System.out.println("1. Lihat laporan");
        System.out.println("2. Hapus Ulasan");
        System.out.println("3. Hapus Komentar");
        System.out.println("4. Lihat Daftar Produk");
        System.out.println("5. Tampilkan Profil");
        System.out.println("6. Logout");
    }

    @Override
    public void aksi() {
        int pilihan;

        while (true) {
            tampilkanMenu();
            System.out.print("Pilih aksi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (pilihan) {
                case 1:
                    lihatLaporan();
                case 2:
                    hapusUlasan();
                    break;
                case 3:
                    hapusKomentar();
                    break;
                case 4:
                    lihatProduk();
                    break;
                case 5:
                    moderator.tampilkanProfil();
                    break;
                case 6:
                    System.out.println("Keluar dari menu moderator.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    
    // Method untuk menghapus ulasan
    private void hapusUlasan() {
        System.out.print("Masukan nama produk: ");
        String namaProduk = scanner.nextLine();
        boolean produkDitemukan = false;

        // Pengecekan apakah produk ada dalam daftar produk
        for (Produk p : Produk.getDaftarProduk()) {
            if (namaProduk.equals(p.getNama())) {
                produkDitemukan = true;
                break;
            }
        }

        if (!produkDitemukan) {
            System.out.println("Nama produk tidak ditemukan!");
            return;  // Keluar dari metode jika produk tidak ditemukan
        }

        System.out.print("Masukkan nama pengguna yang memberi ulasan: ");
        String namaPengguna = scanner.nextLine();
        boolean penggunaDitemukan = false;

        // Pengecekan apakah pengguna ada dalam daftar rating
        for (Rating r : Rating.getDaftarRating()) {
            if (namaPengguna.equals(r.getPengguna())) {
                penggunaDitemukan = true;
                break;
            }
        }

        if (!penggunaDitemukan) {
            System.out.println("Nama pengguna tidak ditemukan!");
            return;  // Keluar dari metode jika pengguna tidak ditemukan
        }

        // Menghapus rating jika produk dan pengguna ditemukan
        Rating.hapusRating(namaProduk, namaPengguna);
        System.out.println("Ulasan oleh pengguna " + namaPengguna + " untuk produk " + namaProduk + " telah dihapus.");
    }

    private void hapusKomentar() {
        System.out.print("Masukan nama produk: ");
        String namaProduk = scanner.nextLine();
        boolean produkDitemukan = false;

        // Pengecekan apakah produk ada dalam daftar produk
        for (Produk p : Produk.getDaftarProduk()) {
            if (namaProduk.equals(p.getNama())) {
                produkDitemukan = true;
                break;
            }
        }

        if (!produkDitemukan) {
            System.out.println("Nama produk tidak ditemukan!");
            return;  // Keluar dari metode jika produk tidak ditemukan
        }

        System.out.print("Masukkan nama pengguna yang berkomentar: ");
        String namaPengguna = scanner.nextLine();
        boolean penggunaDitemukan = false;

        // Pengecekan apakah pengguna ada dalam daftar rating
        int counter = 0;
        int selected = 0;
        for (Rating r : Rating.getDaftarRating()) {
            if (namaPengguna.equals(r.getPengguna())) {
                selected = counter;
                penggunaDitemukan = true;
                break;
            }
           counter = counter + 1;
        }

        if (!penggunaDitemukan) {
            System.out.println("Nama pengguna tidak ditemukan!");
            return;  // Keluar dari metode jika pengguna tidak ditemukan
        }

        Komentar.hapusKomentar(selected);
        System.out.println("Komentar oleh pengguna " + namaPengguna + " untuk produk " + namaProduk + " telah dihapus.");
    }

    private void lihatProduk() {
        System.out.println("=== Daftar Produk ===");
        produk.tampilkanSemuaProduk();
    }
    
    private void lihatLaporan() {
        System.out.println("=== Daftar Laporan ===");
    }
}

