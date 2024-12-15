package penjual;

import com.method.main.Pengguna;
import java.util.ArrayList;
import java.util.Scanner;


public class Penjual extends Pengguna{
    private static final ArrayList<Penjual> daftarPenjual = new ArrayList<>() {{
        add(new Penjual("rahmah", "rahmah@gmail", "123", "0853"));
    }};


    public Penjual(String nama, String email, String password, String nomorTelepon) {
        super(nama, email, password, nomorTelepon);
    }
    
    public static void loginPenjual(Scanner scan) {
        while (true) { 
            System.out.println("================================ Login Penjual ==============================");
            System.out.print("Email: ");
            String email = scan.nextLine();
            System.out.print("Password: ");
            String password = scan.nextLine();

            Penjual penjual = cariPenjual(email, password);
            if (penjual != null) {
                System.out.println("Login berhasil. Selamat datang, " + penjual.getNama() + "!");
                MenuPenjual menu = new MenuPenjual(penjual);
                menu.aksi();
            } else {
                System.out.println("Login gagal. Email atau password salah. Coba lagi.");
                Penjual.loginPenjual(scan);
            }
        }
    }
    
    public static Penjual cariPenjual(String email, String password) {
        for (Penjual penjual : daftarPenjual) {
            if (penjual.getEmail().equals(email) && penjual.getPassword().equals(password)) {
                return penjual;
            }
        }
        return null;
    }
    
    @Override
    public void jenisPengguna(){
        System.out.println("\n[=== PROFILE PENJUAL ===]");
        super.tampilkanProfil();
    }


}

