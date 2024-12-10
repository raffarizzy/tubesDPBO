package com.method.main;

import java.util.ArrayList;

/**
 *
 * @author Dhea Sri Noor Septianiz
 */
public class Produk {
    private String nama;
    private int harga;
    private String deskripsi;
    private static ArrayList<Produk> daftarProduk = new ArrayList<>() {{
        add(new Produk("Laptop ABC", 5000000, "Laptop dengan spesifikasi tinggi dan desain elegan."));
        add(new Produk("Headphone DEF", 300000, "Headphone dengan kualitas suara terbaik dan nyaman digunakan."));
    }};
    private static ArrayList<Rating> daftarRating = new ArrayList<>();  // Daftar rating produk

    public Produk(String nama, int harga, String deskripsi) {
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    // Menambahkan produk ke daftar
    public static void tambahProduk(Produk produk) {
        daftarProduk.add(produk);
    }

    // Menghapus produk berdasarkan nama
    public static boolean hapusProduk(String namaProduk) {
        for (Produk produk : daftarProduk) {
            if (produk.getNama().equalsIgnoreCase(namaProduk)) {
                daftarProduk.remove(produk);
                return true;
            }
        }
        return false;
    }

    // Menampilkan semua produk
    public static void tampilkanSemuaProduk() {
        if (daftarProduk.isEmpty()) {
            System.out.println("Tidak ada produk yang tersedia.");
        } else {
            for (Produk produk : daftarProduk) {
                produk.tampilkanInfo();
                System.out.println("---------------------------");
            }
        }
    }

    // Method untuk memberikan rating
    public static boolean berikanRating(String namaProduk, int rating, String pengguna) {
        for (Produk produk : daftarProduk) {
            if (produk.getNama().equalsIgnoreCase(namaProduk)) {
                // Menambahkan rating untuk produk
                Rating newRating = new Rating(pengguna, "Ulasan produk " + namaProduk, rating);
                daftarRating.add(newRating);
                return true;
            }
        }
        return false;
    }

    // Menampilkan rating produk
    public static double cekRatingProduk(String namaProduk) {
        int totalRating = 0;
        int jumlahRating = 0;
        for (Rating rating : daftarRating) {
            if (rating.getUlasan().contains(namaProduk)) {
                totalRating += rating.getRatingBintang();
                jumlahRating++;
            }
        }
        if (jumlahRating > 0) {
            return (double) totalRating / jumlahRating;
        } else {
            return -1;  // Jika tidak ada rating, kembalikan -1
        }
    }

    // Menampilkan informasi produk
    public void tampilkanInfo() {
        System.out.println("Nama Produk : " + nama);
        System.out.println("Harga       : Rp" + harga);
        System.out.println("Deskripsi   : " + deskripsi);
    }

    // Menambahkan metode getDaftarProduk() untuk mengakses daftar produk
    public static ArrayList<Produk> getDaftarProduk() {
        return daftarProduk;
    }

    // Menambahkan metode getDaftarRating() untuk mengakses daftar rating
    public static ArrayList<Rating> getDaftarRating() {
        return daftarRating;
    }
}
