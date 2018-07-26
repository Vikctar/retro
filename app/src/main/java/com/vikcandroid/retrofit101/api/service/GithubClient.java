package com.vikcandroid.retrofit101.api.service;


import com.vikcandroid.retrofit101.api.model.GithubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by android-dev on 7/28/17.
 */

public interface GithubClient {
    @GET("/users/{user}/repos")
    Call<List<GithubRepo>> userRepos(
            @Path("user") String user
    );
}
