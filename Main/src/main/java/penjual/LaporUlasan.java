package penjual;
import java.util.Scanner;
import java.util.ArrayList;
import pembeli.Komentar;

public class LaporUlasan {
    private static ArrayList<Komentar> ulasanDilanggar = new ArrayList<>();

    // Melaporkan ulasan yang melanggar ketentuan
    public static void laporUlasan(Komentar ulasan) {
        ulasanDilanggar.add(ulasan);
        System.out.println("Ulasan berhasil dilaporkan dan akan ditinjau oleh moderator.");
    }

    // Menampilkan laporan ulasan
    public static void tampilkanLaporan() {
        if (ulasanDilanggar.isEmpty()) {
            System.out.println("Tidak ada ulasan yang dilaporkan.");
        } else {
            System.out.println("Daftar Ulasan yang Dilaporkan:");
            for (Komentar ulasan : ulasanDilanggar) {
                ulasan.getKomentarText();
            }
        }
    }

    // Mengambil dan menampilkan ulasan yang dapat dilaporkan
    public static void pilihDanLaporUlasan(ArrayList<Komentar> daftarUlasan) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pilih ulasan yang ingin dilaporkan (masukkan index): ");
        for (int i = 0; i < daftarUlasan.size(); i++) {
            System.out.println(i + ". " + daftarUlasan.get(i).getKomentarText());
        }

        int index = sc.nextInt();
        if (index >= 0 && index < daftarUlasan.size()) {
            laporUlasan(daftarUlasan.get(index));
        } else {
            System.out.println("Index tidak valid.");
        }
    }
}