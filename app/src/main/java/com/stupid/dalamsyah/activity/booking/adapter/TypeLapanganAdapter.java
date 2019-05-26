package com.stupid.dalamsyah.activity.booking.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.activity.booking.model.TypeLapangan;

import java.util.ArrayList;

public class TypeLapanganAdapter extends RecyclerView.Adapter<TypeLapanganAdapter.MyViewHolder> {

    private ArrayList<TypeLapangan> list;
    public OnItemClickListener listener;

    public TypeLapanganAdapter(ArrayList<TypeLapangan> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void OnClick(TypeLapangan typeLapangan);
    }

    @NonNull
    @Override
    public TypeLapanganAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_type_lapangan, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeLapanganAdapter.MyViewHolder holder, int i) {

        TypeLapangan typeLapangan = list.get(i);
        holder.bind(typeLapangan, listener);

        holder.typeLapangan.setText(typeLapangan.getNama()+" - "+typeLapangan.getIndex());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView typeLapangan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.gambar);
            typeLapangan = (TextView) itemView.findViewById(R.id.typeLapangan);

        }

        public void bind(final TypeLapangan model, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnClick(model);
                }
            });
        }

    }
}
