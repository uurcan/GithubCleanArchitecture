package com.example.githubapiexample.data.github

import android.content.Context
import androidx.constraintlayout.solver.Cache
import com.example.githubapiexample.model.SearchUserResult
import com.example.githubapiexample.model.User
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.internal.GsonBuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.RuntimeException
import java.util.concurrent.TimeUnit

class GithubDataSourceImpl private constructor(context : Context) : GithubDataSource {
    companion object {
        private const val CACHE_SIZE_BYTES : Long = 1024
        private const val CONNECT_TIMEOUT_SECONDS: Long = 10
        private const val BASE_URL = "https://api.github.com/"
        @Volatile
        private var instance: GithubDataSourceImpl? = null

        @Synchronized
        fun getInstance(context: Context) : GithubDataSourceImpl{
            return instance ?: GithubDataSourceImpl(context).also { instance = it }
        }
    }
    private val githubService : GithubService

    init {
        val cache = okhttp3.Cache(context.cacheDir, CACHE_SIZE_BYTES)
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .cache(cache)
            .build()

        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        githubService = retrofit.create(GithubService::class.java)
    }

    override fun searchUser(query: String): SearchUserResult {
        val response = githubService.searchUser(query).execute()
        if (response.isSuccessful){
            return response.body()!!
        } else {
            throw RuntimeException(response.message())
        }
    }

    override fun getUser(username: String): User {
        val response = githubService.getUser(username).execute()
        if (response.isSuccessful){
            return response.body()!!
        } else {
            throw RuntimeException(response.message())
        }
    }
}