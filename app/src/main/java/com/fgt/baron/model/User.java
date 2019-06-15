package com.fgt.baron.model;

public class User {
    private String Id;
    private String username;
    private String jenis_kelamin;
    private String ttl, alamat, kontak, desk, foto, pendidikan, pengalaman_kerja;
    private String pekerjaan;
    private int umur;

    public User() {
    }

    public User(String id, String username, String jenis_kelamin, String ttl, String alamat, String kontak, String desk, String foto, String pendidikan, String pengalaman_kerja, String pekerjaan, int umur) {
        Id = id;
        this.username = username;
        this.jenis_kelamin = jenis_kelamin;
        this.ttl = ttl;
        this.alamat = alamat;
        this.kontak = kontak;
        this.desk = desk;
        this.foto = foto;
        this.pendidikan = pendidikan;
        this.pengalaman_kerja = pengalaman_kerja;
        this.pekerjaan = pekerjaan;
        this.umur = umur;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getPengalaman_kerja() {
        return pengalaman_kerja;
    }

    public void setPengalaman_kerja(String pengalaman_kerja) {
        this.pengalaman_kerja = pengalaman_kerja;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }
}
