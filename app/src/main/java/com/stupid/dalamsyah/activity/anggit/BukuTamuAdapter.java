package com.stupid.dalamsyah.activity.anggit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stupid.dalamsyah.R;

import java.util.List;

public class BukuTamuAdapter extends RecyclerView.Adapter<BukuTamuAdapter.MyViewHolder> {

    private List<BukuTamuResults> list;
    public OnItemClickListener listener;

    public BukuTamuAdapter(List<BukuTamuResults> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void OnClick(BukuTamuResults bukuTamuResults);
    }


    @NonNull
    @Override
    public BukuTamuAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_bukutamu, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BukuTamuAdapter.MyViewHolder holder, int i) {
        BukuTamuResults bukuTamuResults = list.get(i);
        holder.bind(bukuTamuResults, listener);

        holder.nama.setText(bukuTamuResults.getName() +" - "+bukuTamuResults.getUsername());
        holder.last.setText(bukuTamuResults.getIp_last_login() + " - "+ bukuTamuResults.getTime_last_login());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nama;
        public TextView last;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = (TextView) itemView.findViewById(R.id.nama);
            last = (TextView) itemView.findViewById(R.id.ip_last_login);

        }

        public void bind(final BukuTamuResults buku, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnClick(buku);
                }
            });
        }

    }
}
