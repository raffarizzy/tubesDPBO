package com.method.main;

import java.util.Scanner;
import java.util.ArrayList;

public class Pembeli extends Pengguna {
    private static ArrayList<Pembeli> daftarPembeli = new ArrayList<Pembeli>() {{
        add(new Pembeli("Dhea Sri Noor Septianiz", "dheasrinoorseptianiz@gmail.com", "dhea123", "081234567891"));
    }};
    
    private ArrayList<RewardUlasan> daftarReward;
    private boolean produkSudahDibeli = false; // Flag untuk menandakan apakah produk sudah dibeli

    public Pembeli(String nama, String email, String password, String nomorTelepon) {
        super(nama, email, password, nomorTelepon);
        this.daftarReward = new ArrayList<>();
    }

    // Method untuk mencari produk berdasarkan nama
    public Produk cariProduk(String namaProduk) {
        for (Produk produk : Produk.getDaftarProduk()) {
            if (produk.getNama().equalsIgnoreCase(namaProduk)) {
                return produk;  // Jika produk ditemukan, kembalikan produk
            }
        }
        return null;  // Jika produk tidak ditemukan
    }

    @Override
    public void jenisPengguna() {
        System.out.println("[=============== PEMBELI ===============]");
        super.tampilkanProfil();
    }

    public ArrayList<RewardUlasan> getDaftarReward() {
        return daftarReward;
    }

    public static void tambahPembeli(Pembeli pembeli) {
        daftarPembeli.add(pembeli);
    }

    public static Pembeli cariPembeli(String email) {
        for (Pembeli pembeli : daftarPembeli) {
            if (pembeli.getEmail().equals(email)) {
                return pembeli;
            }
        }
        return null;
    }

    public boolean beliProduk(String namaProduk) {
        Produk produk = cariProduk(namaProduk);  // Cari produk berdasarkan nama
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

        Produk produk = cariProduk(namaProduk);  // Cari produk berdasarkan nama
        if (produk != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Berikan rating untuk produk " + produk.getNama() + " (1-5): ");
            int rating = scanner.nextInt();
            scanner.nextLine();  // Clear buffer

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

    public boolean isProdukSudahDibeli() {
        return produkSudahDibeli;
    }

    // Menampilkan produk yang belum diberi rating
    public void tampilkanProdukBelumDiberiRating() {
        System.out.println("=== Produk yang Belum Diberi Rating ===");
        boolean adaProdukBelumDiberiRating = false;
        for (Produk produk : Produk.getDaftarProduk()) {
            boolean sudahDiberiRating = false;
            for (Rating rating : Produk.getDaftarRating()) {
                if (rating.getUlasan().contains(produk.getNama()) && rating.getPengguna().equals(this.getNama())) {
                    sudahDiberiRating = true;
                    break;
                }
            }
            if (!sudahDiberiRating) {
                produk.tampilkanInfo();
                adaProdukBelumDiberiRating = true;
                System.out.println("---------------------------");
            }
        }
        if (!adaProdukBelumDiberiRating) {
            System.out.println("Semua produk sudah diberi rating.");
        }
    }

    // Menampilkan produk yang sudah diberi rating
    public void tampilkanProdukDiberiRating() {
        System.out.println("=== Produk yang Sudah Diberi Rating ===");
        boolean adaProdukDiberiRating = false;
        for (Produk produk : Produk.getDaftarProduk()) {
            boolean sudahDiberiRating = false;
            for (Rating rating : Produk.getDaftarRating()) {
                if (rating.getUlasan().contains(produk.getNama()) && rating.getPengguna().equals(this.getNama())) {
                    sudahDiberiRating = true;
                    break;
                }
            }
            if (sudahDiberiRating) {
                produk.tampilkanInfo();
                adaProdukDiberiRating = true;
                System.out.println("---------------------------");
            }
        }
        if (!adaProdukDiberiRating) {
            System.out.println("Belum ada produk yang diberi rating.");
        }
    }
}
