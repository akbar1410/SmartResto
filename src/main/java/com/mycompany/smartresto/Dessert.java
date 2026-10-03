package com.mycompany.smartresto;

public class Dessert extends MenuResto {
    private boolean isDingin;

    public Dessert(String nama, String kategori, double harga, boolean isDingin) {
        super(nama, kategori, harga);
        this.isDingin = isDingin;
    }

    public boolean isIsDingin() {
        return this.isDingin;
    }

    public void setIsDingin(boolean isDingin) {
        this.isDingin = isDingin;
    }

    @Override
    public void tampilkanInfo() {
        String statusDingin = this.isDingin ? "Sajian Dingin/Es" : "Suhu Ruangan/Warm";
        System.out.printf("[Dessert]  Nama: %-18s | Kategori: %-10s | Harga: Rp%-10.2f | Jenis: %s%n",
                getNama(), getKategori(), getHarga(), statusDingin);
    }

    @Override
    public void infoPenyajian() {
        System.out.println("-> Penyajian: Disajikan manis sebagai penutup hidangan.");
    }
}