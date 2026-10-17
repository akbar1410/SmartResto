package com.mycompany.smartresto;

public abstract class MenuResto {
    private String nama;
    private String kategori;
    private double harga;

    public static int totalMenuBerhasilDibuat = 0;

    public MenuResto(String nama, String kategori, double harga) {
        this.nama = nama;
        this.kategori = kategori;
        setHarga(harga);
        totalMenuBerhasilDibuat++;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return this.kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public double getHarga() {
        return this.harga;
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga tidak valid!");
            this.harga = 5000;
        }
    }

    public void tampilkanInfo() {
        System.out.printf("Nama: %-20s | Kategori: %-10s | Harga: Rp%.0f", this.nama, this.kategori, this.harga);
    }

    public abstract void penyajian();
}
