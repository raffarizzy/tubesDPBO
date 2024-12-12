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
        System.out.println("======================= Menu Pembeli =======================");
        System.out.println("1. Lihat Produk");
        System.out.println("2. Beli Produk");
        System.out.println("3. Berikan Rating");
        System.out.println("4. Tampilkan Reward");
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
                    System.out.print("Masukkan nama produk yang ingin dibeli: ");
                    String namaProduk = scanner.nextLine();
                    pembeli.beliProduk(namaProduk);
                    break;
                case 3:
                    tampilkanSubMenuRating();
                    break;
                case 4:
                    pembeli.tampilkanReward();
                    break;
                case 5:
                    pembeli.jenisPengguna();
                    break;
                case 6:
                    System.out.println("Keluar dari menu pembeli.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void tampilkanSubMenuRating() {
        int subMenuPilihan;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("========= Sub-Menu Berikan Rating =========");
            System.out.println("1. Tampilkan Produk yang Sudah Dibeli (Belum Diberi Rating)");
            System.out.println("2. Berikan Rating pada Produk yang Sudah Dibeli");
            System.out.println("3. Tampilkan Produk yang Sudah Diberi Rating");
            System.out.println("4. Kembali ke Menu Pembeli");
            System.out.print("Pilih sub-menu : ");
            subMenuPilihan = scanner.nextInt();
            scanner.nextLine();

            switch (subMenuPilihan) {
                case 1:
                    pembeli.tampilkanProdukBelumDiberiRating();
                    break;
                case 2:
                    System.out.print("Masukkan nama produk yang ingin Anda beri rating: ");
                    String namaProduk = scanner.nextLine();
                {
                    String tanggalUlasan = null;
                    pembeli.beriRatingProduk(namaProduk, tanggalUlasan);
                }
                    break;

                case 3:
                    pembeli.tampilkanProdukDiberiRating();
                    break;
                case 4:
                    System.out.println("Kembali ke menu pembeli.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}

