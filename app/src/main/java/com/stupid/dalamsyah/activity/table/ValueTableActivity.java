package com.stupid.dalamsyah.activity.table;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.lib.DBHelper;

public class ValueTableActivity extends AppCompatActivity {

    TableLayout tableLayout;
    DBHelper dbHelper;
    SQLiteDatabase db;
    Cursor c;
    String[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_table);

        tableLayout = (TableLayout) findViewById(R.id.tableLayout);

        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();

        c = db.query(getIntent().getStringExtra("table"), null, null, null, null, null, null);
        arr = c.getColumnNames();

        TableRow.LayoutParams ll = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

        TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(ll);
        tableRow.setBackgroundColor(Color.BLACK);
        tableRow.setPadding(0, 0, 0, 2); //Border between rows

        for(int i = 0; i < arr.length; i++){

            TableRow.LayoutParams llp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
            llp.setMargins(0, 0, 2, 0);//2px right-margin

            LinearLayout cell = new LinearLayout(this);
            cell.setBackgroundColor(Color.WHITE);
            cell.setLayoutParams(llp);//2px border on the right for the cell

            TextView field = new TextView(this);
            field.setTag("field_"+i);
            field.setText(arr[i]);
            field.setPadding(10, 10, 10, 10);

            cell.addView(field);

            tableRow.addView(cell);

        }

        tableLayout.addView(tableRow);

        footer();

    }

    private void footer(){




        c.moveToFirst();
        while (c.isAfterLast() == false) {
            //list.add(c.getString(c.getColumnIndex("name")));

            TableRow.LayoutParams ll = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(ll);
            tableRow.setBackgroundColor(Color.BLACK);
            tableRow.setPadding(0, 0, 0, 2); //Border between rows

            for(int i = 0; i < arr.length; i++){

                TableRow.LayoutParams llp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                llp.setMargins(0, 0, 2, 0);//2px right-margin

                LinearLayout cell = new LinearLayout(this);
                cell.setBackgroundColor(Color.WHITE);
                cell.setLayoutParams(llp);//2px border on the right for the cell

                TextView field = new TextView(this);
                field.setTag("value_"+i);
                field.setText(c.getString(c.getColumnIndex(arr[i])));
                field.setPadding(10, 10, 10, 10);

                cell.addView(field);

                tableRow.addView(cell);


            }

            tableLayout.addView(tableRow);

            c.moveToNext();
        }
        c.close();


    }
}
