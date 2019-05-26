package com.stupid.dalamsyah.activity.booking.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.activity.booking.model.Lapangan;

import java.util.List;

public class LapanganAdapter extends RecyclerView.Adapter<LapanganAdapter.MyViewHolder> {

    private List<Lapangan> list;
    public OnItemClickListener listener;

    public LapanganAdapter(List<Lapangan> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void OnClick(Lapangan lapangan);
    }

    @NonNull
    @Override
    public LapanganAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_lapangan, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LapanganAdapter.MyViewHolder holder, int i) {
        Lapangan lapangan = list.get(i);
        holder.bind(lapangan, listener);

        holder.namaLapangan.setText(lapangan.getNamaLapangan());
        holder.alamatLapangan.setText(lapangan.getAlamatLapangan());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView namaLapangan;
        public TextView alamatLapangan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namaLapangan = (TextView) itemView.findViewById(R.id.namaLapangan);
            alamatLapangan = (TextView) itemView.findViewById(R.id.alamatLapangan);

        }

        public void bind(final Lapangan lapangan, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnClick(lapangan);
                }
            });
        }
    }
}
