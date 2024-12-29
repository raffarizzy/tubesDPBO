package penjual;

import com.method.main.Menu;
import java.util.Scanner;

public class MenuPenjual implements Menu {
    private Penjual penjual;
    private Produk produk;
    Scanner scanner = new Scanner(System.in);

    public MenuPenjual(Penjual penjual) {
        this.penjual = penjual;
        this.produk = new Produk();
    }
    
    public MenuPenjual(){
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
        
        while (true) {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    produk.menuProduk();
                    break;
                case 2:
                    penjual.jenisPengguna();
                    break;
                case 3:
                    System.out.println("Keluar dari menu penjual.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}