package com.method.main;

import pembeli.Pembeli;
import java.util.Scanner;
import penjual.Penjual;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("|================ SISTEM ULASAN TOKO ONLINE ===============|");
            System.out.println("|                                                          |");
            System.out.println("|----------------------------------------------------------|");
            System.out.println("|                         M E N U                          |");
            System.out.println("|----------------------------------------------------------|");
            System.out.println("| 1. Login sebagai Pembeli                                 |");
            System.out.println("| 2. Login sebagai Penjual                                 |");
            System.out.println("| 3. Login sebagai Moderator                               |");
            System.out.println("| 4. Keluar dari Sistem                                    |");
            System.out.println("|==========================================================|");
            System.out.print("Pilih: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    Pembeli.loginPembeli(scanner);
                    break;
                case 2:
                    Penjual.loginPenjual(scanner);
                    break;
                case 3:
                    System.out.println("Fitur login moderator belum tersedia."); //implementasiin raff
                    break;
                case 4:
                    System.out.println("|==========================================================|");
                    System.out.println("|       Terima kasih telah menggunakan layanan kami!       |");
                    System.out.println("|==========================================================|");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
