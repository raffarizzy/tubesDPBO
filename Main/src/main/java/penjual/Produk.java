package penjual;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pembeli.Komentar;
import pembeli.Rating;

public class Produk {
    private String nama;
    private int harga;
    private String deskripsi;
    private ArrayList<Komentar> daftarUlasan;
    private MenuPenjual menuPenjual;

    private static HashMap<String, ArrayList<Produk>> daftarProduk = new HashMap<>();
    
    public Produk(String nama, int harga, String deskripsi) {
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }
    
    public Produk() {
        this.menuPenjual = new MenuPenjual();
    }
    
    /**
     *
     */
    public static void initializeDaftarProduk(){
        ArrayList<Produk> produkRahmah = new ArrayList<>();
        produkRahmah.add(new Produk("Laptop ABC", 5000000, "Laptop dengan spesifikasi tinggi dan desain elegan."));
        produkRahmah.add(new Produk("Headphone DEF", 300000, "Headphone dengan kualitas suara terbaik dan nyaman digunakan."));
        
        daftarProduk.put("Rahmah", produkRahmah);
    }
    
    public static HashMap<String, ArrayList<Produk>> getDaftarProduk() {
        return daftarProduk;
    }

    public static void tampilkanSemuaProduk() {
        initializeDaftarProduk();
        if (getDaftarProduk().isEmpty()) {
            System.out.println("Tidak ada produk yang tersedia.");
        } else {
            System.out.println("==============================================================================");
            System.out.println("                                DAFTAR PRODUK                               ");
            System.out.println("==============================================================================");
            
            for (Map.Entry<String, ArrayList<Produk>> entry : getDaftarProduk().entrySet()) {
                String penjual = entry.getKey();
                ArrayList<Produk> produkList = entry.getValue();
                
                System.out.println("Penjual\t\t: " + penjual);
                for (Produk produk : produkList) {
                    produk.tampilkanInfo();
                    System.out.println("\nUlasan dan Rating");
                    Rating.tampilkanRating(produk.getNama()); 
                    System.out.println("------------------------------------------------------------------------------");
                }
            }
        }
    }

    public void tampilkanInfo() {
        System.out.println("Nama Produk\t: " + nama);
        System.out.println("Harga\t\t: Rp" + harga);
        System.out.println("Deskripsi\t: " + deskripsi);
    }
    
    public String getNama() {
        return nama;
    }
    
    public void tambahUlasan(Komentar komentar) {
        daftarUlasan.add(komentar);
    }
    
    public void menuProduk(){
        initializeDaftarProduk();
        Scanner sc = new Scanner(System.in);
            while(true) {
                tampilkanSemuaProduk();
                System.out.println("=== Tinjau Produk ===");
                System.out.println("1. Balas Ulasan");
                System.out.println("2. Lapor Ulasan");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");
                int pilih = sc.nextInt();

                switch(pilih) {
                    case 1 :
                        BalasUlasan.balasUlasan();
                        break;
                    case 2 :
                        LaporUlasan.pilihDanLaporUlasan();
                        break;
                    case 3:
                        System.out.println("Kembali ke menu sebelumnya...");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid! Silakan coba lagi.");
                }
            }
    }  
}