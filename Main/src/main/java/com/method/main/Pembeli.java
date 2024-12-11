package com.method.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Pembeli extends Pengguna {
    private static ArrayList<Pembeli> daftarPembeli = new ArrayList<Pembeli>() {{
        add(new Pembeli("Dhea Sri Noor Septianiz", "dheasrinoorseptianiz@gmail.com", "dhea123", "081234567891"));
    }};

    private ArrayList<RewardUlasan> daftarReward;
    private boolean produkSudahDibeli = false;

    public Pembeli(String nama, String email, String password, String nomorTelepon) {
        super(nama, email, password, nomorTelepon);
        this.daftarReward = new ArrayList<>();
    }

    public static ArrayList<Pembeli> getDaftarPembeli() {
        return daftarPembeli;
    }

    public boolean isProdukSudahDibeli() {
        return produkSudahDibeli;
    }
    
    public static Menu loginPembeli(Scanner scan) {
        System.out.println("====================== Login Pembeli ======================");
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("Password: ");
        String password = scan.nextLine();

        for (Pembeli pembeli : daftarPembeli) {
            if (pembeli.getEmail().equals(email) && pembeli.getPassword().equals(password)) {
                System.out.println("Login berhasil. Selamat datang, " + pembeli.getNama() + "!");
                return new MenuPembeli(pembeli);
            }
        }
        System.out.println("Login gagal. Email atau password salah.");
        return null;
    }

    public void lihatProduk() {
        System.out.println("=== Daftar Produk ===");
        for (Produk produk : Produk.getDaftarProduk()) {
            produk.tampilkanInfo();
            System.out.println("---------------------------");
        }
    }

    public boolean beliProduk(String namaProduk) {
        Produk produk = cariProduk(namaProduk); 
        if (produk != null) {
            this.produkSudahDibeli = true;
            System.out.println("Produk " + produk.getNama() + " berhasil dibeli.");
            return true;
        } else {
            System.out.println("Produk tidak ditemukan.");
            return false;
        }
    }

    public void beriRatingProduk(String namaProduk) {
        if (!produkSudahDibeli) {
            System.out.println("Anda harus membeli produk terlebih dahulu sebelum memberikan rating.");
            return;
        }

        Produk produk = cariProduk(namaProduk); 
        if (produk != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Berikan rating untuk produk " + produk.getNama() + " (1-5): ");
            int rating = scanner.nextInt();
            scanner.nextLine(); 

            if (rating >= 1 && rating <= 5) {
                boolean berhasil = Produk.berikanRating(namaProduk, rating, this.getNama());
                if (berhasil) {
                    System.out.println("Rating " + rating + " berhasil diberikan untuk produk " + produk.getNama() + ".");
                } else {
                    System.out.println("Gagal memberikan rating.");
                }
            } else {
                System.out.println("Rating harus antara 1 dan 5.");
            }
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }
    
    private Produk cariProduk(String namaProduk) {
        for (Produk produk : Produk.getDaftarProduk()) {
            if (produk.getNama().equalsIgnoreCase(namaProduk)) {
                return produk;
            }
        }
        return null;
    }

    public void tampilkanReward() {
        System.out.println("=== Daftar Reward ===");
        if (this.daftarReward.isEmpty()) {
            System.out.println("Belum ada reward.");
        } else {
            for (RewardUlasan reward : this.daftarReward) {
                reward.tampilkanReward();
                System.out.println("------------------------------------------------------");
            }
        }
    }
    
    public void tampilkanProdukBelumDiberiRating() {
        System.out.println("Produk yang sudah dibeli namun belum diberi rating belum tersedia.");
    }

    public void tampilkanProdukDiberiRating() {
        System.out.println("Produk yang sudah diberi rating belum tersedia.");
    }

    @Override
    public void jenisPengguna() {
        System.out.println("[=============== PEMBELI ===============]");
        super.tampilkanProfil();
    }
}
