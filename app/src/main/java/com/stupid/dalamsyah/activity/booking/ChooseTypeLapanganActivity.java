package com.stupid.dalamsyah.activity.booking;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.activity.booking.adapter.TypeLapanganAdapter;
import com.stupid.dalamsyah.activity.booking.model.TypeLapangan;

import java.util.ArrayList;

public class ChooseTypeLapanganActivity extends AppCompatActivity {

    private ArrayList<TypeLapangan> lists = new ArrayList<>();
    private TypeLapanganAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_type_lapangan);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        TypeLapangan typeLapangan = new TypeLapangan("Vinnyl", "", 1);
        lists.add(typeLapangan);

        typeLapangan = new TypeLapangan("Sintetis", "", 2);
        lists.add(typeLapangan);

        typeLapangan = new TypeLapangan("Vinnyl", "", 3);
        lists.add(typeLapangan);

        adapter = new TypeLapanganAdapter(lists, new TypeLapanganAdapter.OnItemClickListener() {
            @Override
            public void OnClick(TypeLapangan typeLapangan) {

                Intent i = new Intent();
                i.putExtra("namaLapangan", typeLapangan.getNama() +" - "+typeLapangan.getIndex());
                setResult(Activity.RESULT_OK, i);

                finish();

            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
