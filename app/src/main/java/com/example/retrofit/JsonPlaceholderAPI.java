package com.example.retrofit;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JsonPlaceholderAPI {

    @GET("posts")
    Call<List<Post>> getPosts();

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String, String> fields);

    @PUT("posts/{id}")
    Call<Post> PutPost(@Path("id") int id, @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> PatchPost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> DeletePost(@Path("id") int id);
}
