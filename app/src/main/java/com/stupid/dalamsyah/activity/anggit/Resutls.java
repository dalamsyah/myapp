package com.stupid.dalamsyah.activity.anggit;

import com.google.gson.annotations.SerializedName;

public class Resutls {

    @SerializedName("code")
    String code;

    @SerializedName("status")
    String status;

    @SerializedName("status_user")
    String status_user;

    public Resutls() {
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

    public String getStatus_user() {
        return status_user;
    }

    public void setStatus_user(String status_user) {
        this.status_user = status_user;
    }
}
