package com.stupid.dalamsyah.activity.anggit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.lib.res.ApiService;
import com.stupid.dalamsyah.lib.res.RetrofitClient;

import org.json.JSONObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        apiService = RetrofitClient.getClient("https://api.farra-anggit.info").create(ApiService.class);
    }

    public void btnSend2(View view){
        StringRequest sr = new StringRequest(Request.Method.POST, "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                HashMap<String, String> params2 = new HashMap<String, String>();
                params2.put("name", "Val");
                params2.put("subject", "Test Subject");
                return new JSONObject(params2).toString().getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
    }

    public void btnSend(View view){

        Call<Resutls> resutlsCall = apiService.loginAnggit(username.getText().toString(), password.getText().toString());
        resutlsCall.enqueue(new Callback<Resutls>() {
            @Override
            public void onResponse(Call<Resutls> call, retrofit2.Response<Resutls> response) {
                Log.d("LoginActivity", response.body().getStatus());
                //Toast.makeText(LoginActivity.this, call., Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Resutls> call, Throwable t) {
                Log.d("LoginActivity", t.toString());
                t.printStackTrace();
            }
        });

    }

}
