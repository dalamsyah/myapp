package com.stupid.dalamsyah.activity.booking;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.activity.booking.adapter.TanggalAdapter;
import com.stupid.dalamsyah.activity.booking.dialog.ProgressDialog;
import com.stupid.dalamsyah.activity.booking.model.Lapangan;
import com.stupid.dalamsyah.activity.booking.model.Member;
import com.stupid.dalamsyah.activity.booking.model.Results;
import com.stupid.dalamsyah.activity.booking.model.Tanggal;
import com.stupid.dalamsyah.lib.res.ApiService;
import com.stupid.dalamsyah.lib.res.ApiUtils;
import com.stupid.dalamsyah.lib.res.RetrofitClient;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreBookingActivity extends ActivityBase {

    private boolean pressJam8 = true;
    private boolean pressJam9 = true;
    private boolean pressJam10 = true;
    private boolean pressJam11 = true;
    private boolean pressJam12 = true;
    private boolean pressJam13 = true;
    private boolean pressJam14 = true;
    private boolean pressJam15 = true;
    private boolean pressJam16 = true;
    private boolean pressJam17 = true;
    private boolean pressJam18 = true;
    private boolean pressJam19 = true;
    private boolean pressJam20 = true;
    private boolean pressJam21 = true;
    private boolean pressJam22 = true;
    private boolean pressJam23 = true;

    private CardView jam8;
    private CardView jam9;
    private CardView jam10;
    private CardView jam11;
    private CardView jam12;
    private CardView jam13;
    private CardView jam14;
    private CardView jam15;
    private CardView jam16;
    private CardView jam17;
    private CardView jam18;
    private CardView jam19;
    private CardView jam20;
    private CardView jam21;
    private CardView jam22;
    private CardView jam23;

    private TextView t_jam8;
    private TextView t_jam9;
    private TextView t_jam10;
    private TextView t_jam11;
    private TextView t_jam12;
    private TextView t_jam13;
    private TextView t_jam14;
    private TextView t_jam15;
    private TextView t_jam16;
    private TextView t_jam17;
    private TextView t_jam18;
    private TextView t_jam19;
    private TextView t_jam20;
    private TextView t_jam21;
    private TextView t_jam22;
    private TextView t_jam23;

    private ArrayList<Tanggal> lists = new ArrayList<>();
    private TanggalAdapter adapter;
    private RecyclerView recyclerView;
    private boolean press = false;
    private Button namaLapangan;
    private DialogFragment progress;
    private ApiService apiService;

    private String tanggal = "";
    private ArrayList<String> jam = new ArrayList<>();

    private static final String TAG = "PreBookingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_booking);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        namaLapangan = (Button) findViewById(R.id.namaLapangan);
        progress = new ProgressDialog();

        jam8 = (CardView) findViewById(R.id.jam8);
        jam9 = (CardView) findViewById(R.id.jam9);
        jam10 = (CardView) findViewById(R.id.jam10);
        jam11 = (CardView) findViewById(R.id.jam11);
        jam12 = (CardView) findViewById(R.id.jam12);
        jam13 = (CardView) findViewById(R.id.jam13);
        jam14 = (CardView) findViewById(R.id.jam14);
        jam15 = (CardView) findViewById(R.id.jam15);
        jam16 = (CardView) findViewById(R.id.jam16);
        jam17 = (CardView) findViewById(R.id.jam17);
        jam18 = (CardView) findViewById(R.id.jam18);
        jam19 = (CardView) findViewById(R.id.jam19);
        jam20 = (CardView) findViewById(R.id.jam20);
        jam21 = (CardView) findViewById(R.id.jam21);
        jam22 = (CardView) findViewById(R.id.jam22);
        jam23 = (CardView) findViewById(R.id.jam23);

        t_jam8 = (TextView) findViewById(R.id.t_jam8);
        t_jam9 = (TextView) findViewById(R.id.t_jam9);
        t_jam10 = (TextView) findViewById(R.id.t_jam10);
        t_jam11 = (TextView) findViewById(R.id.t_jam11);
        t_jam12 = (TextView) findViewById(R.id.t_jam12);
        t_jam13 = (TextView) findViewById(R.id.t_jam13);
        t_jam14 = (TextView) findViewById(R.id.t_jam14);
        t_jam15 = (TextView) findViewById(R.id.t_jam15);
        t_jam16 = (TextView) findViewById(R.id.t_jam16);
        t_jam17 = (TextView) findViewById(R.id.t_jam17);
        t_jam18 = (TextView) findViewById(R.id.t_jam18);
        t_jam19 = (TextView) findViewById(R.id.t_jam19);
        t_jam20 = (TextView) findViewById(R.id.t_jam20);
        t_jam21 = (TextView) findViewById(R.id.t_jam21);
        t_jam22 = (TextView) findViewById(R.id.t_jam22);
        t_jam23 = (TextView) findViewById(R.id.t_jam23);

        apiService = RetrofitClient.getClient("https://api.studystupid.com").create(ApiService.class);
        //apiService = RetrofitClient.getClient("http://192.168.137.43").create(ApiService.class);

        Tanggal tanggal = new Tanggal("Senin", "20 Mei","");
        lists.add(tanggal);

        tanggal = new Tanggal("Selasa", "20 Mei","");
        lists.add(tanggal);

        tanggal = new Tanggal("Rabu", "20 Mei","");
        lists.add(tanggal);

        tanggal = new Tanggal("Kamis", "20 Mei","");
        lists.add(tanggal);

        tanggal = new Tanggal("Jumat", "20 Mei","");
        lists.add(tanggal);

        tanggal = new Tanggal("Sabtu", "20 Mei","");
        lists.add(tanggal);

        tanggal = new Tanggal("Minggu", "20 Mei","");
        lists.add(tanggal);

        adapter = new TanggalAdapter(lists, new TanggalAdapter.OnItemClickListener() {
            @Override
            public void OnClick(Tanggal tanggal) {

            }
        }, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        namaLapangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PreBookingActivity.this, ChooseTypeLapanganActivity.class);
                startActivityForResult(i, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            namaLapangan.setText(data.getStringExtra("namaLapangan"));
        }

    }

    public void btnSend(View view){

        String r = jam.toString();
        String s = r.replace("[", "");
        String j = s.replace("]", "");

        progress.show(getSupportFragmentManager(), "progress");

        Call<Results> resultsCall = apiService.insert("11-05-2019", "dimas@gmail.com", "0708",
                "L001", "SISILIA",
                "120000","240000", "wait", j);

        resultsCall.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Log.d("LoginActivity", response.body().getMessage());

                progress.dismiss();
                Toast.makeText(PreBookingActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Log.d("LoginActivity", t.toString());
                progress.dismiss();
                t.printStackTrace();
            }
        });

    }

    public void getMember(String hari){

        progress.show(getSupportFragmentManager(), "progress");

        Call<Results> resultsCall = apiService.getMember(hari);
        resultsCall.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Log.d(TAG, response.body().getMessage());
                progress.dismiss();

                int count = Integer.valueOf(response.body().getTotal());

                for(int i = 0; i < count; i++){
                    String jam_main = response.body().getRs_member().get(i).jam_main;

                    if(jam_main.equals("08:00-09:00")){
                        jam8.setCardBackgroundColor(Color.GRAY);
                        t_jam8.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("09:00-10:00")){
                        jam9.setCardBackgroundColor(Color.GRAY);
                        t_jam9.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("10:00-11:00")){
                        jam10.setCardBackgroundColor(Color.GRAY);
                        t_jam10.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("11:00-12:00")){
                        jam11.setCardBackgroundColor(Color.GRAY);
                        t_jam11.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("12:00-13:00")){
                        jam12.setCardBackgroundColor(Color.GRAY);
                        t_jam12.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("13:00-14:00")){
                        jam13.setCardBackgroundColor(Color.GRAY);
                        t_jam13.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("14:00-15:00")){
                        jam14.setCardBackgroundColor(Color.GRAY);
                        t_jam14.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("15:00-16:00")){
                        jam15.setCardBackgroundColor(Color.GRAY);
                        t_jam15.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("16:00-17:00")){
                        jam16.setCardBackgroundColor(Color.GRAY);
                        t_jam16.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("17:00-18:00")){
                        jam17.setCardBackgroundColor(Color.GRAY);
                        t_jam17.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("18:00-19:00")){
                        jam18.setCardBackgroundColor(Color.GRAY);
                        t_jam18.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("19:00-20:00")){
                        jam19.setCardBackgroundColor(Color.GRAY);
                        t_jam19.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("21:00-22:00")){
                        jam21.setCardBackgroundColor(Color.GRAY);
                        t_jam21.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("22:00-23:00")){
                        jam22.setCardBackgroundColor(Color.GRAY);
                        t_jam22.setTextColor(Color.WHITE);
                    }

                    if(jam_main.equals("23:00-24:00")){
                        jam23.setCardBackgroundColor(Color.GRAY);
                        t_jam23.setTextColor(Color.WHITE);
                    }

                }

            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                t.printStackTrace();
                Log.d(TAG, t.toString());
                progress.dismiss();
            }
        });

    }

    private void pressColor(View v, boolean s){

        if(!s){

            v.setBackgroundColor(Color.WHITE);
            TextView tv = (TextView)((CardView )v).getChildAt(0);
            tv.setTextColor(getResources().getColor(R.color.colorText));

        }else{

            v.setBackgroundColor(getResources().getColor(R.color.orange));
            TextView tv = (TextView)((CardView )v).getChildAt(0);
            tv.setTextColor(Color.WHITE);
        }

    }

    public void pressJam(View v){

        switch (v.getId()){
            case R.id.jam8:

                pressColor(v, pressJam8);
                if (pressJam8) {
                    jam.add("08:00 - 09:00");
                    pressJam8 = false;
                }else {
                    jam.remove("08:00 - 09:00");
                    pressJam8 = true;
                }

                break;
            case R.id.jam9:

                pressColor(v, pressJam9);
                if (pressJam9){
                    jam.add("09:00 - 10:00");
                    pressJam9 = false;
                }
                else{
                    jam.remove("09:00 - 10:00");
                    pressJam9 = true;
                }

                break;
            case R.id.jam10:

                pressColor(v, pressJam10);
                if (pressJam10){
                    jam.add("10:00 - 11:00");
                    pressJam10 = false;
                }
                else{
                    jam.remove("10:00 - 11:00");
                    pressJam10 = true;
                }

                break;
            case R.id.jam11:

                pressColor(v, pressJam11);
                if (pressJam11){
                    jam.add("11:00 - 12:00");
                    pressJam11 = false;
                }
                else{
                    jam.remove("11:00 - 12:00");
                    pressJam11 = true;
                }

                break;
            case R.id.jam12:

                pressColor(v, pressJam12);
                if (pressJam12){
                    jam.add("12:00 - 13:00");
                    pressJam12 = false;
                }
                else{
                    jam.remove("12:00 - 13:00");
                    pressJam12 = true;
                }

                break;
            case R.id.jam13:

                pressColor(v, pressJam13);
                if (pressJam13){
                    jam.add("13:00 - 14:00");
                    pressJam13 = false;
                }
                else{
                    jam.remove("13:00 - 14:00");
                    pressJam13 = true;
                }

                break;
            case R.id.jam14:

                pressColor(v, pressJam14);
                if (pressJam14){
                    jam.add("14:00 - 15:00");
                    pressJam14 = false;
                }
                else{
                    jam.remove("14:00 - 15:00");
                    pressJam14 = true;
                }

                break;
            case R.id.jam15:

                pressColor(v, pressJam15);
                if (pressJam15){
                    jam.add("15:00 - 16:00");
                    pressJam15 = false;
                }
                else{
                    jam.remove("15:00 - 16:00");
                    pressJam15 = true;
                }

                break;
            case R.id.jam16:

                pressColor(v, pressJam16);
                if (pressJam16){
                    jam.add("16:00 - 17:00");
                    pressJam16 = false;
                }
                else{
                    jam.remove("16:00 - 17:00");
                    pressJam16 = true;
                }

                break;
            case R.id.jam17:

                pressColor(v, pressJam17);
                if (pressJam17){
                    jam.add("17:00 - 18:00");
                    pressJam17 = false;
                }
                else{
                    jam.remove("17:00 - 18:00");
                    pressJam17 = true;
                }

                break;
            case R.id.jam18:

                pressColor(v, pressJam18);
                if (pressJam18){
                    jam.add("18:00 - 19:00");
                    pressJam18 = false;
                }
                else{
                    jam.remove("18:00 - 19:00");
                    pressJam18 = true;
                }

                break;
            case R.id.jam19:

                pressColor(v, pressJam19);
                if (pressJam19){
                    jam.add("19:00 - 20:00");
                    pressJam19 = false;
                }
                else {
                    jam.remove("19:00 - 20:00");
                    pressJam19 = true;
                }

                break;
            case R.id.jam20:

                pressColor(v, pressJam20);
                if (pressJam20){
                    jam.add("20:00 - 21:00");
                    pressJam20 = false;
                }
                else{
                    jam.remove("20:00 - 21:00");
                    pressJam20 = true;
                }

                break;
            case R.id.jam21:

                pressColor(v, pressJam21);
                if (pressJam21){
                    jam.add("21:00 - 22:00");
                    pressJam21 = false;
                }
                else{
                    jam.remove("21:00 - 22:00");
                    pressJam21 = true;
                }

                break;
            case R.id.jam22:

                pressColor(v, pressJam22);
                if (pressJam22){
                    jam.add("22:00 - 23:00");
                    pressJam22 = false;
                }
                else{
                    jam.remove("22:00 - 23:00");
                    pressJam22 = true;
                }

                break;
            case R.id.jam23:

                pressColor(v, pressJam23);
                if (pressJam23){
                    jam.add("23:00 - 24:00");
                    pressJam23 = false;
                }
                else{
                    jam.remove("23:00 - 24:00");
                    pressJam23 = true;
                }

                break;

        }

    }

}
