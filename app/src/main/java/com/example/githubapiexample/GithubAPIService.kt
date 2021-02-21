package com.example.githubapiexample;

import retrofit2.Call
import retrofit2.http.GET;
import retrofit2.http.Path

interface GithubAPIService {
    @GET("/apikey=f31eb4f6")
    fun getUser(@Path("s") search:String?): Call<User>
}
