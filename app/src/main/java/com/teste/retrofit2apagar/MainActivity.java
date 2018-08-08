package com.teste.retrofit2apagar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String baseUrl = "http://192.168.0.148";
    public  final static String NAME_PREFERENCE = "wellDude";
    private EditText edtLogin, edtPassword;
    private Button btnLogar;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLogin = findViewById(R.id.edtLogin);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogar = findViewById(R.id.btnLogar);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog progress = new ProgressDialog(context);
                progress.setCancelable(false);
                progress.setMessage("Carregando...");
                progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progress.setIndeterminate(true);
                progress.show();

                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(baseUrl)
                        .build();

                LoginService loginService = retrofit.create(LoginService.class);

                Call<Token> token = loginService.login("password", edtLogin.getText().toString(), edtPassword.getText().toString());
                token.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        if (response.isSuccessful()) {
                            Token rs = response.body();
                            Log.i("dsdsd", rs.toString());

                            SharedPreferences.Editor editor = getSharedPreferences(NAME_PREFERENCE, MODE_PRIVATE).edit();
                            editor.putString("TOKEN", rs.getAccess_token());
                            editor.commit();

                            if (progress.isShowing()) {
                                progress.dismiss();
                            }

                            startActivity(new Intent(MainActivity.this, Main2Activity.class));
                        } else {
                            Log.i("hdjhjf", response.message());
                            if (progress.isShowing()) {
                                progress.dismiss();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Log.i("dsdsdrr", t.getMessage());
                        if (progress.isShowing()) {
                            progress.dismiss();
                        }
                    }
                });

            }
        });
    }
}