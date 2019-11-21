package com.example.demomvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demomvvm.model.Category;
import com.example.demomvvm.network.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryViewModel extends ViewModel {
    private MutableLiveData<List<Category>> lstCategory = new MutableLiveData<>();

    public MutableLiveData<List<Category>> getLstCategory() {
        return lstCategory;
    }

    public void setLstCategory(MutableLiveData<List<Category>> lstCategory) {
        this.lstCategory = lstCategory;
    }

    public void fetchCategory() {
        Call<ResponseBody> call = RetrofitClient.getInstance().fetchCategory();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if(response.isSuccessful())
                {
                    try {

                            Gson gson=new Gson();
                            Type type = new TypeToken<List<Category>>(){}.getType();
                            List<Category> lst=gson.fromJson(response.body().string(),type);
                            lstCategory.setValue(lst);

                    } catch (IOException e) {
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
