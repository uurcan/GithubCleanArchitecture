package com.example.githubapiexample;

import retrofit2.Call
import retrofit2.http.GET;
import retrofit2.http.Path

interface GithubAPIService {
    @GET("users/{login}")
    fun getUser(@Path("login") username:String?): Call<User>
}
