package com.example.githubapiexample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubServiceProvider {
    private val serverURL = "http://www.omdbapi.com"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(serverURL)
        .build()
    val githubAPIService = retrofit.create(GithubAPIService::class.java)
}