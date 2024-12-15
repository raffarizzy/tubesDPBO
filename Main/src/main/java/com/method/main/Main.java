package com.method.main;

import pembeli.Pembeli;
import java.util.Scanner;
import moderator.Moderator;
import pembeli.MenuPembeli;
import penjual.Penjual;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("|========================= SISTEM ULASAN TOKO ONLINE ========================|");
            System.out.println("|                                                                            |");
            System.out.println("|----------------------------------------------------------------------------|");
            System.out.println("|                                  M E N U                                   |");
            System.out.println("|----------------------------------------------------------------------------|");
            System.out.println("|  1. Login sebagai Pembeli                                                  |");
            System.out.println("|  2. Login sebagai Penjual                                                  |");
            System.out.println("|  3. Login sebagai Moderator                                                |");
            System.out.println("|  4. Keluar dari Sistem                                                     |");
            System.out.println("|============================================================================|");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    Pembeli pembeli = Pembeli.loginPembeli(scanner);
                    MenuPembeli menuPembeli = new MenuPembeli(pembeli);
                    menuPembeli.aksi();
                    break;
                case 2:
                    Penjual.loginPenjual(scanner);
                    break;
                case 3:
                    Moderator.loginModerator(scanner); 
                    break;
                case 4:
                    System.out.println("|============================================================================|");
                    System.out.println("|                Terima kasih telah menggunakan layanan kami!                |");
                    System.out.println("|============================================================================|");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
