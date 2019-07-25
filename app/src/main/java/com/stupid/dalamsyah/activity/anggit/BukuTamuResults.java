package com.stupid.dalamsyah.activity.anggit;

import com.google.gson.annotations.SerializedName;

public class BukuTamuResults {

    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    @SerializedName("username")
    String username;

    @SerializedName("ip_last_login")
    String ip_last_login;

    @SerializedName("time_last_login")
    String time_last_login;

    @SerializedName("remark")
    String remark;

    @SerializedName("owner")
    String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp_last_login() {
        return ip_last_login;
    }

    public void setIp_last_login(String ip_last_login) {
        this.ip_last_login = ip_last_login;
    }

    public String getTime_last_login() {
        return time_last_login;
    }

    public void setTime_last_login(String time_last_login) {
        this.time_last_login = time_last_login;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
