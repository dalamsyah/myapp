package com.stupid.dalamsyah.lib.res;

import com.stupid.dalamsyah.activity.booking.model.Lapangan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/transaction")
    @FormUrlEncoded
    Call<Lapangan> savePost(@Field("tanggal") String tanggal,
                            @Field("lapanganId") String lapanganId,
                            @Field("jam") String jam,
                            @Field("userId") String userId,
                            @Field("teamId") String teamId);

}
