package com.stupid.dalamsyah.activity.anggit;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.activity.booking.dialog.ProgressDialog;
import com.stupid.dalamsyah.lib.res.ApiService;
import com.stupid.dalamsyah.lib.res.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BukuTamuAddActivity extends AppCompatActivity {

    private EditText name;
    private EditText username;
    private EditText remark;
    private boolean editFlag = false;
    private DialogFragment progress;
    private ApiService apiService;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_tamu_add);

        name = (EditText) findViewById(R.id.nama);
        username = (EditText) findViewById(R.id.username);
        remark = (EditText) findViewById(R.id.remark);

        apiService = RetrofitClient.getClient("https://api.farra-anggit.info").create(ApiService.class);
        progress = new ProgressDialog();

        Intent i = getIntent();
        if(i.getExtras() != null){
            id = i.getStringExtra("id");
            name.setText( i.getStringExtra("nama") );
            username.setText( i.getStringExtra("username") );
            remark.setText( i.getStringExtra("remark") );

            if(i.getBooleanExtra("show", false)){
                name.setEnabled(false);
                username.setEnabled(false);
                remark.setEnabled(false);

                Button btnsend = (Button) findViewById(R.id.btnSend);
                btnsend.setVisibility(View.GONE);

            }

            editFlag = true;
        }

    }

    public void btnBack(View view){
        finish();
    }

    public void btnSend(View view){


        progress.show(getSupportFragmentManager(), "progress");

        if (editFlag){

            Call<BukuTamuResults> results = apiService.updateBukuTamu(
                    id,
                    name.getText().toString(),
                    username.getText().toString(),
                    remark.getText().toString(),
                    Preferences.getStatusUser(BukuTamuAddActivity.this));
            results.enqueue(new Callback<BukuTamuResults>() {
                @Override
                public void onResponse(Call<BukuTamuResults> call, Response<BukuTamuResults> response) {
                    Toast.makeText(BukuTamuAddActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    progress.dismiss();
                }

                @Override
                public void onFailure(Call<BukuTamuResults> call, Throwable t) {
                    progress.dismiss();
                    t.printStackTrace();
                }
            });
        }else {

            Call<ResultsInsert> results = apiService.insertBukuTamu(
                    name.getText().toString(),
                    username.getText().toString(),
                    remark.getText().toString(),
                    Preferences.getStatusUser(BukuTamuAddActivity.this));
            results.enqueue(new Callback<ResultsInsert>() {
                @Override
                public void onResponse(Call<ResultsInsert> call, Response<ResultsInsert> response) {
                    Toast.makeText(BukuTamuAddActivity.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
                    progress.dismiss();
                }

                @Override
                public void onFailure(Call<ResultsInsert> call, Throwable t) {
                    progress.dismiss();
                    t.printStackTrace();
                }
            });

        }

        setResult(RESULT_OK);
        finish();

    }



}
