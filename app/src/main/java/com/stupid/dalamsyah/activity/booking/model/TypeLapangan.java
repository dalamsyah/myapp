package com.stupid.dalamsyah.activity.booking.model;

public class TypeLapangan {

    public String nama;
    public String type;
    public int index;

    public TypeLapangan() {
    }

    public TypeLapangan(String nama, String type, int index) {
        this.nama = nama;
        this.type = type;
        this.index = index;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
