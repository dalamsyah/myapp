package com.stupid.dalamsyah.activity.anggit;

import com.google.gson.annotations.SerializedName;

public class ResultsInsert {

    @SerializedName("code")
    String code;

    @SerializedName("status")
    String status;

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
