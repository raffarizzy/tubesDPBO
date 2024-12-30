package com.method.main;

import pembeli.Pembeli;
import java.util.InputMismatchException;
import java.util.Scanner;
import moderator.Moderator;
import penjual.Penjual;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
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
                        Pembeli.loginPembeli(scanner);
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
                        System.out.println("Pilihan tidak valid. Mohon pilih menu yang tersedia.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                throw e; 
            }
        }
    }
}
