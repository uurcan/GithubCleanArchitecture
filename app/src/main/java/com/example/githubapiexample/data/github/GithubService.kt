package com.example.githubapiexample.data.github

import com.example.githubapiexample.model.SearchUserResult
import com.example.githubapiexample.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("search/users")
    fun searchUser(@Query("q") query: String): Call<SearchUserResult>

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Call<User>
}