package com.stupid.dalamsyah.activity.booking.model;

public class Lapangan {
    public String namaLapangan;
    public String alamatLapangan;


    public Lapangan() {
    }

    public Lapangan(String namaLapangan, String alamatLapangan) {
        this.namaLapangan = namaLapangan;
        this.alamatLapangan = alamatLapangan;
    }

    public String getNamaLapangan() {
        return namaLapangan;
    }

    public void setNamaLapangan(String namaLapangan) {
        this.namaLapangan = namaLapangan;
    }

    public String getAlamatLapangan() {
        return alamatLapangan;
    }

    public void setAlamatLapangan(String alamatLapangan) {
        this.alamatLapangan = alamatLapangan;
    }
}
