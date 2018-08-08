package com.teste.retrofit2apagar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginService {

    @FormUrlEncoded
    @Headers( {"content-type: application/x-www-form-urlencoded;charset=UTF-8", })
    @POST("rest/api/security/token")
    Call<Token> login(
            @Field("grant_type") String grant_type,
            @Field("username")  String username,
            @Field("password") String password
    );
}