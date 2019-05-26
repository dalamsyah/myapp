package com.stupid.dalamsyah.activity.booking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction {

    @SerializedName("tanggal")
    @Expose
    private String tanggal;

    @SerializedName("lapanganId")
    @Expose
    private String lapanganId;

    @SerializedName("jam")
    @Expose
    private String jam;

    @SerializedName("userId")
    @Expose
    private String userId;

    @SerializedName("teamId")
    @Expose
    private String teamId;

    public Transaction() {
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLapanganId() {
        return lapanganId;
    }

    public void setLapanganId(String lapanganId) {
        this.lapanganId = lapanganId;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
