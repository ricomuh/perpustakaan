package com.ricomuh.perpustakaan;

public class Buku {
    private int id;
    private String judul;
    private String penulis;
    private int tahunTerbit;

    // Constructor tanpa parameter
    public Buku() {
    }

    // Constructor dengan parameter
    public Buku(int id, String judul, String penulis, int tahunTerbit) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }
}
