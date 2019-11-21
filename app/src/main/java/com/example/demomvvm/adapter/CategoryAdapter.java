package com.example.demomvvm.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demomvvm.R;

import com.example.demomvvm.databinding.LayoutRowCategoryBinding;
import com.example.demomvvm.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category> lstcategory;

    public CategoryAdapter(List<Category> lstCategory) {
        this.lstcategory = lstCategory;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutRowCategoryBinding userBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.layout_row_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(userBinding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Category category = lstcategory.get(position);
        holder.categoryBinding.setCategory(category);

    }

    @Override
    public int getItemCount() {
        return lstcategory == null ? 0 : lstcategory.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutRowCategoryBinding categoryBinding;

        public ViewHolder(@NonNull LayoutRowCategoryBinding itemView) {
            super(itemView.getRoot());
            this.categoryBinding = itemView;
        }
    }

    public void setCategory(List<Category> lstcategory) {
        this.lstcategory = lstcategory;
        notifyDataSetChanged();

    }
}
