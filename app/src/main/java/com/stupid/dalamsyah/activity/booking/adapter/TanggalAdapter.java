package com.stupid.dalamsyah.activity.booking.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.activity.booking.model.Lapangan;
import com.stupid.dalamsyah.activity.booking.model.Tanggal;

import java.util.ArrayList;

public class TanggalAdapter extends RecyclerView.Adapter<TanggalAdapter.MyViewHolder> {

    ArrayList<Tanggal> list;
    public OnItemClickListener listener;

    public TanggalAdapter(ArrayList<Tanggal> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void OnClick(Tanggal tanggal);
    }

    @NonNull
    @Override
    public TanggalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_tanggal, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TanggalAdapter.MyViewHolder holder, int i) {
        Tanggal model = list.get(i);
        holder.bind(model, listener);

        holder.tgl.setText(model.getTgl());
        holder.hari.setText(model.getHari());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tgl;
        private TextView hari;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tgl = (TextView) itemView.findViewById(R.id.tgl);
            hari = (TextView) itemView.findViewById(R.id.hari);

        }

        public void bind(final Tanggal tanggal, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnClick(tanggal);
                }
            });
        }


    }
}