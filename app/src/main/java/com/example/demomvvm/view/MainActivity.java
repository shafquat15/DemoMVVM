package com.example.demomvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;

import com.example.demomvvm.R;
import com.example.demomvvm.adapter.UsersAdapter;
import com.example.demomvvm.databinding.ActivityMainBinding;
import com.example.demomvvm.model.Users;
import com.example.demomvvm.viewmodel.UsersViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    UsersViewModel usersViewModel;
    ActivityMainBinding activityMainBinding;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
        usersViewModel.fetchUsers();
        usersViewModel.getLstUsers().observe(this, new Observer<List<Users>>() {
            @Override
            public void onChanged(List<Users> users) {
                if (usersAdapter != null)
                    usersAdapter.setUsers(users);
            }
        });
        activityMainBinding.rvUsers.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.rvUsers.setHasFixedSize(false);
        usersAdapter = new UsersAdapter(usersViewModel.getLstUsers().getValue());
        activityMainBinding.rvUsers.setAdapter(usersAdapter);
    }
}
