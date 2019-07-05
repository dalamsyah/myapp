package com.stupid.dalamsyah.activity.anggit;

import com.google.gson.annotations.SerializedName;

public class ResultsTotal {

    @SerializedName("code")
    String code;

    @SerializedName("status")
    String status;

    @SerializedName("cowok")
    String cowok;

    @SerializedName("cewek")
    String cewek;

    public String getCowok() {
        return cowok;
    }

    public void setCowok(String cowok) {
        this.cowok = cowok;
    }

    public String getCewek() {
        return cewek;
    }

    public void setCewek(String cewek) {
        this.cewek = cewek;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
