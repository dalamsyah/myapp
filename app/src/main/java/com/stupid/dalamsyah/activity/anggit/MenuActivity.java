package com.stupid.dalamsyah.activity.anggit;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.activity.booking.dialog.ProgressDialog;
import com.stupid.dalamsyah.lib.res.ApiService;
import com.stupid.dalamsyah.lib.res.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {

    private ApiService apiService;
    private DialogFragment progress;
    private TextView cowok, cewek, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cowok = (TextView) findViewById(R.id.cowok);
        cewek = (TextView) findViewById(R.id.cewek);
        total = (TextView) findViewById(R.id.total);

        apiService = RetrofitClient.getClient("https://api.farra-anggit.info").create(ApiService.class);
        progress = new ProgressDialog();

        getTotal(null);

    }

    public void gotoBuku(View v){
        Intent i = new Intent(this, BukuTamuActivity.class);
        startActivity(i);
    }

    public void gotoQuotes(View v){
        Intent i = new Intent(this, QuotesActivity.class);
        startActivity(i);
    }

    public void getTotal(View v){
        progress.show(getSupportFragmentManager(), "progress");

        Call<ResultsTotal> results = apiService.bukutamu_total();
        results.enqueue(new Callback<ResultsTotal>() {
            @Override
            public void onResponse(Call<ResultsTotal> call, Response<ResultsTotal> response) {

                int to = Integer.valueOf(response.body().getCowok()) + Integer.valueOf(response.body().getCewek());

                cowok.setText(response.body().getCowok());
                cewek.setText(response.body().getCewek());
                total.setText("Total: " + to);
                progress.dismiss();

            }

            @Override
            public void onFailure(Call<ResultsTotal> call, Throwable t) {
                t.printStackTrace();
                progress.dismiss();
            }
        });

    }

}
