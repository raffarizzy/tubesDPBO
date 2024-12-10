package com.method.main;

import java.util.Scanner;

public class MenuPembeli implements Menu {
    private final Pembeli pembeli;

    public MenuPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("=============== Menu Pembeli ===============");
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
            scanner.nextLine(); // Clear buffer

            switch (pilihan) {
                case 1:
                    Produk.tampilkanSemuaProduk();  // Tampilkan semua produk
                    break;
                case 2:
                    // Minta pengguna memasukkan nama produk yang ingin dibeli
                    System.out.print("Masukkan nama produk yang ingin dibeli: ");
                    String namaProduk = scanner.nextLine();
                    if (pembeli.beliProduk(namaProduk)) {
                        System.out.println("Produk berhasil dibeli.");
                    } else {
                        System.out.println("Gagal membeli produk.");
                    }
                    break;
                case 3:
                    tampilkanSubMenuRating();  // Menampilkan sub-menu untuk rating
                    break;
                case 4:
                    pembeli.tampilkanReward();  // Menampilkan daftar reward
                    break;
                case 5:
                    pembeli.jenisPengguna();  // Menampilkan profil pembeli
                    break;
                case 6:
                    System.out.println("Keluar dari menu pembeli.");
                    return;  // Keluar dari menu pembeli
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
            scanner.nextLine(); // Clear buffer

            switch (subMenuPilihan) {
                case 1:
                    pembeli.tampilkanProdukBelumDiberiRating();  // Tampilkan produk yang sudah dibeli tapi belum diberi rating
                    break;
                case 2:
                    if (pembeli.isProdukSudahDibeli()) {
                        // Minta pengguna memasukkan nama produk yang ingin diberi rating
                        System.out.print("Masukkan nama produk yang ingin Anda beri rating: ");
                        String namaProduk = scanner.nextLine();
                        pembeli.beriRatingProduk(namaProduk);  // Berikan rating pada produk yang sudah dibeli
                    } else {
                        System.out.println("Anda harus membeli produk terlebih dahulu.");
                    }
                    break;
                case 3:
                    pembeli.tampilkanProdukDiberiRating();  // Tampilkan produk yang sudah diberi rating
                    break;
                case 4:
                    System.out.println("Kembali ke menu pembeli.");
                    return;  // Kembali ke menu utama pembeli
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
