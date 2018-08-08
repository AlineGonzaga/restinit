package com.teste.retrofit2apagar;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private final String baseUrl = "http://192.168.0.148";
    public  final static String NAME_PREFERENCE = "wellDude";
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText editText = findViewById(R.id.editText);

        SharedPreferences editor = getSharedPreferences(NAME_PREFERENCE, MODE_PRIVATE);
        String value = editor.getString("TOKEN", null);
        Log.i("vasasa", value);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();

        // LISTAR PRODUTOS
        ProdutoService loginService = retrofit.create(ProdutoService.class);
        Call<List<Produto>> teste = loginService.getProdutos("bearer " + value);

        teste.enqueue(new Callback<List<Produto>>() {
            @Override
            public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {
                if (response.isSuccessful()) {
                    Log.i("dsdhj", String.valueOf(response.body()));
                } else {
                    Log.i("kjdksjdks", response.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Produto>> call, Throwable t) {
                    Log.i("hdgsjhdgsh", t.getMessage());
            }
        });

        // LISTAR SITUACOES
//        ISituacaoVia situacaoVia = retrofit.create(ISituacaoVia.class);
//        Call<List<SituacaoVia>> situacoes = situacaoVia.getAll("bearer " + value);
//        situacoes.enqueue(new Callback<List<SituacaoVia>>() {
//            @Override
//            public void onResponse(Call<List<SituacaoVia>> call, Response<List<SituacaoVia>> response) {
//                if (response.isSuccessful()) {
//                    List<SituacaoVia> situations = response.body();
//
//                    editText.setText(situations.get(0).getSTV_NomeVia());
//                } else {
//                    editText.setText(response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<SituacaoVia>> call, Throwable t) {
//                editText.setText(t.getMessage());
//            }
//        });


        // INSERIR ACIDENTE
//        Acidente acidente = new Acidente();
//        acidente.setACI_NumeroOcorrencia("455/2018");
//        acidente.setACI_CLV_Id("1");
//        acidente.setACI_TPA_Id("1");
//        acidente.setACI_MatriculaAgente("99901");
//        acidente.setACI_NomeAgente("TESTE");
//        acidente.setACI_CodigoLogradouro("");
//        acidente.setACI_Logradouro("TESTE");
//        acidente.setACI_Numero("3232");
//        acidente.setACI_CodigoBairro("");
//        acidente.setACI_Bairro("TESTE");
//        acidente.setACI_Referencia("TESTE");
//        acidente.setACI_Sentido("TESTE");
//        acidente.setACI_Latitude("-222222222");
//        acidente.setACI_Longitude("-33333333333");
//        acidente.setACI_Data("18/12/2011");
//        acidente.setACI_Hora("11:22");
//        acidente.setACI_STV_Id("1");
//        acidente.setACI_STP_Id("1");
//        acidente.setACI_STF_Id("1");
//        acidente.setACI_STE_Id("1");
//        acidente.setACI_InformacaoComplemetar("TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE");
//        acidente.setACI_DataCancelamento("01/08/2018");
//        acidente.setACI_STO_Id("2");
//        acidente.setACI_MotivoCancelamento("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
//
//        IAcidente face = retrofit.create(IAcidente.class);
//        Call<String> resultado = face.postInsert("bearer " + value, acidente);
//        resultado.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if (response.isSuccessful()) {
//                    Log.i("fdfdfdf", "Daddy " + response.body());
//                    editText.setText("Daddy " + response.body());
//                } else {
//                    Log.i("sasasas", response.message());
//                    editText.setText(response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.i("rerere", t.getMessage());
//                editText.setText(t.getMessage());
//            }
//        });


        // DELETE ACIDENTE
//        IAcidente face = retrofit.create(IAcidente.class);
//        Call<String> resultado = face.deleteAcidente("bearer " + value, "459-2018");
//        resultado.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if (response.isSuccessful()) {
//                    Log.i("fdfdfdf", "Daddy " + response.body());
//                    editText.setText("Daddy " + response.body());
//                } else {
//                    Log.i("sasasas", response.message());
//                    editText.setText(response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.i("rerere", t.getMessage());
//                editText.setText(t.getMessage());
//            }
//        });

        // PUT ACIDENTE
        IAcidente face = retrofit.create(IAcidente.class);
        Call<Integer> resultado = face.putAcidente("bearer " + value, "454-2018");
        resultado.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    Log.i("fdfdfdf", "Daddy " + response.body());
                    editText.setText("Daddy " + response.body());
                } else {
                    Log.i("sasasas", response.message());
                    editText.setText(response.message());
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.i("rerere", t.getMessage());
                editText.setText(t.getMessage());
            }
        });
    }
}