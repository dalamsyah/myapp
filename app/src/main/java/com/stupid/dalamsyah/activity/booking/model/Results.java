package com.stupid.dalamsyah.activity.booking.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Results {

    @SerializedName("message")
    public String message;

    @SerializedName("total")
    public String total;

    @SerializedName("result")
    public List<Member> rs_member;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Member> getRs_member() {
        return rs_member;
    }

    public void setRs_member(List<Member> rs_member) {
        this.rs_member = rs_member;
    }
}
