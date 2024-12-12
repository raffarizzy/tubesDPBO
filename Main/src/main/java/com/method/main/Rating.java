package com.method.main;

public class Rating {
    private String pengguna;
    private int ratingBintang;
    private String tanggalUlasan;

    public Rating(String pengguna, String ulasan, int ratingBintang) {
        this.pengguna = pengguna;
        this.ratingBintang = ratingBintang;
    }

    // Getter dan Setter
    public String getPengguna() {
        return pengguna;
    }

    public void setPengguna(String pengguna) {
        this.pengguna = pengguna;
    }

    public int getRatingBintang() {
        return ratingBintang;
    }

    public void setRatingBintang(int ratingBintang) {
        if (ratingBintang >= 1 && ratingBintang <= 5) {
            this.ratingBintang = ratingBintang;
        } else {
            System.out.println("Rating harus antara 1 dan 5.");
        }
    }

    @Override
    public String toString() {
        return "Pengguna      : " + pengguna + "\n" +
               "Rating        : " + ratingBintang + " bintang";
    }
}
