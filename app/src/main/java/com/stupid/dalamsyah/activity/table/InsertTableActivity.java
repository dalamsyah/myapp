package com.stupid.dalamsyah.activity.table;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.lib.DBHelper;

public class InsertTableActivity extends AppCompatActivity {

    LinearLayout layout;
    LinearLayout ll;
    int i = 0;
    DBHelper dbHelper;
    String[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_table);

        layout = (LinearLayout) findViewById(R.id.linearLayout);
        dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor c = db.query(getIntent().getStringExtra("table"), null, null, null, null, null, null);
        arr = c.getColumnNames();

        for(int i = 0; i < arr.length; i++){
            TextView t = new TextView(this);
            EditText et = new EditText(this);

            t.setText(arr[i].toString());

            layout.addView(t);
            layout.addView(et);

        }

    }
}
