package com.example.demomvvm.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://reqres.in/api/";

    @GET("users/?per_page=12&amp;page=1")
    Call<ResponseBody> fetchUsers();
}
