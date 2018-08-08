package com.teste.retrofit2apagar;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IAcidente {
    @POST("/rest/api/acidente")
    Call<String> postInsert(@Header("Authorization") String authorization, @Body Acidente acidente);

    @DELETE("/rest/api/acidente/{id}")
    Call<String> deleteAcidente(
            @Header("Authorization") String authorization,
            @Path("id") String id
    );

    @PUT("/rest/api/acidente/{id}")
    Call<Integer> putAcidente(
            @Header("Authorization") String authorization,
            @Path("id") String id
    );
}