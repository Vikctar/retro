package com.vikcandroid.retrofit101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private static final String API_BASE_URL = "https://api.github.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GithubClient githubClient = retrofit.create(GithubClient.class);
        Call<List<GithubRepo>> call = githubClient.userRepos("Vikctar");

        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                List<GithubRepo> repos = response.body();
//                listView.setAdapter(new GithubRepoAdapter(MainActivity.this, repos));
                // List adapter was misbehaving and I had no time. Main aim of this thing is to work with retrofit
                // Fuck a list view, and fuck you too if you are bothered.
                for (GithubRepo list : repos) {
                    Toast.makeText(MainActivity.this, list.getName(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error :(", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
