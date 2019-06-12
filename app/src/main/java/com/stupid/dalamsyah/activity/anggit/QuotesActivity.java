package com.stupid.dalamsyah.activity.anggit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.activity.booking.dialog.ProgressDialog;
import com.stupid.dalamsyah.activity.booking.model.Lapangan;
import com.stupid.dalamsyah.lib.res.ApiService;
import com.stupid.dalamsyah.lib.res.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuotesActivity extends AppCompatActivity {

    private ApiService apiService;
    private QuotesAdapter adapter;
    private List<Quotes> lists = new ArrayList<>();
    Quotes quotes;
    RecyclerView recyclerView;
    private DialogFragment progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        apiService = RetrofitClient.getClient("https://api.farra-anggit.info").create(ApiService.class);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        progress = new ProgressDialog();

        adapter = new QuotesAdapter(lists, new QuotesAdapter.OnItemClickListener() {
            @Override
            public void OnClick(final Quotes quotes) {

                final String[] options = {"Show", "Edit", "Delete"};

                AlertDialog.Builder builder = new AlertDialog.Builder(QuotesActivity.this);
                builder.setTitle("Pick a color");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if("Show".equals(options[which])){

                        }else if ("Edit".equals(options[which])){

                            Intent i = new Intent(QuotesActivity.this, QuotesAddActivity.class);
                            i.putExtra("id", quotes.getId());
                            i.putExtra("author", quotes.getAuthor());
                            i.putExtra("quotes", quotes.getQuote());
                            startActivity(i);

                        }else if ("Delete".equals(options[which])){

                        }
                    }
                });
                builder.show();
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        load();
    }

    public void add(View view){
        Intent i = new Intent(this, QuotesAddActivity.class);
        startActivity(i);
    }

    public void load(){

        progress.show(getSupportFragmentManager(), "progress");

        Call<ArrayList<Quotes>> results = apiService.quotesAnggit2();
        results.enqueue(new Callback<ArrayList<Quotes>>() {
            @Override
            public void onResponse(Call<ArrayList<Quotes>> call, Response<ArrayList<Quotes>> response) {

                lists.addAll(response.body());
                adapter.notifyDataSetChanged();
                progress.dismiss();

            }

            @Override
            public void onFailure(Call<ArrayList<Quotes>> call, Throwable t) {
                t.printStackTrace();
                progress.dismiss();
            }
        });

    }

}
