package com.mycompany.smartresto;

public class Minuman extends MenuResto implements DapatDipesan {
    private String ukuran;

    public Minuman(String nama, String kategori, double harga, String ukuran) {
        super(nama, kategori, harga);
        this.ukuran = ukuran;
    }

    public String getUkuran() {
        return this.ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Minuman]  Nama: %-18s | Kategori: %-10s | Harga: Rp%-10.0f | Ukuran: %s%n",
                getNama(), getKategori(), getHarga(), this.ukuran);
    }

    @Override
    public void penyajian() {
        System.out.println("   -> Cara Penyajian: Disajikan dingin dengan es batu di gelas tinggi.");
    }

    @Override
    public void prosesPesanan() {
        System.out.println("   -> [PROSES BAR] Minuman sedang diracik dan disiapkan.");
    }
}