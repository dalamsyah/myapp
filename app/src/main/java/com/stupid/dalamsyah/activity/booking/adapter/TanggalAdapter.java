package com.stupid.dalamsyah.activity.booking.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
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
    private Context context;
    private int row_index = -1;

    public TanggalAdapter(ArrayList<Tanggal> list, OnItemClickListener listener, Context context) {
        this.list = list;
        this.listener = listener;
        this.context = context;
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
    public void onBindViewHolder(@NonNull TanggalAdapter.MyViewHolder holder, final int i) {
        Tanggal model = list.get(i);
        holder.bind(model, listener);

        holder.tgl.setText(model.getTgl());
        holder.hari.setText(model.getHari());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = i;
                notifyDataSetChanged();
            }
        });

        if(row_index == i){
            holder.cardView.setBackgroundColor(context.getResources().getColor(R.color.orange));
            holder.hari.setTextColor(Color.WHITE);
            holder.tgl.setTextColor(Color.WHITE);
        }else {
            holder.cardView.setBackgroundColor(Color.WHITE);
            holder.hari.setTextColor(context.getResources().getColor(R.color.colorText));
            holder.tgl.setTextColor(context.getResources().getColor(R.color.colorText));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tgl;
        private TextView hari;
        private CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            hari = (TextView) itemView.findViewById(R.id.hari);
            tgl = (TextView) itemView.findViewById(R.id.tgl);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

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