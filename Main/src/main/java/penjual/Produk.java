package penjual;

import java.util.Scanner;
import java.util.ArrayList;
import pembeli.Komentar;
import pembeli.Rating;

public class Produk {
    private String nama;
    private int harga;
    private String deskripsi;
    //private final LaporUlasan laporUlasan;
    private MenuPenjual menuPenjual;
    
    private static final ArrayList<Produk> daftarProduk = new ArrayList<>() {{
        add(new Produk("Laptop ABC", 5000000, "Laptop dengan spesifikasi tinggi dan desain elegan."));
        add(new Produk("Headphone DEF", 300000, "Headphone dengan kualitas suara terbaik dan nyaman digunakan."));
    }};

    public Produk(String nama, int harga, String deskripsi) {
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }
    
    public Produk(){
        this.menuPenjual = new MenuPenjual();
    }
    
    public String getNama() {
        return nama;
    }
    
    public static ArrayList<Produk> getDaftarProduk() {
        return daftarProduk;
    }

    public void tampilkanSemuaProduk() {
        if (daftarProduk.isEmpty()) {
            System.out.println("Tidak ada produk yang tersedia.");
        } else {
            System.out.println("==============================================================================");
            System.out.println("                                DAFTAR PRODUK                               ");
            System.out.println("==============================================================================");

            for (Produk produk : daftarProduk) {
                produk.tampilkanInfo();
                System.out.println("\nUlasan dan Rating:");
                Rating.tampilkanRating(produk.getNama()); 
                System.out.println("------------------------------------------------------------------------------");
            }
        }
    }

    public void tampilkanInfo() {
        System.out.println("Nama Produk : " + nama);
        System.out.println("Harga       : Rp" + harga);
        System.out.println("Deskripsi   : " + deskripsi);
    }
    
    public void menuProduk(){
        while(true) {
            tampilkanSemuaProduk();
            System.out.println("=== Tinjau Produk ===");
            System.out.println("1. Balas Ulasan");
            System.out.println("2. Lapor Ulasan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            Scanner sc = new Scanner(System.in);
            int pilih = sc.nextInt();
            
            switch(pilih) {
                case 1 :
                    //LaporUlasan.balasUlasan();
                    break;
                case 2 :
                    //balasUlasan();
                    break;
                case 3:
                    menuPenjual.aksi();
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        }
    }  
}