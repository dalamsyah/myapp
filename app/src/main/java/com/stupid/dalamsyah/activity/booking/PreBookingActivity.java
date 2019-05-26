package com.stupid.dalamsyah.activity.booking;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.activity.booking.adapter.TanggalAdapter;
import com.stupid.dalamsyah.activity.booking.model.Tanggal;

import java.util.ArrayList;

public class PreBookingActivity extends AppCompatActivity {

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

    private ArrayList<Tanggal> lists = new ArrayList<>();
    private TanggalAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_booking);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

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
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);


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
                if (pressJam8) pressJam8 = false;
                else pressJam8 = true;

                break;
            case R.id.jam9:

                pressColor(v, pressJam9);
                if (pressJam9) pressJam9 = false;
                else pressJam9 = true;

                break;
            case R.id.jam10:

                pressColor(v, pressJam10);
                if (pressJam10) pressJam10 = false;
                else pressJam10 = true;

                break;
            case R.id.jam11:

                pressColor(v, pressJam11);
                if (pressJam11) pressJam11 = false;
                else pressJam11 = true;

                break;
            case R.id.jam12:

                pressColor(v, pressJam12);
                if (pressJam12) pressJam12 = false;
                else pressJam12 = true;

                break;
            case R.id.jam13:

                pressColor(v, pressJam13);
                if (pressJam13) pressJam13 = false;
                else pressJam13 = true;

                break;
            case R.id.jam14:

                pressColor(v, pressJam14);
                if (pressJam14) pressJam14 = false;
                else pressJam14 = true;

                break;
            case R.id.jam15:

                pressColor(v, pressJam15);
                if (pressJam15) pressJam15 = false;
                else pressJam15 = true;

                break;
            case R.id.jam16:

                pressColor(v, pressJam16);
                if (pressJam16) pressJam16 = false;
                else pressJam16 = true;

                break;
            case R.id.jam17:

                pressColor(v, pressJam17);
                if (pressJam17) pressJam17 = false;
                else pressJam17 = true;

                break;
            case R.id.jam18:

                pressColor(v, pressJam18);
                if (pressJam18) pressJam18 = false;
                else pressJam18 = true;

                break;
            case R.id.jam19:

                pressColor(v, pressJam19);
                if (pressJam19) pressJam19 = false;
                else pressJam19 = true;

                break;
            case R.id.jam20:

                pressColor(v, pressJam20);
                if (pressJam20) pressJam20 = false;
                else pressJam20 = true;

                break;
            case R.id.jam21:

                pressColor(v, pressJam21);
                if (pressJam21) pressJam21 = false;
                else pressJam21 = true;

                break;
            case R.id.jam22:

                pressColor(v, pressJam22);
                if (pressJam22) pressJam22 = false;
                else pressJam22 = true;

                break;
            case R.id.jam23:

                pressColor(v, pressJam23);
                if (pressJam23) pressJam23 = false;
                else pressJam23 = true;

                break;
        }

    }

}
