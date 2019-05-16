package com.stupid.dalamsyah.activity.table;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.lib.DBHelper;

import java.util.HashMap;

public class CreateTableActivity extends AppCompatActivity {

    LinearLayout layout;
    LinearLayout ll;
    int i = 0;
    DBHelper dbHelper;

    HashMap<String, String> list = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_table);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnSave = (Button) findViewById(R.id.btnSave);
        final EditText tableName = (EditText) findViewById(R.id.tableName);
        layout = (LinearLayout) findViewById(R.id.linearLayout);

        dbHelper = new DBHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText fieldName = (EditText) findViewById(R.id.fielName);
                Spinner type = (Spinner) findViewById(R.id.type);

                String sql = "CREATE TABLE "+tableName.getText().toString()+" ( "+
                        BaseColumns._ID +" INTEGER PRIMARY KEY, "+
                        fieldName.getText().toString()+" "+type.getSelectedItem().toString()+", ";

                for(int a = 1; a <= i; a++){
                    EditText et = (EditText) layout.findViewWithTag("et_"+a);
                    Spinner sp = (Spinner) layout.findViewWithTag("sp_"+a);

                    if(a == i){
                        sql += et.getText().toString()+" "+ sp.getSelectedItem().toString() +" ";
                    }else{
                        sql += et.getText().toString()+" "+ sp.getSelectedItem().toString() +", ";
                    }

                }

                sql += " )";

                SQLiteDatabase db = dbHelper.getWritableDatabase();

                try {
                    db.execSQL(sql);
                    Toast.makeText(CreateTableActivity.this, "Sukses buat tabel!", Toast.LENGTH_SHORT).show();
                } catch (SQLException e) {
                    e.printStackTrace();
                    Toast.makeText(CreateTableActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }

                Log.d("CreateTableActivity", sql);

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i++;

                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

                LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

                LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

                // Create a LinearLayout element
                ll = new LinearLayout(CreateTableActivity.this);
                ll.setLayoutParams(param1);
                ll.setOrientation(LinearLayout.HORIZONTAL);

                // Add
                EditText et = new EditText(CreateTableActivity.this);
                et.setHint("Nama Field");
                et.setLayoutParams(param);
                et.setTag("et_"+i);
                ll.addView(et);

                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(CreateTableActivity.this, R.array.field, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                Spinner sp = new Spinner(CreateTableActivity.this);
                sp.setAdapter(adapter);
                sp.setTag("sp_"+i);
                sp.setLayoutParams(param2);
                ll.addView(sp);

                // Add the LinearLayout
                layout.addView(ll);

            }
        });

    }



}
