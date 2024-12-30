package moderator;

import com.method.main.Menu;
import penjual.Produk;
import java.util.Scanner;
import penjual.LaporUlasan;

public class MenuModerator implements Menu {
    private final Moderator moderator;
    private final Scanner scanner;

    public MenuModerator(Moderator moderator) {
        this.moderator = moderator;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("============================= Menu Moderator =================================");
        System.out.println("1. Lihat laporan");
        System.out.println("2. Hapus Ulasan");
        System.out.println("3. Lihat Riwayat Moderasi");
        System.out.println("4. Lihat Daftar Produk");
        System.out.println("5. Profil");
        System.out.println("6. Keluar");
    }

    @Override
    public void aksi() {
        int pilihan;

        while (true) {
            tampilkanMenu();
            System.out.print("Pilih aksi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

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
                    Produk.tampilkanSemuaProduk();
                    break;
                case 5:
                    moderator.jenisPengguna();
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
        System.out.println("============================= Daftar Produk =================================");
        Produk.tampilkanSemuaProduk();
    }
    
    public void lihatLaporan() {
        System.out.println("============================= Daftar Laporan =================================");
        LaporUlasan.tampilkanLaporan();
    }
}