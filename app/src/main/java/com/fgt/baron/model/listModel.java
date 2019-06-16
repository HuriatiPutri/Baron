package com.fgt.baron.model;

public class listModel {
    private int img;
    private String idUser, nama, kategori, durasi, harga;

    public listModel() {
    }

    public listModel(String idUser, String nama, String kategori, String durasi, String harga) {
//        this.img = img;
        this.idUser = idUser;
        this.nama = nama;
        this.kategori = kategori;
        this.durasi = durasi;
        this.harga = harga;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
