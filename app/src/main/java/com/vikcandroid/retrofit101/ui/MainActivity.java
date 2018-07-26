package com.vikcandroid.retrofit101.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.vikcandroid.retrofit101.R;
import com.vikcandroid.retrofit101.api.ServiceGenerator;
import com.vikcandroid.retrofit101.api.model.GithubRepo;
import com.vikcandroid.retrofit101.api.service.GithubClient;
import com.vikcandroid.retrofit101.ui.adapter.GithubRepoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);


        GithubClient githubClient = ServiceGenerator.createService(GithubClient.class);
        Call<List<GithubRepo>> call = githubClient.userRepos("Vikctar");

        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                List<GithubRepo> repos = response.body();

                listView.setAdapter(new GithubRepoAdapter(MainActivity.this, repos));

            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error :(", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
