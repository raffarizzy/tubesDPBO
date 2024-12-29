package pembeli;

import com.method.main.Menu;
import penjual.Produk;
import java.util.Scanner;

public class MenuPembeli implements Menu {
    private final Pembeli pembeli;

    public MenuPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("============================== Menu Pembeli ==================================");
        System.out.println("1. Lihat Produk");
        System.out.println("2. Lihat Produk yang Sudah Dibeli");
        System.out.println("3. Berikan Rating Pada Produk yang Sudah Dibeli");
        System.out.println("4. Lihat Produk yang Sudah Diberi Rating");
        System.out.println("5. Profil");
        System.out.println("6. Keluar");
    }

    @Override
    public void aksi() {
        int pilihan;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            tampilkanMenu();
            System.out.print("Pilih menu : ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    Produk.tampilkanSemuaProduk();
                    break;
                case 2:
                    pembeli.tampilkanProdukSudahDibeli(); 
                    break;
                case 3:
                    pembeli.berikanRating(); 
                    break;
                case 4:
                    pembeli.tampilkanProdukDiberiRating(); 
                    break;
                case 5:
                    pembeli.jenisPengguna(); 
                    break;
                case 6:
                    System.out.println("Kembali ke menu utama ...\n");
                    return; 
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
