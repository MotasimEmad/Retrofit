package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int user_id;
    private Integer id;
    private String title;
    @SerializedName("body")
    private String text;

    public Post(int user_id, String title, String text) {
        this.user_id = user_id;
        this.title = title;
        this.text = text;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
