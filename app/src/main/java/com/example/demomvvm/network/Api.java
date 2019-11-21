package com.example.demomvvm.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "http://52.66.247.11/api/";

    @GET("showcategory")
    Call<ResponseBody> fetchCategory();
}
