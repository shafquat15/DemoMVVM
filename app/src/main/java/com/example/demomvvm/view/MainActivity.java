package com.example.demomvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.demomvvm.R;
import com.example.demomvvm.adapter.CategoryAdapter;
import com.example.demomvvm.databinding.ActivityMainBinding;
import com.example.demomvvm.model.Category;
import com.example.demomvvm.viewmodel.CategoryViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    CategoryViewModel categoryViewModel;
    ActivityMainBinding activityMainBinding;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        categoryViewModel.fetchCategory();
        categoryViewModel.getLstCategory().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
               categoryAdapter.setCategory(categories);

            }
        });
        activityMainBinding.rvCategory.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.rvCategory.setHasFixedSize(false);
        categoryAdapter = new CategoryAdapter(categoryViewModel.getLstCategory().getValue());
        activityMainBinding.rvCategory.setAdapter(categoryAdapter);
    }
}
