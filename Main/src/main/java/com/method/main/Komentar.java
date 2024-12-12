package com.method.main;

public class Komentar {
    private String komentarText;
    private String tanggalKomentar;

    public Komentar(String komentarText, String tanggalKomentar) {
        this.komentarText = komentarText;
        this.tanggalKomentar = tanggalKomentar;
    }

    public String getKomentarText() {
        return komentarText;
    }

    public void setKomentarText(String komentarText) {
        this.komentarText = komentarText;
    }

    public String getTanggalKomentar() {
        return tanggalKomentar;
    }

    public void setTanggalKomentar(String tanggalKomentar) {
        this.tanggalKomentar = tanggalKomentar;
    }

    public String toString() {
        return "Tanggal Komentar  : " + tanggalKomentar + "\n" +
               "Komentar          : " + komentarText;
    }
}
