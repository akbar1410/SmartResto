package com.mycompany.smartresto;

public class Makanan extends MenuResto {
    private String tingkatPedas;

    public Makanan(String nama, String kategori, double harga, String tingkatPedas) {
        super(nama, kategori, harga);
        this.tingkatPedas = tingkatPedas;
    }

    public String getTingkatPedas() {
        return this.tingkatPedas;
    }

    public void setTingkatPedas(String tingkatPedas) {
        this.tingkatPedas = tingkatPedas;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Makanan]  Nama: %-18s | Kategori: %-10s | Harga: Rp%-10.2f | Level Pedas: %s%n",
                getNama(), getKategori(), getHarga(), this.tingkatPedas);
    }

    @Override
    public void infoPenyajian() {
        System.out.println("-> Penyajian: Disajikan piring hangat bersama sajian pelengkap.");
    }
}