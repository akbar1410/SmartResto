package com.mycompany.smartresto;

import java.util.Scanner;

public class SmartResto {

    public static void cariMenu(String nama, MenuResto[] daftar, int jumlah) {
        System.out.println("\n--------------------------------------------------");
        System.out.println(" Hasil Pencarian Nama Menu: '" + nama + "'");
        System.out.println("--------------------------------------------------");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNama().equalsIgnoreCase(nama)) {
                System.out.print(">> ");
                daftar[i].tampilkanInfo();
                daftar[i].infoPenyajian();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("[-] Menu dengan nama tersebut tidak ditemukan.");
    }

    public static void cariMenu(String kategori, boolean isKategori, MenuResto[] daftar, int jumlah) {
        System.out.println("\n--------------------------------------------------");
        System.out.println(" Hasil Pencarian Kategori: '" + kategori + "'");
        System.out.println("--------------------------------------------------");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getKategori().equalsIgnoreCase(kategori)) {
                System.out.print(">> ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("[-] Menu dengan kategori tersebut tidak ditemukan.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuResto[] daftarMenu = new MenuResto[20];
        int jumlahMenu = 0;
        boolean isRunning = true;

        daftarMenu[jumlahMenu++] = new Makanan("Nasi Goreng Spesial", "Utama", 25000, "Sedang");
        daftarMenu[jumlahMenu++] = new Makanan("Ayam Bakar Madu", "Utama", 30000, "Tidak Pedas");
        daftarMenu[jumlahMenu++] = new Minuman("Es Teh Manis", "Minuman", 5000, "Dingin");
        daftarMenu[jumlahMenu++] = new Minuman("Kopi Hitam", "Minuman", 10000, "Hangat");
        daftarMenu[jumlahMenu++] = new Dessert("Pancake Cokelat", "Penutup", 18000, false);
        daftarMenu[jumlahMenu++] = new Dessert("Es Krim Vanilla", "Penutup", 15000, true);

        while (isRunning) {
            System.out.println("\n==================================================");
            System.out.println("      SMART RESTO MANAGEMENT SYSTEM (CLI)         ");
            System.out.println("==================================================");
            System.out.println(" [1] Tambah Menu Baru");
            System.out.println(" [2] Tampilkan Seluruh Menu Resto");
            System.out.println(" [3] Cari Menu (Fitur Overloading)");
            System.out.println(" [4] Filter Jenis Menu");
            System.out.println(" [5] Edit Harga Menu");
            System.out.println(" [6] Laporan & Analisis Penjualan Menu");
            System.out.println(" [7] Keluar");
            System.out.println("==================================================");
            System.out.print("Pilih Menu Opsi (1-7): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    if (jumlahMenu < daftarMenu.length) {
                        System.out.println("\n>>> FORM TAMBAH MENU BARU <<<");
                        System.out.println("1. Tambah Makanan");
                        System.out.println("2. Tambah Minuman");
                        System.out.println("3. Tambah Dessert");
                        System.out.print("Pilih Jenis Menu (1-3): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Nama Menu     : ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Kategori Menu : ");
                        String kategori = scanner.nextLine();
                        System.out.print("Masukkan Harga (Rp)    : ");
                        double harga = scanner.nextDouble();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Tingkat Pedas (Pedas/Sedang/Tidak): ");
                            String pedas = scanner.nextLine();
                            daftarMenu[jumlahMenu++] = new Makanan(nama, kategori, harga, pedas);
                        } else if (jenis == 2) {
                            System.out.print("Suhu Penyajian (Dingin/Hangat)    : ");
                            String suhu = scanner.nextLine();
                            daftarMenu[jumlahMenu++] = new Minuman(nama, kategori, harga, suhu);
                        } else if (jenis == 3) {
                            System.out.print("Apakah Sajian Dingin? (true/false): ");
                            boolean dingin = scanner.nextBoolean();
                            scanner.nextLine();
                            daftarMenu[jumlahMenu++] = new Dessert(nama, kategori, harga, dingin);
                        } else {
                            System.out.println("[-] Pilihan jenis menu tidak valid!");
                            break;
                        }
                        System.out.println("[+] SUKSES: Menu baru berhasil ditambahkan.");
                    } else {
                        System.out.println("[-] ERROR: Kapasitas penyimpanan menu sudah penuh!");
                    }
                }

                case 2 -> {
                    System.out.println("\n>>> DAFTAR SELURUH MENU SMART RESTO <<<");
                    if (jumlahMenu == 0) {
                        System.out.println("[-] Belum ada menu yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahMenu; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarMenu[i].tampilkanInfo();
                            daftarMenu[i].infoPenyajian();
                            System.out.println();
                        }
                        System.out.println("--------------------------------------------------");
                        System.out.println("* Total Item Menu Berhasil Dibuat: " + MenuResto.totalMenuBerhasilDibuat);
                    }
                    System.out.print("\nTekan Enter untuk kembali...");
                    scanner.nextLine();
                }

                case 3 -> {
                    System.out.println("\n>>> FITUR PENCARIAN MENU (OVERLOADING) <<<");
                    System.out.println("1. Cari Berdasarkan Nama Menu");
                    System.out.println("2. Cari Berdasarkan Kategori Menu");
                    System.out.print("Pilih Metode Cari (1/2): ");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan Kata Kunci Nama: ");
                        String namaCari = scanner.nextLine();
                        cariMenu(namaCari, daftarMenu, jumlahMenu);
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Kata Kunci Kategori: ");
                        String katCari = scanner.nextLine();
                        cariMenu(katCari, true, daftarMenu, jumlahMenu);
                    } else {
                        System.out.println("[-] Pilihan mode pencarian tidak valid.");
                    }
                    System.out.print("\nTekan Enter untuk kembali...");
                    scanner.nextLine();
                }

                case 4 -> {
                    System.out.println("\n>>> FILTER JENIS MENU <<<");
                    System.out.println("1. Tampilkan Khusus Makanan");
                    System.out.println("2. Tampilkan Khusus Minuman");
                    System.out.println("3. Tampilkan Khusus Dessert");
                    System.out.print("Pilih Filter (1-3): ");
                    int filter = scanner.nextInt();
                    scanner.nextLine();

                    boolean ada = false;
                    System.out.println("\n--- Hasil Filter ---");
                    for (int i = 0; i < jumlahMenu; i++) {
                        if (filter == 1 && daftarMenu[i] instanceof Makanan) {
                            daftarMenu[i].tampilkanInfo();
                            ada = true;
                        } else if (filter == 2 && daftarMenu[i] instanceof Minuman) {
                            daftarMenu[i].tampilkanInfo();
                            ada = true;
                        } else if (filter == 3 && daftarMenu[i] instanceof Dessert) {
                            daftarMenu[i].tampilkanInfo();
                            ada = true;
                        }
                    }
                    if (!ada) System.out.println("[-] Tidak ada menu dalam jenis ini.");
                    System.out.print("\nTekan Enter untuk kembali...");
                    scanner.nextLine();
                }

                case 5 -> {
                    System.out.println("\n>>> EDIT HARGA MENU <<<");
                    for (int i = 0; i < jumlahMenu; i++) {
                        System.out.println((i + 1) + ". " + daftarMenu[i].getNama() + " - Rp" + daftarMenu[i].getHarga());
                    }
                    System.out.print("Pilih nomor menu yang ingin diubah harganya: ");
                    int noMenu = scanner.nextInt();
                    scanner.nextLine();

                    if (noMenu > 0 && noMenu <= jumlahMenu) {
                        System.out.print("Masukkan Harga Baru (Rp): ");
                        double hargaBaru = scanner.nextDouble();
                        scanner.nextLine();

                        daftarMenu[noMenu - 1].setHarga(hargaBaru);
                        System.out.println("[+] SUKSES: Harga menu berhasil diperbarui.");
                    } else {
                        System.out.println("[-] Nomor menu tidak ditemukan!");
                    }
                    System.out.print("\nTekan Enter untuk kembali...");
                    scanner.nextLine();
                }

                case 6 -> {
                    System.out.println("\n>>> LAPORAN ANALISIS MENU RESTO <<<");
                    if (jumlahMenu == 0) {
                        System.out.println("[-] Tidak ada data menu.");
                    } else {
                        double totalHarga = 0;
                        MenuResto termahal = daftarMenu[0];
                        MenuResto termurah = daftarMenu[0];

                        for (int i = 0; i < jumlahMenu; i++) {
                            double harga = daftarMenu[i].getHarga();
                            totalHarga += harga;
                            if (harga > termahal.getHarga()) termahal = daftarMenu[i];
                            if (harga < termurah.getHarga()) termurah = daftarMenu[i];
                        }

                        System.out.println("--------------------------------------------------");
                        System.out.printf(" Total Menu Tersedia     : %d Item%n", jumlahMenu);
                        System.out.printf(" Total Omzet Potensial   : Rp%.2f%n", totalHarga);
                        System.out.printf(" Rata-rata Harga Menu    : Rp%.2f%n", (totalHarga / jumlahMenu));
                        System.out.println("--------------------------------------------------");
                        System.out.println(" [+] Menu Termahal : " + termahal.getNama() + " (Rp" + termahal.getHarga() + ")");
                        System.out.println(" [+] Menu Termurah : " + termurah.getNama() + " (Rp" + termurah.getHarga() + ")");
                        System.out.println("--------------------------------------------------");
                    }
                    System.out.print("\nTekan Enter untuk kembali...");
                    scanner.nextLine();
                }

                case 7 -> {
                    System.out.println("\n==================================================");
                    System.out.println(" TERIMA KASIH TELAH MENGGUNAKAN SMART RESTO SYSTEM");
                    System.out.println("==================================================");
                    isRunning = false;
                }

                default -> System.out.println("[-] Opsi menu tidak valid. Pilih angka 1-7.");
            }
        }
        scanner.close();
    }
}