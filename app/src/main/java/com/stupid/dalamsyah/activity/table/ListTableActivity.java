package com.stupid.dalamsyah.activity.table;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.lib.DBHelper;
import com.stupid.dalamsyah.lib.adapter.BasicAdapter;

import java.util.ArrayList;

public class ListTableActivity extends AppCompatActivity implements BasicAdapter.onItemClickListener{

    BasicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_table);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' and name != 'android_metadata'", null);

        ArrayList<String> list = new ArrayList<String>();

        c.moveToFirst();
        while (c.isAfterLast() == false) {
            list.add(c.getString(c.getColumnIndex("name")));
            c.moveToNext();
        }
        c.close();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BasicAdapter(this, list);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {

        Intent i = new Intent(ListTableActivity.this, ValueTableActivity.class);
        i.putExtra("table", adapter.getItem(position));
        startActivity(i);

    }
}
