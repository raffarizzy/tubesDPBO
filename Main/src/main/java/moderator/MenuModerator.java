package moderator;
import com.method.main.Menu;
import java.util.ArrayList;
import java.util.Map;
import penjual.Produk;
import java.util.Scanner;
import pembeli.Rating;
import pembeli.Komentar;
import penjual.LaporUlasan;

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
        System.out.println("3. Lihat Riwayat Moderasi");
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
                    break;
                case 2:
                    HapusUlasan.hapusUlasan(moderator);
                    break;
                case 3:
                    RiwayatModerasi.tampilkanRiwayat();
                    break;
                case 4:
                    produk.tampilkanSemuaProduk();
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

    public void lihatProduk() {
        System.out.println("=== Daftar Produk ===");
        produk.tampilkanSemuaProduk();
    }
    
    public void lihatLaporan() {
        System.out.println("=== Daftar Laporan ===");
        LaporUlasan.tampilkanLaporan();
    }
}