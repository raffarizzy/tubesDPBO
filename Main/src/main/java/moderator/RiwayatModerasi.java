package moderator;

import java.util.ArrayList;

public class RiwayatModerasi {
    private static final ArrayList<String> riwayat = new ArrayList<>();
    
    public static void tambahRiwayatHapusUlasan(String namaProduk, String namaPengguna, String isiUlasan){
        String entri = "Ulasan oleh pengguna '" + namaPengguna + "' untuk produk '" + namaProduk + "' telah dihapus.\n" + 
                        "Isi Ulasan Sebelum Dihapus:\n" + isiUlasan;
        riwayat.add(entri);
    }
    
    public static void tampilkanRiwayat() {
        System.out.println("============================== Riwayat Moderasi ==============================");
        if (riwayat.isEmpty()) {
            System.out.println("Tidak ada riwayat moderasi");
        } else {
            for (int i = 0; i < riwayat.size(); i++) {
                System.out.println((i + 1) + ". " + riwayat.get(i));
            }
        }
    }
}
