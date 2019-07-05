package com.stupid.dalamsyah.lib.res;

import com.stupid.dalamsyah.activity.anggit.BukuTamuResults;
import com.stupid.dalamsyah.activity.anggit.Quotes;
import com.stupid.dalamsyah.activity.anggit.ResultsInsert;
import com.stupid.dalamsyah.activity.anggit.ResultsTotal;
import com.stupid.dalamsyah.activity.anggit.Resutls;
import com.stupid.dalamsyah.activity.anggit.User;
import com.stupid.dalamsyah.activity.booking.model.Lapangan;
import com.stupid.dalamsyah.activity.booking.model.Results;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    @POST("/transaction")
    @FormUrlEncoded
    Call<Lapangan> savePost(@Field("tanggal") String tanggal,
                            @Field("lapanganId") String lapanganId,
                            @Field("jam") String jam,
                            @Field("userId") String userId,
                            @Field("teamId") String teamId);

    @POST("/transaksi")
    @FormUrlEncoded
    Call<Results> insert(@Field("tanggal") String tanggal, @Field("username") String username,
                         @Field("kode_tim") String kode_tim,
                         @Field("kode_lapangan") String kode_lapangan, @Field("nama_lapangan") String nama_lapangan,
                         @Field("harga_lapangan") String harga_lapangan,
                         @Field("total_harga") String total_harga,
                         @Field("status") String status,
                         @Field("jam_main") String jam_main);

    @GET("/member")
    Call<Results> getMember(@Path("hari") String hari);

    @POST("/login")
    @FormUrlEncoded
    Call<Resutls> loginAnggit(@Field("username") String username, @Field("password") String password);

    @GET("/quotes")
    Call<ArrayList<Quotes> > quotesAnggit2();

    @POST("/quotes")
    @FormUrlEncoded
    Call<ResultsInsert> insertQuotes(@Field("author") String name,
                                       @Field("quotes") String username,
                                       @Field("owner") String owner);

    @PUT("/quotes/{id}")
    @FormUrlEncoded
    Call<ResultsInsert> updateQuotes(@Path("id") String id,
                                     @Field("author") String name,
                                     @Field("quotes") String username,
                                     @Field("owner") String owner);

    @GET("/bukutamu/total")
    Call<ResultsTotal> bukutamu_total();

    @GET("/bukutamu")
    Call<ArrayList<BukuTamuResults> > bukutamuAnggit();

    @POST("/bukutamu")
    @FormUrlEncoded
    Call<ResultsInsert> insertBukuTamu(@Field("nama") String name,
                                       @Field("username") String username,
                                       @Field("ket") String ket,
                                       @Field("owner") String owner);

    @PUT("/bukutamu/{id}")
    @FormUrlEncoded
    Call<BukuTamuResults> updateBukuTamu(@Path("id") String id,
                                       @Field("nama") String name,
                                       @Field("username") String username,
                                       @Field("ket") String ket,
                                       @Field("owner") String owner);

}
