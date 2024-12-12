package com.method.main;

public abstract class Pengguna {
    private String nama;
    private String email;
    private String password;
    private String nomorTelepon;

    public Pengguna(String nama, String email, String password, String nomorTelepon) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.nomorTelepon = nomorTelepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.isEmpty()) {
            this.nama = nama;
        } else {
            System.out.println("Nama tidak boleh kosong.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Email tidak valid.");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 6) {
            this.password = password;
        } else {
            System.out.println("Password harus memiliki minimal 6 karakter.");
        }
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        if (nomorTelepon != null && nomorTelepon.length() >= 10) {
            this.nomorTelepon = nomorTelepon;
        } else {
            System.out.println("Nomor telepon harus memiliki minimal 10 digit.");
        }
    }

    public abstract void jenisPengguna();

    public void tampilkanProfil() {
        System.out.println("Nama         : " + nama);
        System.out.println("Email        : " + email);
        System.out.println("Nomor Telepon: " + nomorTelepon);
        System.out.println();
    }
}
