package penjual;
import java.util.Scanner;
import java.util.ArrayList;
import pembeli.Komentar;
import pembeli.Rating;

public class LaporUlasan {
    private final String namaProduk;
    private final String namaPengguna;
    private final String komentar;

    public LaporUlasan(String namaProduk, String namaPengguna, String komentar) {
        this.namaProduk = namaProduk;
        this.namaPengguna = namaPengguna;
        this.komentar = komentar;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public String getKomentar() {
        return komentar;
    }

    public static ArrayList<LaporUlasan> getUlasanDilanggar() {
        return ulasanDilanggar;
    }
    
    private static final ArrayList<LaporUlasan> ulasanDilanggar = new ArrayList<>();
   
    public static void tampilkanLaporan() {
        if (getUlasanDilanggar().isEmpty()) {
            System.out.println("Tidak ada ulasan yang dilaporkan.");
        } else {
            System.out.println("Daftar Ulasan yang Dilaporkan:");
            for (LaporUlasan ulasan : ulasanDilanggar) {
                System.out.println("- Produk: " + ulasan.getNamaProduk());
                System.out.println("  Pengguna: " + ulasan.getNamaPengguna());
                System.out.println("  Ulasan: " + ulasan.getKomentar());
                System.out.println();
            }
        }
    }

    public static void pilihDanLaporUlasan() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan nama produk yang ulasannya ingin dilaporkan: ");
        String namaProduk = sc.nextLine();
        
        boolean produkDitemukan = false;
        for (Rating rating : Rating.getDaftarRating()) {
            if (rating.getNamaProduk().equalsIgnoreCase(namaProduk)) {
                produkDitemukan = true;
                break;
            }
        }

        if (!produkDitemukan) {
            System.out.println("Produk dengan nama \"" + namaProduk + "\" tidak ditemukan!");
            return;
        }
        
        System.out.print("Masukkan nama pengguna yang ulasannya ingin dilaporkan: ");
        String namaPengguna = sc.nextLine();
        
        ArrayList<Komentar> komentarTerkait = new ArrayList<>();
        for (Rating rating : Rating.getDaftarRating()) {
            if (rating.getNamaProduk().equalsIgnoreCase(namaProduk) &&
                rating.getPengguna().equalsIgnoreCase(namaPengguna)) {
                komentarTerkait.addAll(rating.getDaftarKomentar());
            }
        }

        if (komentarTerkait.isEmpty()) {
            System.out.println("Tidak ada ulasan untuk produk \"" + namaProduk + "\" oleh pengguna \"" + namaPengguna + "\".");
            return;
        }
        
        // Menampilkan komentar terkait
        System.out.println("\nDaftar Ulasan Terkait:");
        for (int i = 0; i < komentarTerkait.size(); i++) {
            System.out.println((i + 1) + ". " + komentarTerkait.get(i).getKomentarText());
        }

        // Pilih ulasan untuk dilaporkan
        System.out.print("\nMasukkan nomor ulasan yang ingin dilaporkan: ");
        int pilihan = sc.nextInt();

        if (pilihan < 1 || pilihan > komentarTerkait.size()) {
            System.out.println("Pilihan tidak valid!");
            return;
        }
           
        // Menambahkan ke daftar laporan
        Komentar ulasanDipilih = komentarTerkait.get(pilihan - 1);
        ulasanDilanggar.add(new LaporUlasan(namaProduk, namaPengguna, ulasanDipilih.getKomentarText()));
        System.out.println("Ulasan \"" + ulasanDipilih.getKomentarText() +
                       "\" telah dilaporkan untuk produk \"" + namaProduk +
                       "\" oleh pengguna \"" + namaPengguna + "\".");

    }
}