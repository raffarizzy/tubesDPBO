package com.method.main;

public class Komentar {
    private String namaProduk;
    private String komentarText;

    public Komentar(String namaProduk, String komentarText) {
        this.namaProduk = namaProduk;
        this.komentarText = komentarText;
    }
    
    public String getNamaProduk() {
        return namaProduk;
    }
    
    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }
    
    public String getKomentarText() {
        return komentarText;
    }
    
    public void setKomentarText(String komentarText) {
        this.komentarText = komentarText;
    }
    
    @Override
    public String toString() {
        return "Komentar          : " + komentarText;
    }
}
