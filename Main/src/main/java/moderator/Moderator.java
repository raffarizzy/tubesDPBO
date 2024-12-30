package moderator;

import moderator.MenuModerator;
import com.method.main.Menu;
import com.method.main.Pengguna;
import java.util.ArrayList;
import java.util.Scanner;
import pembeli.Rating;
import penjual.Produk;

public class Moderator extends Pengguna {
    private int jumlahUlasanDihapus;
    private Scanner scanner;
    
    
    private static final ArrayList<Moderator> daftarModerator = new ArrayList<>() {{
        add(new Moderator("Raffa", "raffa@gmail.com", "raffa123", "085138229382"));
    }};

    public Moderator(String nama, String email, String password, String nomorTelepon) {
        super(nama, email, password, nomorTelepon);
        this.jumlahUlasanDihapus = 0;
    }

public static void loginModerator(Scanner scan) { 
    while (true) { 
        System.out.println("======================= Login Moderator ======================");
        System.out.println("Ketik 'exit'untuk keluar dari login moderator.");
        System.out.print("Email: ");
        String email = scan.nextLine();
        if (email.equalsIgnoreCase("exit")) {
            System.out.println("Anda keluar dari login penjual.");
            break; 
        }
        System.out.print("Password: ");
        String password = scan.nextLine();

        Moderator moderator = cariModerator(email, password);
        if (moderator != null) {
            System.out.println("Login berhasil. Selamat datang, " + moderator.getNama() + "!");
            MenuModerator menu = new MenuModerator(moderator);
            menu.aksi(); 
        } else {
            System.out.println("Login gagal. Email atau password salah. Coba lagi.");
        }
    }
}
     
    @Override
    public void jenisPengguna(){
        System.out.println("[=== MODERATOR ===]");
        super.tampilkanProfil();
    }

    // Method untuk mencari moderator berdasarkan email
    public static Moderator cariModerator(String email, String password) {
        for (Moderator moderator : daftarModerator) {
            if (moderator.getEmail().equals(email) && moderator.getPassword().equals(password)) {
                return moderator;
            }
        }
        return null;
    }

    public int getJumlahUlasanDihapus() {
        return jumlahUlasanDihapus;
    }

    // Overriding method tampilkanProfil
    @Override
    public void tampilkanProfil() {
        super.tampilkanProfil();
        System.out.println("Jumlah Ulasan Dihapus : " + jumlahUlasanDihapus);
    }
    
    public void setJumlahUlasanDihapus(int jumlahUlasanDihapus) {
        this.jumlahUlasanDihapus += jumlahUlasanDihapus;
    }
}
