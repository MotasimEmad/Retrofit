package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewPosts;
    JsonPlaceholderAPI mJsonPlaceholderAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPosts = findViewById(R.id.TextPosts);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mJsonPlaceholderAPI = retrofit.create(JsonPlaceholderAPI.class);

        GetPost();
        // CreatePost();
        // PutPost();
        // PatchPost();
        // DeletePost();
    }

    private void DeletePost() {
        Call<Void> call = mJsonPlaceholderAPI.DeletePost(5);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                textViewPosts.setText("Code: " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                textViewPosts.setText(t.getMessage());
            }
        });
    }

    private void PatchPost() {
        Post post = new Post(5, null, "Update Body");
        Call<Post> call = mJsonPlaceholderAPI.PatchPost(5, post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textViewPosts.setText("Code: " + response.code());
                    return;
                }

                Post post = response.body();
                String content = "";
                content += "ID: " + post.getId() + "\n";
                content += "UsetID: " + post.getUser_id() + "\n";
                content += "Title: " + post.getTitle() + "\n";
                content += "Text: " + post.getText() + "\n\n";

                textViewPosts.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewPosts.setText(t.getMessage());
            }
        });
    }

    private void PutPost() {
        Post post = new Post(5,null,"Update Body");
        Call<Post> call = mJsonPlaceholderAPI.PutPost(5, post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textViewPosts.setText("Code: " + response.code());
                    return;
                }

                Post post = response.body();
                String content = "";
                content += "ID: " + post.getId() + "\n";
                content += "UsetID: " + post.getUser_id() + "\n";
                content += "Title: " + post.getTitle() + "\n";
                content += "Text: " + post.getText() + "\n\n";

                textViewPosts.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewPosts.setText(t.getMessage());
            }
        });
    }

    private void CreatePost() {
       // Post post = new Post(100, "Title Test", "Text Test");

        Map<String, String> fields = new HashMap<>();
        fields.put("Name", "Griso");
        fields.put("Phone_number", "033321");
        fields.put("Password", "123");

        Call<Post> call = mJsonPlaceholderAPI.createPost(fields);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textViewPosts.setText("Code: " + response.code());
                    return;
                }

                Post post = response.body();
                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + post.getId() + "\n";
                content += "UsetID: " + post.getUser_id() + "\n";
                content += "Title: " + post.getTitle() + "\n";
                content += "Text: " + post.getText() + "\n\n";

                textViewPosts.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewPosts.setText(t.getMessage());
            }
        });
    }

    public void GetPost() {
        Call<List<Post>> call = mJsonPlaceholderAPI.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewPosts.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();
                for (Post post: posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "UsetID: " + post.getUser_id() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";

                    textViewPosts.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewPosts.setText(t.getMessage());
            }
        });
    }
}
