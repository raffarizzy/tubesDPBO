package penjual;

import com.method.main.Menu;
import java.util.Scanner;

public class MenuPenjual implements Menu {
    private final Penjual penjual;
    private Produk produk;
    Scanner scanner = new Scanner(System.in);

    public MenuPenjual(Penjual penjual) {
        this.penjual = penjual;
        this.produk = new Produk();
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("=== Menu Penjual ===");
        System.out.println("1. Daftar Produk");
        System.out.println("2. Tampilkan Profile");
        System.out.println("3. Keluar");
    }

    @Override
    public void aksi() {
        int pilihan;

        while (true) {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    produk.tampilkanSemuaProduk();
                    break;
                case 2:
                    penjual.jenisPengguna();
                    break;
                case 5:
                    System.out.println("Keluar dari menu penjual.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }


    private void balasUlasan() {
        System.out.println("=== Balas Ulasan ===");
        // Implementasi logika balas ulasan
        System.out.println("Fitur ini masih dalam pengembangan.");
    }

    
}

