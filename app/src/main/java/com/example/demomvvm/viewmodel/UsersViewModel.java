package com.example.demomvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demomvvm.model.Users;
import com.example.demomvvm.network.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersViewModel extends ViewModel {
    private MutableLiveData<List<Users>> lstUsers = new MutableLiveData<>();

    public MutableLiveData<List<Users>> getLstUsers() {
        return lstUsers;
    }

    public void setLstUsers(MutableLiveData<List<Users>> lstUsers) {
        this.lstUsers = lstUsers;
    }

    public void fetchUsers() {
        Call<ResponseBody> call = RetrofitClient.getInstance().fetchUsers();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if(response.isSuccessful())
                {
                    try {
                        JSONObject jsonObject=new JSONObject(response.body().string());
                        if(jsonObject.has("data"))
                        {
                            Gson gson=new Gson();
                            Type type = new TypeToken<List<Users>>(){}.getType();
                            List<Users> lst=gson.fromJson(jsonObject.get("data").toString(),type);
                            lstUsers.setValue(lst);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
}
