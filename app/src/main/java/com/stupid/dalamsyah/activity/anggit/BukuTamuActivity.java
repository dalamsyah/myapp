package com.stupid.dalamsyah.activity.anggit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.activity.booking.dialog.ProgressDialog;
import com.stupid.dalamsyah.lib.res.ApiService;
import com.stupid.dalamsyah.lib.res.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BukuTamuActivity extends AppCompatActivity {

    private ApiService apiService;
    private BukuTamuAdapter adapter;
    private List<BukuTamuResults> lists = new ArrayList<>();
    BukuTamuResults bukuTamuResults;
    RecyclerView recyclerView;
    private DialogFragment progress;
    String[] options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        apiService = RetrofitClient.getClient("https://api.farra-anggit.info").create(ApiService.class);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        progress = new ProgressDialog();

        adapter = new BukuTamuAdapter(lists, new BukuTamuAdapter.OnItemClickListener() {
            @Override
            public void OnClick(final BukuTamuResults buku) {

                options = new String[]{"Show", "Edit"};

                if(!buku.getOwner().equals( Preferences.getStatusUser(BukuTamuActivity.this) )){
                    options = new String[]{"Show"};
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(BukuTamuActivity.this);
                builder.setTitle("Option");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if("Show".equals(options[which])){

                            Intent i = new Intent(BukuTamuActivity.this, BukuTamuAddActivity.class);
                            i.putExtra("id", buku.getId());
                            i.putExtra("nama", buku.getName());
                            i.putExtra("username", buku.getUsername());
                            i.putExtra("remark", buku.getRemark());
                            i.putExtra("show", true);
                            startActivityForResult(i, 1);

                        }else if ("Edit".equals(options[which])){

                            Intent i = new Intent(BukuTamuActivity.this, BukuTamuAddActivity.class);
                            i.putExtra("id", buku.getId());
                            i.putExtra("nama", buku.getName());
                            i.putExtra("username", buku.getUsername());
                            i.putExtra("remark", buku.getRemark());
                            i.putExtra("show", false);
                            startActivityForResult(i, 1);

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

    public void btnBack(View view){
        finish();
    }

    public void add(View view){
        Intent i = new Intent(this, BukuTamuAddActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            lists.clear();
            load();
        }

    }

    public void load(){

        progress.show(getSupportFragmentManager(), "progress");

        Call<ArrayList<BukuTamuResults>> results = apiService.bukutamuAnggit();
        results.enqueue(new Callback<ArrayList<BukuTamuResults>>() {
            @Override
            public void onResponse(Call<ArrayList<BukuTamuResults>> call, Response<ArrayList<BukuTamuResults>> response) {

                lists.addAll(response.body());
                adapter.notifyDataSetChanged();
                progress.dismiss();

            }

            @Override
            public void onFailure(Call<ArrayList<BukuTamuResults>> call, Throwable t) {
                t.printStackTrace();
                progress.dismiss();
            }
        });

    }


}
