package com.mycompany.smartresto;

public class Makanan extends MenuResto implements DapatDipesan, DapatDinilai {
    private boolean pedas;

    public Makanan(String nama, String kategori, double harga, boolean pedas) {
        super(nama, kategori, harga);
        this.pedas = pedas;
    }

    public boolean isPedas() {
        return this.pedas;
    }

    public void setPedas(boolean pedas) {
        this.pedas = pedas;
    }

    @Override
    public void tampilkanInfo() {
        String level = isPedas() ? "Pedas" : "Tidak Pedas";
        System.out.printf("[Makanan]  Nama: %-18s | Kategori: %-10s | Harga: Rp%-10.0f | Rasa: %s%n",
                getNama(), getKategori(), getHarga(), level);
    }

    @Override
    public void penyajian() {
        System.out.println("   -> Cara Penyajian: Disajikan hangat dengan piring keramik.");
    }

    @Override
    public void prosesPesanan() {
        System.out.println("   -> [PROSES DAPUR] Makanan sedang dimasak oleh Chef.");
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println("   -> [RATING ULASAN] Makanan ini mendapat nilai " + bintang + "/5 Bintang dari pelanggan.");
    }
}
