package com.stupid.dalamsyah.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.lib.table.DynamicTable;

public class DynamicTableActivity extends AppCompatActivity {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DynamicTable.Field.TABLE_NAME ;

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DynamicTable.Field.TABLE_NAME;

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_table);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnSave = (Button) findViewById(R.id.btnSave);
        layout = (LinearLayout) findViewById(R.id.linearLayout);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a LinearLayout element
                LinearLayout ll = new LinearLayout(DynamicTableActivity.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);

                // Add text
                TextView tv = new TextView(DynamicTableActivity.this);
                tv.setText("my text");

                ll.addView(tv);

                // Add the LinearLayout element to the ScrollView
                layout.addView(ll);

            }
        });

    }



}
