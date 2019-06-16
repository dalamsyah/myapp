package com.stupid.dalamsyah.activity.anggit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stupid.dalamsyah.R;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.MyViewHolder> {

    private List<Quotes> list;
    public OnItemClickListener listener;

    public QuotesAdapter(List<Quotes> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void OnClick(Quotes quotes);
    }

    @NonNull
    @Override
    public QuotesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_quote, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesAdapter.MyViewHolder holder, int i) {
        Quotes quotes = list.get(i);
        holder.bind(quotes, listener);

        holder.quote.setText(quotes.getQuote());
        holder.author.setText(quotes.getAuthor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView quote;
        public TextView author;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            quote = (TextView) itemView.findViewById(R.id.quotes);
            author = (TextView) itemView.findViewById(R.id.author);
        }

        public void bind(final Quotes quotes, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnClick(quotes);
                }
            });
        }

    }

    public void refresh(){
        list.clear();
        notifyDataSetChanged();
    }

}
