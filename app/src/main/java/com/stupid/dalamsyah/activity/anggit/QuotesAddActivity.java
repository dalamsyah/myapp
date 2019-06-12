package com.stupid.dalamsyah.activity.anggit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.stupid.dalamsyah.R;

public class QuotesAddActivity extends AppCompatActivity {

    private EditText author;
    private EditText quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_add);

        author = (EditText) findViewById(R.id.author);
        quotes = (EditText) findViewById(R.id.quotes);

        Intent i = getIntent();
        if(i != null){
            author.setText( i.getStringExtra("author") );
            quotes.setText( i.getStringExtra("quotes") );
        }

    }

    public void btnBack(View view){
        finish();
    }

    public void btnSend(View view){

    }

}
