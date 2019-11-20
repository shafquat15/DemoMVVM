package com.example.demomvvm.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

public class Users {


    private int id;
    @SerializedName("email")
    private String email="";
    @SerializedName("first_name")
    private String firstName="";
    @SerializedName("last_name")
    private String lastName="";
    private String avatar="";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @BindingAdapter({"avatar"})
    public static  void loadImage(ImageView imageView, String url) {
        Picasso.get().load(url).into(imageView);
    }
}
