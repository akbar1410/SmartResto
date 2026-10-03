package com.mycompany.smartresto;

public class Minuman extends MenuResto {
    private String suhu;

    public Minuman(String nama, String kategori, double harga, String suhu) {
        super(nama, kategori, harga);
        this.suhu = suhu;
    }

    public String getSuhu() {
        return this.suhu;
    }

    public void setSuhu(String suhu) {
        this.suhu = suhu;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Minuman]  Nama: %-18s | Kategori: %-10s | Harga: Rp%-10.2f | Suhu: %s%n",
                getNama(), getKategori(), getHarga(), this.suhu);
    }

    @Override
    public void infoPenyajian() {
        System.out.println("-> Penyajian: Disajikan dalam gelas dingin/hangat dengan sedotan.");
    }
}