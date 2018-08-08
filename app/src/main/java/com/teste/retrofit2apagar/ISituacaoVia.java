package com.teste.retrofit2apagar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ISituacaoVia {

    @GET("/rest/api/situacaovia")
    Call<List<SituacaoVia>> getAll(@Header("Authorization") String authorization);

}