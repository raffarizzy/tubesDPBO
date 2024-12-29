package pembeli;

import java.util.ArrayList;

public class Komentar {
    private String komentarText;

    public static ArrayList<Komentar> daftarKomentar = new ArrayList<>() {{
        add(new Komentar("Produk sangat sesuai harapan"));
        add(new Komentar("Cukup memuaskan"));
        add(new Komentar("Kualitas suara bagus"));
        add(new Komentar("Nyaman dipakai sepanjang hari"));
        add(new Komentar("Pengiriman lama, tidak sesuai deskripsi."));
        add(new Komentar("Sangat mengecewakan, produk cacat."));
    }};

    public Komentar(String komentarText) {
        this.komentarText = komentarText;
    }

    public String getKomentarText() {
        return komentarText;
    }

    public void setKomentarText(String komentarText) {
        this.komentarText = komentarText;
    }

    public static ArrayList<Komentar> getDaftarKomentar() {
        return daftarKomentar;
    }
    
    public static void hapusKomentar(int urutan) {
        daftarKomentar.get(urutan).setKomentarText("**Komentar telah dihapus oleh moderator**");
    }
}