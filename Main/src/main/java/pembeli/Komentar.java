package pembeli;

import java.util.ArrayList;

public class Komentar {
    private String komentarText;

    private static final ArrayList<Komentar> daftarKomentar = new ArrayList<>() {{
        add(new Komentar("Produk sangat sesuai harapan"));
        add(new Komentar("Cukup memuaskan"));
        add(new Komentar("Kualitas suara bagus"));
        add(new Komentar("Nyaman dipakai sepanjang hari"));
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