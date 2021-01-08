package com.example.retrofit;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceholderAPI {

    @GET("Post")
    Call<List<Post>> getPosts();

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String, String> fields);
}
