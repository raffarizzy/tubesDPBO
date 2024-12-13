package penjual;


import java.util.ArrayList;

public class Produk {
    private String nama;
    private int harga;
    private String deskripsi;
    
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
            for (Produk produk : daftarProduk) {
                produk.tampilkanInfo();
                System.out.println("---------------------------");
            }
        }
    }

    public void tampilkanInfo() {
        System.out.println("Nama Produk : " + nama);
        System.out.println("Harga       : Rp" + harga);
        System.out.println("Deskripsi   : " + deskripsi);
    }
}
