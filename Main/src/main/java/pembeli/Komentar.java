package pembeli;

import java.util.ArrayList;

public class Komentar {
    private final String komentarText;
    private final ArrayList<String> balasan; // Tambahkan daftar balasan

    public Komentar(String komentarText) {
        this.komentarText = komentarText;
        this.balasan = new ArrayList<>();
    }

    public String getKomentarText() {
        return komentarText;
    }

    public void tambahBalasan(String balasan) {
        this.balasan.add(balasan);
    }

    public ArrayList<String> getBalasan() {
        return balasan;
    }

    public static ArrayList<Komentar> getDaftarKomentar() {
        ArrayList<Komentar> daftarKomentar = new ArrayList<>();
        daftarKomentar.add(new Komentar("Barang sangat bagus, sesuai ekspektasi."));
        daftarKomentar.add(new Komentar("Packing kurang rapi, tapi barangnya oke."));
        daftarKomentar.add(new Komentar("Barang tidak sesuai deskripsi."));
        daftarKomentar.add(new Komentar("Layanan cepat dan memuaskan."));
        return daftarKomentar;
    }

    @Override
    public String toString() {
        String result = komentarText + "\n  Balasan:";
        for (String b : balasan) {
            result += "\n    - " + b;
        }
        return result;
    }
}
