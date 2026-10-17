package com.mycompany.smartresto;

import java.util.Scanner;

public class SmartResto {

    public static void cariMenu(String nama, MenuResto[] daftar, int jumlah) {
        System.out.println("\n--------------------------------------------------");
        System.out.println(" Hasil Pencarian Nama: '" + nama + "'");
        System.out.println("--------------------------------------------------");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNama().equalsIgnoreCase(nama)) {
                System.out.print(">> ");
                daftar[i].tampilkanInfo();
                simulasiProsesLayanan(daftar[i]);
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("[-] Menu tidak ditemukan.");
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
                simulasiProsesLayanan(daftar[i]);
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("[-] Menu dalam kategori tersebut tidak ditemukan.");
    }

    public static void cariMenu(double hargaMaksimal, MenuResto[] daftar, int jumlah) {
        System.out.println("\n--------------------------------------------------");
        System.out.printf(" Hasil Pencarian Menu <= Rp%.0f%n", hargaMaksimal);
        System.out.println("--------------------------------------------------");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getHarga() <= hargaMaksimal) {
                System.out.print(">> ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("[-] Tidak ada menu di bawah batas harga tersebut.");
    }

    public static void simulasiProsesLayanan(MenuResto item) {
        item.penyajian();

        if (item instanceof DapatDipesan) {
            DapatDipesan itemPesan = (DapatDipesan) item;
            itemPesan.prosesPesanan();
        }

        if (item instanceof DapatDinilai) {
            DapatDinilai itemRating = (DapatDinilai) item;
            itemRating.beriRating(5);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MenuResto[] daftarMenu = new MenuResto[20];
        int jumlahMenu = 0;
        boolean isRunning = true;

        daftarMenu[jumlahMenu++] = new Makanan("Nasi Goreng Spesial", "Utama", 25000, true);
        daftarMenu[jumlahMenu++] = new Makanan("Ayam Bakar Madu", "Utama", 30000, false);
        daftarMenu[jumlahMenu++] = new Minuman("Es Teh Manis", "Minuman", 5000, "Large");
        daftarMenu[jumlahMenu++] = new Minuman("Jus Alpukat", "Minuman", 15000, "Medium");
        daftarMenu[jumlahMenu++] = new Dessert("Blueberry Cheesecake", "Dessert", 28000, true);

        while (isRunning) {
            System.out.println("\n==================================================");
            System.out.println("       SMARTRESTO RESTAURANT MANAGEMENT SYSTEM    ");
            System.out.println("==================================================");
            System.out.println(" [1] Tambah Menu Baru");
            System.out.println(" [2] Daftar Seluruh Menu & Polimorfisme");
            System.out.println(" [3] Cari Menu (Overloading: Nama / Kategori / Max Harga)");
            System.out.println(" [4] Filter Kategori Menu (instanceof)");
            System.out.println(" [5] Pembaruan Harga Menu");
            System.out.println(" [6] Laporan & Penjualan Resto");
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

                        System.out.print("Masukkan Nama Menu      : ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Kategori Menu  : ");
                        String kategori = scanner.nextLine();
                        System.out.print("Masukkan Harga (Rp)     : ");
                        double harga = scanner.nextDouble();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Pedas (true/false)      : ");
                            boolean pedas = scanner.nextBoolean();
                            scanner.nextLine();
                            daftarMenu[jumlahMenu++] = new Makanan(nama, kategori, harga, pedas);
                        } else if (jenis == 2) {
                            System.out.print("Ukuran (Small/Medium/Large): ");
                            String ukuran = scanner.nextLine();
                            daftarMenu[jumlahMenu++] = new Minuman(nama, kategori, harga, ukuran);
                        } else if (jenis == 3) {
                            System.out.print("Manis Dingin (true/false): ");
                            boolean dingin = scanner.nextBoolean();
                            scanner.nextLine();
                            daftarMenu[jumlahMenu++] = new Dessert(nama, kategori, harga, dingin);
                        } else {
                            System.out.println("[-] Pilihan tidak valid!");
                            break;
                        }
                        System.out.println("[+] SUKSES: Menu baru berhasil ditambahkan.");
                    } else {
                        System.out.println("[-] Daftar menu penuh!");
                    }
                }

                case 2 -> {
                    System.out.println("\n>>> DAFTAR MENU RESTO & SIMULASI POLIMORFISME <<<");
                    for (int i = 0; i < jumlahMenu; i++) {
                        System.out.print((i + 1) + ". ");
                        daftarMenu[i].tampilkanInfo();
                        simulasiProsesLayanan(daftarMenu[i]);
                        System.out.println();
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println("* Total Item Menu Berhasil Dibuat: " + MenuResto.totalMenuBerhasilDibuat);
                    System.out.print("\nTekan Enter untuk kembali...");
                    scanner.nextLine();
                }

                case 3 -> {
                    System.out.println("\n>>> FITUR PENCARIAN MENU <<<");
                    System.out.println("1. Cari Berdasarkan Nama");
                    System.out.println("2. Cari Berdasarkan Kategori");
                    System.out.println("3. Cari Berdasarkan Batas Harga Maksimal");
                    System.out.print("Pilih Metode Cari (1-3): ");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan Nama Menu: ");
                        String namaCari = scanner.nextLine();
                        cariMenu(namaCari, daftarMenu, jumlahMenu);
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Kategori Menu: ");
                        String katCari = scanner.nextLine();
                        cariMenu(katCari, true, daftarMenu, jumlahMenu);
                    } else if (modeCari == 3) {
                        System.out.print("Masukkan Batas Harga Maksimal (Rp): ");
                        double maxHarga = scanner.nextDouble();
                        scanner.nextLine();
                        cariMenu(maxHarga, daftarMenu, jumlahMenu);
                    } else {
                        System.out.println("[-] Pilihan tidak valid.");
                    }
                    System.out.print("\nTekan Enter untuk kembali...");
                    scanner.nextLine();
                }

                case 4 -> {
                    System.out.println("\n>>> FILTER KATEGORI (INSTANCEOF) <<<");
                    System.out.println("1. Khusus Makanan");
                    System.out.println("2. Khusus Minuman");
                    System.out.println("3. Khusus Dessert");
                    System.out.print("Pilih Filter (1-3): ");
                    int filter = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\n--- Hasil Filter ---");
                    boolean ada = false;
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
                    if (!ada) System.out.println("[-] Menu dalam jenis ini tidak ditemukan.");
                    System.out.print("\nTekan Enter untuk kembali...");
                    scanner.nextLine();
                }

                case 5 -> {
                    System.out.println("\n>>> EDIT HARGA MENU <<<");
                    for (int i = 0; i < jumlahMenu; i++) {
                        System.out.printf("%d. %-18s - Rp%.0f%n", (i + 1), daftarMenu[i].getNama(), daftarMenu[i].getHarga());
                    }
                    System.out.print("Pilih nomor menu: ");
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
                    System.out.println("\n>>> LAPORAN RESTO <<<");
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
                        System.out.printf(" Total Menu Tersimpan    : %d Item%n", jumlahMenu);
                        System.out.printf(" Total Harga Seluruh Menu: Rp%.0f%n", totalHarga);
                        System.out.printf(" Rata-rata Harga Menu    : Rp%.0f%n", (totalHarga / jumlahMenu));
                        System.out.println("--------------------------------------------------");
                        System.out.printf(" [+] Menu Termahal : %s (Rp%.0f)%n", termahal.getNama(), termahal.getHarga());
                        System.out.printf(" [+] Menu Termurah : %s (Rp%.0f)%n", termurah.getNama(), termurah.getHarga());
                        System.out.println("--------------------------------------------------");
                    }
                    System.out.print("\nTekan Enter untuk kembali...");
                    scanner.nextLine();
                }

                case 7 -> {
                    System.out.println("\n==================================================");
                    System.out.println(" TERIMA KASIH TELAH MENGGUNAKAN SMARTRESTO SYSTEM");
                    System.out.println("==================================================");
                    isRunning = false;
                }

                default -> System.out.println("[-] Opsi menu tidak valid.");
            }
        }
        scanner.close();
    }
}