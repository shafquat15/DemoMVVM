package com.example.demomvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demomvvm.R;
import com.example.demomvvm.databinding.LayoutRowUserBinding;
import com.example.demomvvm.model.Users;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private List<Users> lstUsers;

    public UsersAdapter(List<Users> lstUsers) {
        this.lstUsers = lstUsers;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutRowUserBinding userBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.layout_row_user, parent, false);
        ViewHolder viewHolder = new ViewHolder(userBinding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users users = lstUsers.get(position);
        holder.userBinding.setUser(users);

    }

    @Override
    public int getItemCount() {
        return lstUsers == null ? 0 : lstUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutRowUserBinding userBinding;

        public ViewHolder(@NonNull LayoutRowUserBinding itemView) {
            super(itemView.getRoot());
            this.userBinding = itemView;
        }
    }

    public void setUsers(List<Users> lstUsers) {
        this.lstUsers = lstUsers;
        notifyDataSetChanged();

    }
}
