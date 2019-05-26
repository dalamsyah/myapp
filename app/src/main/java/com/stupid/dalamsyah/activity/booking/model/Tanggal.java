package com.stupid.dalamsyah.activity.booking.model;

public class Tanggal {
    public String hari = "";
    public String tgl = "";
    public String waktu = "";
    public boolean press = false;

    public Tanggal() {
    }

    public Tanggal(String hari, String tgl, String waktu) {
        this.hari = hari;
        this.tgl = tgl;
        this.waktu = waktu;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        this.press = press;
    }
}
