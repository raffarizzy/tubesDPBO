package pembeli;

public class Komentar {
    private String komentarText;

    public Komentar(String komentarText) {
        this.komentarText = komentarText;
    }

    public String getKomentarText() {
        return komentarText;
    }

    public void setKomentarText(String komentarText) {
        this.komentarText = komentarText;
    }

    @Override
    public String toString() {
        return "Komentar: " + komentarText;
    }
}
