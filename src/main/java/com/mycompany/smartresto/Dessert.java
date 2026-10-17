package com.mycompany.smartresto;

public class Dessert extends MenuResto implements DapatDinilai {
    private boolean manisDingin;

    public Dessert(String nama, String kategori, double harga, boolean manisDingin) {
        super(nama, kategori, harga);
        this.manisDingin = manisDingin;
    }

    public boolean isManisDingin() {
        return this.manisDingin;
    }

    public void setManisDingin(boolean manisDingin) {
        this.manisDingin = manisDingin;
    }

    @Override
    public void tampilkanInfo() {
        String jenis = isManisDingin() ? "Es/Suhu Dingin" : "Suhu Ruang";
        System.out.printf("[Dessert]  Nama: %-18s | Kategori: %-10s | Harga: Rp%-10.0f | Tipe: %s%n",
                getNama(), getKategori(), getHarga(), jenis);
    }

    @Override
    public void penyajian() {
        System.out.println("   -> Cara Penyajian: Disajikan cantik pada piring kue.");
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println("   -> [RATING ULASAN] Dessert ini mendapat ulasan " + bintang + "/5 Bintang dari pelanggan.");
    }
}