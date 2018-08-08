package com.teste.retrofit2apagar;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.util.ArrayList;
import java.util.List;

public interface ProdutoService {

    @GET("/rest/api/produtos")
    Call<List<Produto>> getProdutos(@Header("Authorization") String authorization);
}