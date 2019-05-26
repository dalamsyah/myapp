package com.stupid.dalamsyah.activity.booking.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.activity.booking.PreBookingActivity;
import com.stupid.dalamsyah.activity.booking.adapter.LapanganAdapter;
import com.stupid.dalamsyah.activity.booking.model.Lapangan;

import java.util.ArrayList;
import java.util.List;

public class BookingFragment extends Fragment {

    private LapanganAdapter adapter;
    private List<Lapangan> lists = new ArrayList<>();
    private RecyclerView recyclerView;

    public BookingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_booking, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);

        Lapangan l = new Lapangan("Sisilia","Jln. raya setu");
        lists.add(l);

        l = new Lapangan("Java","Jln. raya setu");
        lists.add(l);

        adapter = new LapanganAdapter(lists, new LapanganAdapter.OnItemClickListener() {
            @Override
            public void OnClick(Lapangan lapangan) {
                Intent i = new Intent(getActivity(), PreBookingActivity.class);
                startActivity(i);
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return v;
    }

}
