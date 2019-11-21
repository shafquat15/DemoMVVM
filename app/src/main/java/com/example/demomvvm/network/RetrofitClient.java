package com.example.demomvvm.network;

import com.google.gson.Gson;

import retrofit2.Retrofit;

import static com.example.demomvvm.network.Api.BASE_URL;

public class RetrofitClient {

    private static Retrofit retrofitClient;


    public static Api getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofitClient.create(Api.class);
    }
}
