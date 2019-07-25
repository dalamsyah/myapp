package com.stupid.dalamsyah.activity.anggit;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.activity.booking.dialog.ProgressDialog;
import com.stupid.dalamsyah.lib.res.ApiService;
import com.stupid.dalamsyah.lib.res.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuotesAddActivity extends AppCompatActivity {

    private EditText author;
    private EditText quotes;
    private String id;
    private boolean editFlag = false;
    private DialogFragment progress;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_add);

        author = (EditText) findViewById(R.id.author);
        quotes = (EditText) findViewById(R.id.quotes);

        apiService = RetrofitClient.getClient("https://api.farra-anggit.info").create(ApiService.class);
        progress = new ProgressDialog();

        Intent i = getIntent();
        if(i.getExtras() != null){
            author.setText( i.getStringExtra("author") );
            quotes.setText( i.getStringExtra("quotes") );
            id = i.getStringExtra("id");

            editFlag = true;

            if(i.getBooleanExtra("show", false)){
                author.setEnabled(false);
                quotes.setEnabled(false);

                Button btnsend = (Button) findViewById(R.id.btnSend);
                btnsend.setVisibility(View.GONE);

            }

        }

    }

    public void btnBack(View view){
        finish();
    }

    public void btnSend(View view){

        progress.show(getSupportFragmentManager(), "progress");

        if (editFlag){

            Call<ResultsInsert> results = apiService.updateQuotes(
                    id,
                    author.getText().toString(),
                    quotes.getText().toString(),
                    Preferences.getStatusUser(QuotesAddActivity.this));
            results.enqueue(new Callback<ResultsInsert>() {
                @Override
                public void onResponse(Call<ResultsInsert> call, Response<ResultsInsert> response) {
                    Toast.makeText(QuotesAddActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    progress.dismiss();
                }

                @Override
                public void onFailure(Call<ResultsInsert> call, Throwable t) {
                    progress.dismiss();
                    t.printStackTrace();
                }
            });

        }else{
            Call<ResultsInsert> results = apiService.insertQuotes(
                    author.getText().toString(),
                    quotes.getText().toString(),
                    Preferences.getStatusUser(QuotesAddActivity.this));
            results.enqueue(new Callback<ResultsInsert>() {
                @Override
                public void onResponse(Call<ResultsInsert> call, Response<ResultsInsert> response) {
                    Toast.makeText(QuotesAddActivity.this, "Success", Toast.LENGTH_SHORT).show();
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
