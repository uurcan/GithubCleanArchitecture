package com.example.githubapiexample;

import retrofit2.Call

import retrofit2.http.GET;

interface GithubAPIService {
    @GET("users")
    fun getUser(user: String?): Call<User>
}
