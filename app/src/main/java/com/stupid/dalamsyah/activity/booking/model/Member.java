package com.stupid.dalamsyah.activity.booking.model;

public class Member {

    public String kode_tim;
    public String kode_lapangan;
    public String nama_lapangan;
    public String jam_main;
    public String status;

    public String getKode_tim() {
        return kode_tim;
    }

    public void setKode_tim(String kode_tim) {
        this.kode_tim = kode_tim;
    }

    public String getKode_lapangan() {
        return kode_lapangan;
    }

    public void setKode_lapangan(String kode_lapangan) {
        this.kode_lapangan = kode_lapangan;
    }

    public String getNama_lapangan() {
        return nama_lapangan;
    }

    public void setNama_lapangan(String nama_lapangan) {
        this.nama_lapangan = nama_lapangan;
    }

    public String getJam_main() {
        return jam_main;
    }

    public void setJam_main(String jam_main) {
        this.jam_main = jam_main;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
