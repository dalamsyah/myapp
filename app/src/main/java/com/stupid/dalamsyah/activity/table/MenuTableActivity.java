package com.stupid.dalamsyah.activity.table;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.stupid.dalamsyah.R;

public class MenuTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_table);
    }

    public void gotoCreateTable(View v){
        Intent i = new Intent(MenuTableActivity.this, CreateTableActivity.class);
        startActivity(i);
    }

    public void gotoShowTable(View v){
        Intent i = new Intent(MenuTableActivity.this, ListTableActivity.class);
        startActivity(i);
    }

}
